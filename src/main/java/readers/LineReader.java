package readers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LineReader {
    public Stream<String> readLinesStream(String filePath) {
        try (var is = LineReader.class.getClassLoader().getResourceAsStream(filePath)) {
            if (is == null) {
                throw new RuntimeException("Input stream is empty");
            }

            return new String(is.readAllBytes()).lines();
        } catch (IOException e) {
            throw new RuntimeException("Can't read lines");
        }
    }

    public List<String> readLines(String filePath) {
        return readLinesStream(filePath).toList();
    }

    public String readFirstLine(String filePath) {
        return readLinesStream(filePath).findFirst().orElse("");
    }

    // Assuming that they are separated by an empty line
    public List<List<String>> readStringGroups(String filePath) {
        List<List<String>> result = new ArrayList<>();
        var lines = readLines(filePath);

        List<String> currentGroup = new ArrayList<>();
        for (String line : lines) {
            if (line.isBlank()) {
                result.add(new ArrayList<>(currentGroup));
                currentGroup.clear();
            } else {
                currentGroup.add(line);
            }
        }

        if (!currentGroup.isEmpty()) {
            result.add(new ArrayList<>(currentGroup));
        }

        return result;
    }
}
