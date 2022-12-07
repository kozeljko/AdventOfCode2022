package communicator.filesystem;

import communicator.filesystem.members.Directory;
import communicator.filesystem.members.FileSystemMember;

import java.util.Stack;

public class FileSystem {
    public static Integer FILE_SYSTEM_TOTAL_SIZE = 70000000;

    private final Directory root;
    private final Stack<Directory> directoryPath = new Stack<>();

    public FileSystem() {
        root = new Directory("/");
        directoryPath.add(root);
    }

    public Directory getRoot() {
        return root;
    }

    private Directory getCurrentDirectory() {
        return directoryPath.peek();
    }

    public void addToCurrentDirectory(FileSystemMember fileSystemMember) {
        getCurrentDirectory().add(fileSystemMember);
    }

    public void changeDirectory(String directoryString) {
        if (directoryString.equals("/")) {
            directoryPath.clear();
            directoryPath.add(root);
        } else if (directoryString.equals("..")) {
            if (directoryPath.size() == 1) {
                return;
            }

            directoryPath.pop();
        } else {
            Directory targetDirectory = getCurrentDirectory().getDirectories().stream().filter(o -> o.name().equals(directoryString)).findFirst().orElseThrow();
            directoryPath.add(targetDirectory);
        }
    }
}
