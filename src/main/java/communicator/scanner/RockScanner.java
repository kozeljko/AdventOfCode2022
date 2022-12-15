package communicator.scanner;

import parser.RockStructureParser;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RockScanner {
    private final List<RockStructure> rockStructures = new ArrayList<>();
    private final Set<Point> sandLocations = new HashSet<>();
    private int lowestYLocation;

    public void init(String inputFile) {
        rockStructures.addAll(new RockStructureParser().parse(inputFile));
        lowestYLocation = rockStructures.stream().mapToInt(RockStructure::getLowestY).max().orElseThrow();
    }

    public void simulateSand() {
        final Point startingPoint = new Point(500, 0);

        while (true) {
            var sandPoint = startingPoint;

            while (true) {
                var options = List.of(sandPoint.moveDown(), sandPoint.moveDownLeft(), sandPoint.moveDownRight());
                var newState = options.stream().filter(o -> isFree(o, false)).findFirst().orElse(null);

                if (newState == null) {
                    sandLocations.add(sandPoint);
                    break;
                } else {
                    if (isInAbyss(newState.y())) {
                        return;
                    }

                    sandPoint = newState;
                }
            }
        }
    }

    public void simulateSandReal() {
        final Point startingPoint = new Point(500, 0);

        while (true) {
            var sandPoint = startingPoint;

            while (true) {
                var options = List.of(sandPoint.moveDown(), sandPoint.moveDownLeft(), sandPoint.moveDownRight());
                var newState = options.stream().filter(o -> isFree(o, true)).findFirst().orElse(null);

                if (newState == null) {
                    sandLocations.add(sandPoint);

                    if (sandPoint.equals(startingPoint)) {
                        return;
                    }

                    break;
                } else {
                    sandPoint = newState;
                }
            }
        }
    }

    private boolean isFree(Point point, boolean finiteFloor) {
        if (sandLocations.contains(point)) {
            return false;
        }

        if (finiteFloor) {
            if (point.y() == lowestYLocation + 2) {
                return false;
            }
        }

        return rockStructures.stream().allMatch(o -> o.isFree(point));
    }

    private boolean isInAbyss(int y) {
        return y == lowestYLocation;
    }

    public int countSandGrains() {
        return sandLocations.size();
    }
}
