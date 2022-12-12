package parser;

import items.Monkey;
import items.MonkeyItemThrow;
import readers.LineReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class MonkeyParser {
    private final LineReader lineReader;

    public MonkeyParser() {
        lineReader = new LineReader();
    }

    public List<Monkey> parseMonkeys(String inputFile) {
        List<Monkey> monkeys = new ArrayList<>();
        for (var lineGroup : lineReader.readStringGroups(inputFile)) {
            // Obtain identifier
            var identifierLine = lineGroup.get(0);
            var identifier = Integer.parseInt(identifierLine.replaceAll(":", "").split(" ")[1]);

            // Obtain starting items
            var itemsLine = lineGroup.get(1);
            var cleanedItemsLine = itemsLine.replaceAll("Starting items: ", "").strip();
            List<Long> startingItems = Arrays.stream(cleanedItemsLine.split(", ")).map(Long::parseLong).toList();

            // Operation
            var operationLine = lineGroup.get(2);
            var cleanedOperationLine = operationLine.replaceAll("Operation: ", "").strip();
            var operationSplits = cleanedOperationLine.split(" ");
            Function<Long, Long> operationFunction = o -> {
                var a = operationSplits[2].equals("old") ? o : Long.parseLong(operationSplits[2]);
                var b = operationSplits[4].equals("old") ? o : Long.parseLong(operationSplits[4]);

                return switch (operationSplits[3]) {
                    case "+" -> a + b;
                    case "-" -> a - b;
                    case "*" -> a * b;
                    case "/" -> a / b;
                    default -> throw new UnsupportedOperationException();
                };
            };

            // Test case
            var testConditionLine = lineGroup.get(3);
            var testConditionSplits = testConditionLine.strip().split(" ");
            long divisibleByTest = Long.parseLong(testConditionSplits[3]);

            var trueTarget = Integer.parseInt(lineGroup.get(4).strip().split(" ")[5]);
            var falseTarget = Integer.parseInt(lineGroup.get(5).strip().split(" ")[5]);

            Function<Long, MonkeyItemThrow> monkeyThrowDecision = o -> {
                if (o % divisibleByTest == 0) {
                    //System.out.printf("Monkey %d: %d IS divisible by %d, sending to %d%n", identifier, o, divisibleByTest, trueTarget);
                    return new MonkeyItemThrow(trueTarget, o);
                } else {
                    //System.out.printf("Monkey %d: %d NOT divisible by %d, sending to %d%n", identifier, o, divisibleByTest, falseTarget);
                    return new MonkeyItemThrow(falseTarget, o);
                }
            };

            monkeys.add(new Monkey(identifier, divisibleByTest, startingItems, operationFunction, monkeyThrowDecision));
        }

        return monkeys;
    }
}
