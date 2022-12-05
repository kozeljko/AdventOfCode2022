package games.crane;

import java.util.*;

public class CraneState {
    private final List<String> craneOrder;
    private final Map<String, Stack<String>> craneState;

    private CraneState(List<String> craneOrder, Map<String, Stack<String>> craneState) {
        this.craneOrder = craneOrder;
        this.craneState = craneState;
    }

    public void applyMoves(List<CraneMove> craneMoves) {
        for (CraneMove craneMove : craneMoves) {
            for (int moveStep = 0; moveStep < craneMove.quantity(); moveStep++) {
                String movedCrate = craneState.get(craneMove.fromStack()).pop();
                craneState.get(craneMove.toStack()).add(movedCrate);
            }
        }
    }

    public void applyMoves9001(List<CraneMove> craneMoves) {
        for (CraneMove craneMove : craneMoves) {
            Stack<String> removedCratesStack = new Stack<>();
            for (int moveStep = 0; moveStep < craneMove.quantity(); moveStep++) {
                String movedCrate = craneState.get(craneMove.fromStack()).pop();
                removedCratesStack.add(movedCrate);
            }

            for (int moveStep = 0; moveStep < craneMove.quantity(); moveStep++) {
                String movedCrate = removedCratesStack.pop();
                craneState.get(craneMove.toStack()).add(movedCrate);
            }
        }
    }

    public List<String> getTopCrates() {
        return craneOrder.stream().map(craneState::get).map(Stack::peek).toList();
    }

    public static CraneState parseInitialState(List<String> stateRows) {
        String orderString = stateRows.get(stateRows.size() - 1);
        List<String> craneOrder = Arrays.stream(orderString.split(" ")).filter(o -> !o.isBlank()).toList();
        Map<String, Stack<String>> craneState = new HashMap<>();

        for (int rowIndex = stateRows.size() - 2; rowIndex >= 0; rowIndex--) {
            String row = stateRows.get(rowIndex);

            var splits = row.split("");
            for (int crateIndex = 1; crateIndex < splits.length; crateIndex += 4) {
                String potentialCrate = splits[crateIndex];

                if (potentialCrate.isBlank()) {
                    continue;
                }

                int stackIndex = (crateIndex - 1) / 4;
                craneState.computeIfAbsent(craneOrder.get(stackIndex), key -> new Stack<>()).add(potentialCrate);
            }
        }

        return new CraneState(craneOrder, craneState);
    }
}
