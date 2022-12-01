package parser;

import readers.LineReader;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CalorieParser {
    private final LineReader lineReader;

    public CalorieParser() {
        lineReader = new LineReader();
    }

    public Integer getMaximumCalorieSum(String input) {
        return getMaximumCalorieSum(input, 1);
    }

    /**
     * Sums consecutive integer lines from input file. Then takes the top topN and sums them together.
     *
     * @param inputFile input file with calories
     * @param topN how many top calorie values to sum
     * @return sum of the top topN calorie values
     */
    public Integer getMaximumCalorieSum(String inputFile, int topN) {
        var lines = lineReader.readLines(inputFile);

        int current = 0;
        List<Integer> foundCalorieSums = new ArrayList<>();
        for (var line : lines) {
            if (line.isBlank()) {
                foundCalorieSums.add(current);
                current = 0;
                continue;
            }

            current += Integer.parseInt(line.trim());
        }

        foundCalorieSums.add(current);

        Comparator<Integer> comparator = Integer::compare;
        return foundCalorieSums.stream().sorted(comparator.reversed()).limit(topN).mapToInt(o -> o).sum();
    }

}
