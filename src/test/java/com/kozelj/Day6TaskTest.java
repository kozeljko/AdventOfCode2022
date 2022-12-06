package com.kozelj;

import items.Communicator;
import org.junit.Assert;
import org.junit.Test;
import readers.LineReader;

import java.util.List;

public class Day6TaskTest {

    @Test
    public void exampleOne() {
        var input = "day6/example.txt";

        List<String> lines = new LineReader().readLines(input);
        List<Integer> expectedPacketStarts = List.of(7, 5, 6, 10, 11);

        var communicator = new Communicator();
        for (int index = 0; index < lines.size(); index++) {
            Assert.assertEquals(expectedPacketStarts.get(index), communicator.findPacketStartIndex(lines.get(index)));
        }
    }

    @Test
    public void exampleTwo() {
        var input = "day6/example.txt";

        List<String> lines = new LineReader().readLines(input);
        List<Integer> expectedPacketStarts = List.of(19, 23, 23, 29, 26);

        var communicator = new Communicator();
        for (int index = 0; index < lines.size(); index++) {
            Assert.assertEquals(expectedPacketStarts.get(index), communicator.findMessageStartIndex(lines.get(index)));
        }
    }

    @Test
    public void task1() {
        var input = "day6/task1.txt";

        String line = new LineReader().readFirstLine(input);

        var communicator = new Communicator();
        System.out.println(communicator.findPacketStartIndex(line));
    }

    @Test
    public void task2() {
        var input = "day6/task1.txt";

        String line = new LineReader().readFirstLine(input);

        var communicator = new Communicator();
        System.out.println(communicator.findMessageStartIndex(line));
    }
}
