package communicator.commands;

public record ChangeDirectoryCommand(String targetDirectory) implements Command {
}
