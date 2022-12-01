package com.kozelj;

import org.junit.Test;
import parser.CalorieParser;

public class Day1TaskTest {
    private final CalorieParser parser = new CalorieParser();

    @Test
    public void exampleOne() {
        var input = "day1/example.txt";

        int max = parser.getMaximumCalorieSum(input);
        System.out.printf("Max is %d%n", max);
    }

    @Test
    public void exampleTwo() {
        var input = "day1/example.txt";

        int max = parser.getMaximumCalorieSum(input, 3);
        System.out.printf("Max is %d%n", max);
    }

    @Test
    public void taskOne() {
        var input = "day1/task.txt";

        int max = parser.getMaximumCalorieSum(input);
        System.out.printf("Max is %d%n", max);
    }

    @Test
    public void taskTwo() {
        var input = "day1/task.txt";

        int max = parser.getMaximumCalorieSum(input, 3);
        System.out.printf("Max is %d%n", max);
    }

}
