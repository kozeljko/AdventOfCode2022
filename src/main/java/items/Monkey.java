package items;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Monkey {

    private final Integer identifier;
    private final Long testDivisor;
    private final List<Long> currentItems;
    private final Function<Long, Long> operationFunction;
    private final Function<Long, MonkeyItemThrow> monkeyThrowDecision;
    private Long inspectionCount = 0L;

    public Monkey(Integer identifier, Long testDivisor, List<Long> currentItems, Function<Long, Long> operationFunction, Function<Long, MonkeyItemThrow> monkeyThrowDecision) {
        this.identifier = identifier;
        this.testDivisor = testDivisor;
        this.currentItems = new ArrayList<>(currentItems);
        this.operationFunction = operationFunction;
        this.monkeyThrowDecision = monkeyThrowDecision;
    }

    public List<MonkeyItemThrow> inspectItems(boolean veryWorried) {
        List<MonkeyItemThrow> itemThrows = new ArrayList<>();
        for (Long item : currentItems) {
            inspectionCount++;

            Long newWorryLevel = operationFunction.apply(item);
            if (!veryWorried) {
                newWorryLevel = newWorryLevel / 3;
            }

            itemThrows.add(monkeyThrowDecision.apply(newWorryLevel));
        }

        currentItems.clear();

        return itemThrows;
    }

    public void catchItem(Long itemWorry) {
        currentItems.add(itemWorry);
    }

    public Integer getIdentifier() {
        return identifier;
    }

    public Long getTestDivisor() {
        return testDivisor;
    }

    public Long getInspectionCount() {
        return inspectionCount;
    }
}
