package games.ropeplay;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.IntStream;

public class RopeGame {
    private final List<RopeLocation> ropeChain = new ArrayList<>();
    private final Set<RopeLocation> tailLocations = new HashSet<>();

    public RopeGame(int ropeLength) {
        for (int i = 0; i < ropeLength; i++) {
            ropeChain.add(new RopeLocation(0, 0));
        }
    }

    public void move(List<String> commands) {
        for (String command : commands) {
            var movementFunctions = parseMovementCommands(command);

            for (Function<RopeLocation, RopeLocation> movement : movementFunctions) {
                List<RopeLocation> newRopeChain = new ArrayList<>();

                for (int i = 0; i < ropeChain.size(); i++) {
                    RopeLocation ropeLocation = ropeChain.get(i);
                    if (i == 0) {
                        // Head
                        newRopeChain.add(movement.apply(ropeLocation));
                    } else {
                        RopeLocation newRopeLocation = ropeLocation.moveTowardsTarget(newRopeChain.get(i - 1));
                        newRopeChain.add(newRopeLocation);

                        if (i == ropeChain.size() - 1) {
                            // Tail
                            tailLocations.add(newRopeLocation);
                        }
                    }
                }

                ropeChain.clear();
                ropeChain.addAll(newRopeChain);
            }
        }
    }

    private List<Function<RopeLocation, RopeLocation>> parseMovementCommands(String command) {
        var splits = command.split(" ");

        Function<RopeLocation, RopeLocation> locationMapper = switch (splits[0]) {
            case "U" -> RopeLocation::moveUp;
            case "R" -> RopeLocation::moveRight;
            case "D" -> RopeLocation::moveDown;
            case "L" -> RopeLocation::moveLeft;
            default -> throw new UnsupportedOperationException("Unknown %s".formatted(splits[0]));
        };

        return IntStream.generate(() -> 1).limit(Integer.parseInt(splits[1])).mapToObj(o -> locationMapper).toList();
    }

    public Integer getNumberOfTailLocations() {
        return tailLocations.size();
    }
}
