package com.kozelj;

import communicator.scanner.RockScanner;
import org.junit.Assert;
import org.junit.Test;

public class Day14TaskTest {

    @Test
    public void exampleOne() {
        var input = "day14/example.txt";

        RockScanner rockScanner = new RockScanner();
        rockScanner.init(input);
        rockScanner.simulateSand();

        Assert.assertEquals(24, rockScanner.countSandGrains());
    }

    @Test
    public void exampleTwo() {
        var input = "day14/example.txt";

        RockScanner rockScanner = new RockScanner();
        rockScanner.init(input);
        rockScanner.simulateSandReal();

        Assert.assertEquals(93, rockScanner.countSandGrains());
    }

    @Test
    public void task1() {
        var input = "day14/task1.txt";

        RockScanner rockScanner = new RockScanner();
        rockScanner.init(input);
        rockScanner.simulateSand();

        System.out.println(rockScanner.countSandGrains());
    }

    @Test
    public void task2() {
        var input = "day14/task1.txt";

        RockScanner rockScanner = new RockScanner();
        rockScanner.init(input);
        rockScanner.simulateSandReal();

        System.out.println(rockScanner.countSandGrains());
    }
}