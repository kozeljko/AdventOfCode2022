package parser;

import items.TreeTop;
import readers.LineReader;

import java.util.Arrays;
import java.util.List;

public class TreeTopParser {
    private final LineReader lineReader;

    public TreeTopParser() {
        lineReader = new LineReader();
    }

    public TreeTop parse(String inputFile) {
        var rows = lineReader.readLinesStream(inputFile).map(this::readSingleDigits).toList();
        return new TreeTop(rows);
    }


    private List<Integer> readSingleDigits(String line) {
        return Arrays.stream(line.split("")).map(Integer::parseInt).toList();
    }
}
