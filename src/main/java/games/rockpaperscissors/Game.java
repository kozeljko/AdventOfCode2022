package games.rockpaperscissors;

import readers.LineReader;

import java.util.List;
import java.util.Map;

public class Game {
    private final List<String> rounds;

    public Game(String input) {
        this.rounds = new LineReader().readLines(input);
    }

    public int getGameScore() {
        int total = 0;

        for (String line : rounds) {
            String[] commands = line.split(" ");
            Move our = Move.parseEncryptedCode(commands[1]);
            Move their = Move.parsePlainCode(commands[0]);

            Outcome outcome = determineOutcome(our, their);

            total += (our.getMoveValue() + outcome.getOutcomeValue());
        }

        return total;
    }

    public int getActualGameScore() {
        int total = 0;

        var targetOutcomes = Map.of("X", Outcome.LOSE, "Y", Outcome.DRAW, "Z", Outcome.WIN);

        for (String line : rounds) {
            String[] commands = line.split(" ");
            Move their = Move.parsePlainCode(commands[0]);
            Outcome outcome = targetOutcomes.get(commands[1]);

            Move our = Move.ROCK;
            for (Move potentialMove : Move.values()) {
                if (determineOutcome(potentialMove, their) == outcome) {
                    our = potentialMove;
                    break;
                }
            }

            total += (our.getMoveValue() + outcome.getOutcomeValue());
        }

        return total;
    }

    private Outcome determineOutcome(Move ourMove, Move theirMove) {
        int comparison = ourMove.compareTo(theirMove);

        return switch (comparison) {
            case -2 -> Outcome.WIN;
            case -1 -> Outcome.LOSE;
            case 0 -> Outcome.DRAW;
            case 1 -> Outcome.WIN;
            case 2 -> Outcome.LOSE;
            default -> Outcome.DRAW;
        };
    }
}
