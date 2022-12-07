package communicator.filesystem.members;

import java.util.ArrayList;
import java.util.List;

public final class Directory implements FileSystemMember {

    private final String name;
    private final List<FileSystemMember> children = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public Integer size() {
        return children.stream().mapToInt(FileSystemMember::size).sum();
    }

    public List<Directory> getDirectories() {
        return children.stream().filter(o -> o instanceof Directory).map(Directory.class::cast).toList();
    }

    public void add(FileSystemMember fileSystemMember) {
        children.add(fileSystemMember);
    }
}
