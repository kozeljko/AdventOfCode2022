package com.kozelj;

import games.ropeplay.RopeGame;
import org.junit.Assert;
import org.junit.Test;
import readers.LineReader;

public class Day9TaskTest {

    @Test
    public void exampleOne() {
        var input = "day9/example1.txt";
        var commands = new LineReader().readLines(input);

        RopeGame ropeGame = new RopeGame(2);
        ropeGame.move(commands);

        Assert.assertEquals(Integer.valueOf(13), ropeGame.getNumberOfTailLocations());
    }

    @Test
    public void exampleTwo() {
        var input = "day9/example2.txt";
        var commands = new LineReader().readLines(input);

        RopeGame ropeGame = new RopeGame(10);
        ropeGame.move(commands);

        Assert.assertEquals(Integer.valueOf(36), ropeGame.getNumberOfTailLocations());
    }

    @Test
    public void task1() {
        var input = "day9/task1.txt";
        var commands = new LineReader().readLines(input);

        RopeGame ropeGame = new RopeGame(2);
        ropeGame.move(commands);

        Assert.assertEquals(Integer.valueOf(6243), ropeGame.getNumberOfTailLocations());
    }

    @Test
    public void task2() {
        var input = "day9/task1.txt";
        var commands = new LineReader().readLines(input);

        RopeGame ropeGame = new RopeGame(10);
        ropeGame.move(commands);

        Assert.assertEquals(Integer.valueOf(2630), ropeGame.getNumberOfTailLocations());
    }
}
