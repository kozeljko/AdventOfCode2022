package parser;

import communicator.scanner.Point;
import communicator.scanner.RockStructure;
import readers.LineReader;

import java.util.Arrays;
import java.util.List;

public class RockStructureParser {
    private final LineReader lineReader;

    public RockStructureParser() {
        lineReader = new LineReader();
    }

    public List<RockStructure> parse(String inputFile) {
        return lineReader.readLinesStream(inputFile).map(o -> Arrays.stream(o.split("->")).map(String::strip).map(point -> {
            var splits = point.split(",");
            return new Point(Integer.parseInt(splits[0]), Integer.parseInt(splits[1]));
        }).toList()).map(RockStructure::new).toList();
    }
}
