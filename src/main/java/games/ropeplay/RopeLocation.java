package games.ropeplay;

public record RopeLocation(int x, int y) {

    public RopeLocation moveUp() {
        return new RopeLocation(x + 1, y);
    }

    public RopeLocation moveRight() {
        return new RopeLocation(x, y + 1);
    }

    public RopeLocation moveDown() {
        return new RopeLocation(x - 1, y);
    }

    public RopeLocation moveLeft() {
        return new RopeLocation(x, y - 1);
    }

    public RopeLocation moveTowardsTarget(RopeLocation targetRopeLocation) {
        int verticalDifference = targetRopeLocation.x - x;
        int horizontalDifference = targetRopeLocation.y - y;

        // If location is not too far away, don't move.
        if (Math.abs(verticalDifference) < 2 && Math.abs(horizontalDifference) < 2) {
            return this;
        }

        int verticalAdjustment = verticalDifference == 0 ? 0 : verticalDifference / Math.abs(verticalDifference);
        int horizontalAdjustment = horizontalDifference == 0 ? 0 : horizontalDifference / Math.abs(horizontalDifference);

        return new RopeLocation(x + verticalAdjustment, y + horizontalAdjustment);
    }
}
