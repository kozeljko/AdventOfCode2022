package communicator.filesystem.members;

public sealed interface FileSystemMember permits Directory, File {

    String name();

    Integer size();
}
