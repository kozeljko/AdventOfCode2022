package communicator.commands;

import communicator.filesystem.members.Directory;
import communicator.filesystem.members.File;
import communicator.filesystem.members.FileSystemMember;

import java.util.ArrayList;
import java.util.List;

public class CommandParser {

    public List<Command> parseCommands(List<String> inputLines) {
        List<Command> commands = new ArrayList<>();
        int maxIndex = inputLines.size() - 1;

        for (var index = 0; index < inputLines.size(); index++) {
            // Expect commands to be used here, since we are incrementing manually
            var splits = inputLines.get(index).split(" ");
            var commandString = splits[1];
            if (commandString.equals("cd")) {
                commands.add(new ChangeDirectoryCommand(splits[2]));
            } else if (commandString.equals("ls")) {
                // Find lines until next command
                List<FileSystemMember> fileSystemMembers = new ArrayList<>();
                while (index < maxIndex && !inputLines.get(++index).startsWith("$")) {
                    var fileMemberSplits = inputLines.get(index).split(" ");

                    if (fileMemberSplits[0].startsWith("dir")) {
                        fileSystemMembers.add(new Directory(fileMemberSplits[1]));
                    } else {
                        // File
                        fileSystemMembers.add(new File(fileMemberSplits[1], Integer.parseInt(fileMemberSplits[0])));
                    }

                }

                if (index != maxIndex) {
                    index--;
                }

                commands.add(new ListCommand(fileSystemMembers));
            } else {
                throw new UnsupportedOperationException("Unknown command %s".formatted(commandString));
            }
        }

        return commands;
    }

}
