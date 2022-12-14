package com.kozelj;

import communicator.packet.PacketMatcher;
import org.junit.Assert;
import org.junit.Test;

public class Day13TaskTest {

    @Test
    public void exampleOne() {
        var input = "day13/example.txt";

        var packetMatcher = new PacketMatcher();
        packetMatcher.init(input);

        Assert.assertEquals(13, packetMatcher.sumIndicesOfPairsInRightOrder());
    }

    @Test
    public void exampleTwo() {
        var input = "day13/example.txt";

        var packetMatcher = new PacketMatcher();
        packetMatcher.init(input);

        Assert.assertEquals(140, packetMatcher.multiplyDividerPackets());
    }

    @Test
    public void task1() {
        var input = "day13/task1.txt";

        var packetMatcher = new PacketMatcher();
        packetMatcher.init(input);

        System.out.println(packetMatcher.sumIndicesOfPairsInRightOrder());
    }

    @Test
    public void task2() {
        var input = "day13/task1.txt";

        var packetMatcher = new PacketMatcher();
        packetMatcher.init(input);

        System.out.println(packetMatcher.multiplyDividerPackets());
    }
}
