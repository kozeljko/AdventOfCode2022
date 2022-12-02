package games.rockpaperscissors;

import java.util.Arrays;

public enum Move {
    ROCK("A", "X", 1), PAPER("B", "Y", 2), SCISSORS("C", "Z", 3);

    private final String plainCode;
    private final String encryptedCode;
    private final int moveValue;

    Move(String plainCode, String encryptedCode, int moveValue) {
        this.plainCode = plainCode;
        this.encryptedCode = encryptedCode;
        this.moveValue = moveValue;
    }

    public static Move parsePlainCode(String plainCode) {
        return Arrays.stream(values()).filter(o -> o.plainCode.equals(plainCode)).findFirst().orElse(null);
    }

    public static Move parseEncryptedCode(String plainCode) {
        return Arrays.stream(values()).filter(o -> o.encryptedCode.equals(plainCode)).findFirst().orElse(null);
    }

    public int getMoveValue() {
        return moveValue;
    }
}
