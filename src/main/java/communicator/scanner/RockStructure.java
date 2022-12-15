package communicator.scanner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class RockStructure {
    private final Set<Point> allPoints;
    private final int lowestY;

    public RockStructure(List<Point> structurePoints) {
        this.allPoints = interpolatePairs(structurePoints);
        this.lowestY = structurePoints.stream().mapToInt(Point::y).max().orElseThrow();
    }

    private Set<Point> interpolatePairs(List<Point> structurePoints) {
        Set<Point> points = new HashSet<>(structurePoints);

        for (int i = 0; i < structurePoints.size() - 1; i++) {
            Point firstPoint = structurePoints.get(i);
            Point secondPoint = structurePoints.get(i + 1);

            if (firstPoint.x() == secondPoint.x()) {
                IntStream.range(Math.min(firstPoint.y(), secondPoint.y()), Math.max(firstPoint.y(), secondPoint.y())).mapToObj(o -> new Point(firstPoint.x(), o)).forEach(points::add);
            } else if (firstPoint.y() == secondPoint.y()) {

                IntStream.range(Math.min(firstPoint.x(), secondPoint.x()), Math.max(firstPoint.x(), secondPoint.x())).mapToObj(o -> new Point(o, firstPoint.y())).forEach(points::add);
            } else {
                throw new UnsupportedOperationException();
            }
        }

        return points;
    }

    public boolean isFree(Point point) {
        return !allPoints.contains(point);
    }

    public int getLowestY() {
        return lowestY;
    }
}
