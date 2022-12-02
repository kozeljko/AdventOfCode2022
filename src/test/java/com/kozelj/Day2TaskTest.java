package com.kozelj;

import games.rockpaperscissors.Game;
import org.junit.Assert;
import org.junit.Test;

public class Day2TaskTest {

    @Test
    public void exampleOne() {
        var input = "day2/example.txt";
        var expectedValue = 15;

        Game game = new Game(input);
        Assert.assertEquals(expectedValue, game.getGameScore());
    }

    @Test
    public void exampleTwo() {
        var input = "day2/example.txt";
        var expectedValue = 12;

        Game game = new Game(input);
        Assert.assertEquals(expectedValue, game.getActualGameScore());
    }

    @Test
    public void taskOne() {
        var input = "day2/task1.txt";

        Game game = new Game(input);
        System.out.println(game.getGameScore());
    }

    @Test
    public void taskTwo() {
        var input = "day2/task1.txt";

        Game game = new Game(input);
        System.out.println(game.getActualGameScore());
    }
}
