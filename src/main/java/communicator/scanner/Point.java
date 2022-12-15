package communicator.scanner;

public record Point(int x, int y) {

    public Point moveDown() {
        return new Point(x, y + 1);
    }

    public Point moveDownLeft() {
        return new Point(x - 1, y + 1);
    }

    public Point moveDownRight() {
        return new Point(x + 1, y + 1);
    }
}
