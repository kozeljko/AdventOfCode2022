package com.kozelj;

import communicator.CPU;
import org.junit.Assert;
import org.junit.Test;
import readers.LineReader;

public class Day10TaskTest {

    @Test
    public void exampleOne() {
        var input = "day10/example.txt";
        var instructions = new LineReader().readLines(input);

        Assert.assertEquals(Integer.valueOf(13140), CPU.runProgram(instructions));
    }

    @Test
    public void task1() {
        var input = "day10/task1.txt";
        var instructions = new LineReader().readLines(input);

        System.out.println(CPU.runProgram(instructions));
    }
}
