package readers;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
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
}
