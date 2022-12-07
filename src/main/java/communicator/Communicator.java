package communicator;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Communicator {

    public Integer findPacketStartIndex(String inputDataStream) {
        return findFirstUniqueSequence(inputDataStream, 4);
    }

    public Integer findMessageStartIndex(String inputDataStream) {
        return findFirstUniqueSequence(inputDataStream, 14);

    }

    private Integer findFirstUniqueSequence(String input, int sequenceLength) {
        Queue<Character> queue = new LinkedList<>();

        for (int index = 0; index < input.length(); index++) {
            Character foundCharacter = input.charAt(index);
            queue.add(foundCharacter);

            if (queue.size() < sequenceLength) {
                continue;
            }

            if (queue.size() > sequenceLength) {
                queue.remove();
            }

            if (new HashSet<>(queue).size() == sequenceLength) {
                return index + 1;
            }
        }

        return -1;
    }
}
