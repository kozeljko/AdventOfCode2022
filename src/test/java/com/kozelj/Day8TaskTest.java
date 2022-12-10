package com.kozelj;

import org.junit.Assert;
import org.junit.Test;
import parser.TreeTopParser;

public class Day8TaskTest {

    @Test
    public void exampleOne() {
        var input = "day8/example.txt";
        var treeTop = new TreeTopParser().parse(input);

        Assert.assertEquals(Integer.valueOf(21), treeTop.getVisibleTreeCount());
    }

    @Test
    public void exampleTwo() {
        var input = "day8/example.txt";
        var treeTop = new TreeTopParser().parse(input);

        Assert.assertEquals(Integer.valueOf(8), treeTop.findLargestScenicScore());
    }

    @Test
    public void task1() {
        var input = "day8/task1.txt";
        var treeTop = new TreeTopParser().parse(input);

        System.out.println(treeTop.getVisibleTreeCount());;
    }

    @Test
    public void task2() {
        var input = "day8/task1.txt";
        var treeTop = new TreeTopParser().parse(input);

        System.out.println(treeTop.findLargestScenicScore());;
    }
}
