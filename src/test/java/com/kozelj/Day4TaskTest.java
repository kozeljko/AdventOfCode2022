package com.kozelj;

import items.ElfPair;
import org.junit.Assert;
import org.junit.Test;
import readers.LineReader;

public class Day4TaskTest {

    @Test
    public void exampleOne() {
        var input = "day4/example.txt";

        var count = new LineReader().readLines(input).stream().map(ElfPair::parseElfPair).filter(ElfPair::isOneFullyContained).count();
        Assert.assertEquals(2, count);
    }

    @Test
    public void exampleTwo() {
        var input = "day4/example.txt";

        var count = new LineReader().readLines(input).stream().map(ElfPair::parseElfPair).filter(ElfPair::isOnePartiallyCovered).count();
        Assert.assertEquals(4, count);
    }

    @Test
    public void task1() {
        var input = "day4/task1.txt";

        var count = new LineReader().readLines(input).stream().map(ElfPair::parseElfPair).filter(ElfPair::isOneFullyContained).count();
        System.out.println(count);
    }

    @Test
    public void task2() {
        var input = "day4/task1.txt";

        var count = new LineReader().readLines(input).stream().map(ElfPair::parseElfPair).filter(ElfPair::isOnePartiallyCovered).count();
        System.out.println(count);
    }
}
