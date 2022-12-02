package games.rockpaperscissors;

public enum Outcome {
    WIN(6), DRAW(3), LOSE(0);

    private final int outcomeValue;

    Outcome(int outcomeValue) {
        this.outcomeValue = outcomeValue;
    }

    public int getOutcomeValue() {
        return outcomeValue;
    }
}
