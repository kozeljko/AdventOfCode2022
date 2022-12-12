package items;

public record Hill(int x, int y, String mark) {

    public int height() {
        if (mark.equals("S")) {
            return 'a';
        }

        if (mark.equals("E")) {
            return 'z';
        }

        return mark.charAt(0);
    }

    public boolean canMoveTo(Hill otherHill) {
        return otherHill.height() <= height() + 1;
    }
}
