package parser;

import items.Hill;
import items.HillMap;
import readers.LineReader;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class HillMapParser {
    private final LineReader lineReader;

    public HillMapParser() {
        this.lineReader = new LineReader();
    }

    public HillMap parse(String inputFile) {
        var lines = lineReader.readLines(inputFile);

        List<List<Hill>> hills = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            var line = lines.get(i);
            var lineSplits = line.split("");

            final int x = i;
            hills.add(IntStream.range(0, line.length()).mapToObj(o -> new Hill(x, o, lineSplits[o])).toList());
        }

        return new HillMap(hills);
    }
}
