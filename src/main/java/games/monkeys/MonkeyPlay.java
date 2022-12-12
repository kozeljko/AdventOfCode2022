package games.monkeys;

import items.Monkey;
import items.MonkeyItemThrow;
import parser.MonkeyParser;

import java.util.*;

public class MonkeyPlay {
    private final List<Monkey> monkeys = new ArrayList<>();
    private final Map<Integer, Monkey> monkeyById = new HashMap<>();
    private Long moduloThingy;

    public void init(String inputFile) {
        monkeys.addAll(new MonkeyParser().parseMonkeys(inputFile));
        monkeys.forEach(o -> monkeyById.put(o.getIdentifier(), o));

        moduloThingy = monkeys.stream().map(Monkey::getTestDivisor).reduce(1L, (a, b) -> a * b);
    }

    public void playRounds(int roundCount, boolean veryWorried) {
        for (int i = 0; i < roundCount; i++) {

            for (Monkey monkey : monkeys) {
                List<MonkeyItemThrow> itemThrows = monkey.inspectItems(veryWorried);
                itemThrows.forEach(o -> monkeyById.get(o.receivingMonkey()).catchItem(o.itemWorry() % moduloThingy));
            }
        }
    }

    public Long getMonkeyBusinessLevel() {
        return monkeys.stream().sorted(Comparator.comparing(Monkey::getInspectionCount).reversed()).limit(2).mapToLong(Monkey::getInspectionCount).reduce(1, (a, b) -> a * b);
    }
}
