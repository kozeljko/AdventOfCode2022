package com.kozelj;

import items.ElfGroup;
import items.Rucksack;
import org.junit.Assert;
import org.junit.Test;
import readers.LineReader;

import java.util.List;

public class Day3TaskTest {

    @Test
    public void exampleOne() {
        var input = "day3/example.txt";

        var sum = new LineReader().readLines(input).stream().map(Rucksack::fromString).mapToInt(Rucksack::getCommonItemValue).sum();
        Assert.assertEquals(157, sum);
    }

    @Test
    public void exampleTwo() {
        var input = "day3/example.txt";

        List<ElfGroup> elfGroups = ElfGroup.parseElfGroups(new LineReader().readLines(input));

        var sum = elfGroups.stream().mapToInt(ElfGroup::getBadgeCodeValue).sum();
        Assert.assertEquals(70, sum);
    }

    @Test
    public void task1() {
        var input = "day3/task1.txt";

        var sum = new LineReader().readLines(input).stream().map(Rucksack::fromString).mapToInt(Rucksack::getCommonItemValue).sum();
        System.out.println(sum);
    }

    @Test
    public void task2() {
        var input = "day3/task1.txt";

        List<ElfGroup> elfGroups = ElfGroup.parseElfGroups(new LineReader().readLines(input));

        var sum = elfGroups.stream().mapToInt(ElfGroup::getBadgeCodeValue).sum();
        System.out.println(sum);
    }
}
