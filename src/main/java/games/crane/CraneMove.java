package games.crane;

public record CraneMove(int quantity, String fromStack, String toStack) {

    public static CraneMove parse(String moveString) {
        var splits = moveString.split(" ");

        return new CraneMove(Integer.parseInt(splits[1]), splits[3], splits[5]);
    }
}
