package communicator;

import communicator.commands.ChangeDirectoryCommand;
import communicator.commands.Command;
import communicator.commands.ListCommand;
import communicator.filesystem.FileSystem;
import communicator.filesystem.members.Directory;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Communicator {
    private final FileSystem fileSystem;

    public Communicator() {
        fileSystem = new FileSystem();
    }

    // Day 7
    public void runCommand(Command command) {
        if (command instanceof ChangeDirectoryCommand changeDirectoryCommand) {
            fileSystem.changeDirectory(changeDirectoryCommand.targetDirectory());
        } else if (command instanceof ListCommand listCommand) {
            listCommand.outputs().forEach(fileSystem::addToCurrentDirectory);
        }
    }

    // Day 7
    public Integer findAndSumSmallerDirectories() {
        Queue<Directory> directoriesToCheck = new LinkedList<>();
        directoriesToCheck.add(fileSystem.getRoot());

        int sum = 0;
        while (!directoriesToCheck.isEmpty()) {
            Directory directory = directoriesToCheck.remove();
            if (directory.size() <= 100000) {
                sum += directory.size();
            }

            directoriesToCheck.addAll(directory.getDirectories());
        }

        return sum;
    }

    // Day 7
    public Integer findSmallerDirectoryToAchieveTargetSpace() {
        int targetSpace = 30000000;
        int currentSize = fileSystem.getRoot().size();
        int spaceToDelete = currentSize - (FileSystem.FILE_SYSTEM_TOTAL_SIZE - targetSpace);

        int smallestFoundDirectorySize = FileSystem.FILE_SYSTEM_TOTAL_SIZE;
        Queue<Directory> queue = new LinkedList<>();
        queue.add(fileSystem.getRoot());

        while (!queue.isEmpty()) {
            Directory directory = queue.remove();

            int directorySize = directory.size();
            if (directorySize < smallestFoundDirectorySize && directorySize >= spaceToDelete) {
                smallestFoundDirectorySize = directorySize;
            }

            queue.addAll(directory.getDirectories());
        }

        return smallestFoundDirectorySize;
    }

    // Day 6
    public Integer findPacketStartIndex(String inputDataStream) {
        return findFirstUniqueSequence(inputDataStream, 4);
    }

    // Day 6
    public Integer findMessageStartIndex(String inputDataStream) {
        return findFirstUniqueSequence(inputDataStream, 14);

    }

    // Day 6
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
