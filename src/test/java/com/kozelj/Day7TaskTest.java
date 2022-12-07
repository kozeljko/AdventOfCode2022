package com.kozelj;

import communicator.Communicator;
import communicator.commands.Command;
import communicator.commands.CommandParser;
import org.junit.Assert;
import org.junit.Test;
import readers.LineReader;

import java.util.List;

public class Day7TaskTest {

    @Test
    public void exampleOne() {
        var input = "day7/example.txt";

        List<String> lines = new LineReader().readLines(input);
        List<Command> commands = new CommandParser().parseCommands(lines);

        Communicator communicator = new Communicator();
        for (Command command : commands) {
            communicator.runCommand(command);
        }

        Assert.assertEquals(Integer.valueOf(95437), communicator.findAndSumSmallerDirectories());
    }

    @Test
    public void exampleTwo() {
        var input = "day7/example.txt";

        List<String> lines = new LineReader().readLines(input);
        List<Command> commands = new CommandParser().parseCommands(lines);

        Communicator communicator = new Communicator();
        for (Command command : commands) {
            communicator.runCommand(command);
        }

        Assert.assertEquals(Integer.valueOf(24933642), communicator.findSmallerDirectoryToAchieveTargetSpace());
    }

    @Test
    public void task1() {
        var input = "day7/task1.txt";

        List<String> lines = new LineReader().readLines(input);
        List<Command> commands = new CommandParser().parseCommands(lines);

        Communicator communicator = new Communicator();
        for (Command command : commands) {
            communicator.runCommand(command);
        }

        System.out.println(communicator.findAndSumSmallerDirectories());
    }

    @Test
    public void task2() {
        var input = "day7/task1.txt";

        List<String> lines = new LineReader().readLines(input);
        List<Command> commands = new CommandParser().parseCommands(lines);

        Communicator communicator = new Communicator();
        for (Command command : commands) {
            communicator.runCommand(command);
        }

        System.out.println(communicator.findSmallerDirectoryToAchieveTargetSpace());
    }
}
