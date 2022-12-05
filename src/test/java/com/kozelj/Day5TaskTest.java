package com.kozelj;

import games.crane.CraneMove;
import games.crane.CraneState;
import org.junit.Assert;
import org.junit.Test;
import readers.LineReader;

import java.util.List;

public class Day5TaskTest {

    @Test
    public void exampleOne() {
        var input = "day5/example.txt";

        List<String> lines = new LineReader().readLines(input);
        int indexOfDelimiter = lines.indexOf("");
        List<String> stateLines = lines.subList(0, indexOfDelimiter);
        List<String> moveLines = lines.subList(indexOfDelimiter + 1, lines.size());

        CraneState craneState = CraneState.parseInitialState(stateLines);
        List<CraneMove> craneMoves = moveLines.stream().map(CraneMove::parse).toList();

        craneState.applyMoves(craneMoves);
        String craneResult = String.join("", craneState.getTopCrates());

        Assert.assertEquals("CMZ", craneResult);
    }

    @Test
    public void exampleTwo() {
        var input = "day5/example.txt";

        List<String> lines = new LineReader().readLines(input);
        int indexOfDelimiter = lines.indexOf("");
        List<String> stateLines = lines.subList(0, indexOfDelimiter);
        List<String> moveLines = lines.subList(indexOfDelimiter + 1, lines.size());

        CraneState craneState = CraneState.parseInitialState(stateLines);
        List<CraneMove> craneMoves = moveLines.stream().map(CraneMove::parse).toList();

        craneState.applyMoves9001(craneMoves);
        String craneResult = String.join("", craneState.getTopCrates());

        Assert.assertEquals("MCD", craneResult);
    }

    @Test
    public void task1() {
        var input = "day5/task1.txt";

        List<String> lines = new LineReader().readLines(input);
        int indexOfDelimiter = lines.indexOf("");
        List<String> stateLines = lines.subList(0, indexOfDelimiter);
        List<String> moveLines = lines.subList(indexOfDelimiter + 1, lines.size());

        CraneState craneState = CraneState.parseInitialState(stateLines);
        List<CraneMove> craneMoves = moveLines.stream().map(CraneMove::parse).toList();

        craneState.applyMoves(craneMoves);
        String craneResult = String.join("", craneState.getTopCrates());
        System.out.println(craneResult);
    }

    @Test
    public void task2() {
        var input = "day5/task1.txt";

        List<String> lines = new LineReader().readLines(input);
        int indexOfDelimiter = lines.indexOf("");
        List<String> stateLines = lines.subList(0, indexOfDelimiter);
        List<String> moveLines = lines.subList(indexOfDelimiter + 1, lines.size());

        CraneState craneState = CraneState.parseInitialState(stateLines);
        List<CraneMove> craneMoves = moveLines.stream().map(CraneMove::parse).toList();

        craneState.applyMoves9001(craneMoves);
        String craneResult = String.join("", craneState.getTopCrates());
        System.out.println(craneResult);
    }
}
