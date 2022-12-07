package communicator.commands;

import communicator.filesystem.members.FileSystemMember;

import java.util.List;

public record ListCommand(List<FileSystemMember> outputs) implements Command {

}
