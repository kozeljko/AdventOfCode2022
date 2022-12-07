package communicator.commands;

public sealed interface Command permits ChangeDirectoryCommand, ListCommand {
}
