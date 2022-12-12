package com.kozelj;

import org.junit.Assert;
import org.junit.Test;
import parser.HillMapParser;

public class Day12TaskTest {

    @Test
    public void exampleOne() {
        var input = "day12/example.txt";

        var hillMap = new HillMapParser().parse(input);

        Assert.assertEquals(Integer.valueOf(31), hillMap.findHikeDistanceFromStart());
    }

    @Test
    public void exampleTwo() {
        var input = "day12/example.txt";

        var hillMap = new HillMapParser().parse(input);

        Assert.assertEquals(Integer.valueOf(29), hillMap.findHikeDistanceScenic());
    }

    @Test
    public void task1() {
        var input = "day12/task1.txt";

        var hillMap = new HillMapParser().parse(input);

        System.out.println(hillMap.findHikeDistanceFromStart());
    }

    @Test
    public void task2() {
        var input = "day12/task1.txt";

        var hillMap = new HillMapParser().parse(input);

        System.out.println(hillMap.findHikeDistanceScenic());
    }
}
