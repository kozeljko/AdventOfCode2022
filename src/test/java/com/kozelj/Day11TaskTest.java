package com.kozelj;

import games.monkeys.MonkeyPlay;
import org.junit.Assert;
import org.junit.Test;

public class Day11TaskTest {

    @Test
    public void exampleOne() {
        var input = "day11/example.txt";

        var monkeyPlay = new MonkeyPlay();
        monkeyPlay.init(input);
        monkeyPlay.playRounds(20, false);

        Assert.assertEquals(Long.valueOf(10605), monkeyPlay.getMonkeyBusinessLevel());
    }

    @Test
    public void exampleTwo() {
        var input = "day11/example.txt";

        var monkeyPlay = new MonkeyPlay();
        monkeyPlay.init(input);
        monkeyPlay.playRounds(10000, true);

        Assert.assertEquals((Long) 2713310158L, monkeyPlay.getMonkeyBusinessLevel());
    }

    @Test
    public void task1() {
        var input = "day11/task1.txt";

        var monkeyPlay = new MonkeyPlay();
        monkeyPlay.init(input);
        monkeyPlay.playRounds(20, false);

        System.out.println(monkeyPlay.getMonkeyBusinessLevel());
    }

    @Test
    public void task2() {
        var input = "day11/task1.txt";

        var monkeyPlay = new MonkeyPlay();
        monkeyPlay.init(input);
        monkeyPlay.playRounds(10000, true);

        System.out.println(monkeyPlay.getMonkeyBusinessLevel());
    }
}
