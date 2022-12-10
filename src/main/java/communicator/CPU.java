package communicator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class CPU {

    public static Integer runProgram(List<String> instructions) {
        List<Integer> incrementsByCycle = instructions.stream().map(o -> {
            if (o.startsWith("addx")) {
                return List.of(0, Integer.parseInt(o.split(" ")[1]));
            } else {
                return List.of(0);
            }
        }).flatMap(List::stream).toList();

        List<Integer> targetCycles = IntStream.of(0, 1, 2, 3, 4, 5).mapToObj(o -> o * 40 + 20).toList();
        List<Integer> targetCycleValues = new ArrayList<>();

        Integer registerValue = 1;
        List<String> characterList = new ArrayList<>();
        for (int cycle = 1; cycle <= incrementsByCycle.size(); cycle++) {
            if (targetCycles.contains(cycle)) {
                targetCycleValues.add(registerValue * cycle);
            }

            int renderPosition = characterList.size();
            if (renderPosition >= registerValue - 1 && renderPosition <= registerValue + 1) {
                characterList.add("#");
            } else {
                characterList.add(".");
            }

            if (characterList.size() == 40) {
                System.out.println(String.join("", characterList));
                characterList.clear();
            }

            registerValue += incrementsByCycle.get(cycle - 1);
        }

        return targetCycleValues.stream().mapToInt(o -> o).sum();
    }

}
