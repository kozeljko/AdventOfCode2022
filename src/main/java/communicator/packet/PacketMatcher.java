package communicator.packet;

import parser.PacketPairParser;
import utils.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

public class PacketMatcher {
    private final PacketPairParser packetParser = new PacketPairParser();
    private final List<Pair<PacketComponent>> pairs = new ArrayList<>();

    public void init(String inputFile) {
        pairs.addAll(packetParser.parsePacketPairs(inputFile));
    }

    public int multiplyDividerPackets() {
        List<PacketComponent> allPacketComponents = new ArrayList<>();
        for (var pair : pairs) {
            allPacketComponents.add(pair.left());
            allPacketComponents.add(pair.right());
        }

        PacketComponent dividerOne = new PacketList(new PacketList(new PacketNumber(2)));
        PacketComponent dividerTwo = new PacketList(new PacketList(new PacketNumber(6)));

        allPacketComponents.add(dividerOne);
        allPacketComponents.add(dividerTwo);

        var sorted = allPacketComponents.stream().sorted(Comparator.comparing(Function.identity(), (a, b) -> {
            var orderStatus = isPairInRightOrder(a, b);
            return orderStatus == OrderStatus.CORRECT ? -1 : orderStatus == OrderStatus.UNDETERMINED ? 0 : 1;
        })).toList();

        return (sorted.indexOf(dividerOne) + 1) * (sorted.indexOf(dividerTwo) + 1);
    }

    public int sumIndicesOfPairsInRightOrder() {
        return IntStream.range(0, pairs.size()).filter(o -> {
            var pair = pairs.get(o);
            return isPairInRightOrder(pair.left(), pair.right()) == OrderStatus.CORRECT;
        }).map(o -> o + 1).sum();
    }

    private OrderStatus isPairInRightOrder(PacketComponent left, PacketComponent right) {
        if (left instanceof PacketNumber leftNum && right instanceof PacketNumber rightNum) {
            if (leftNum.number() < rightNum.number()) {
                return OrderStatus.CORRECT;
            }

            if (leftNum.number() > rightNum.number()) {
                return OrderStatus.INCORRECT;
            }

            return OrderStatus.UNDETERMINED;
        }

        PacketList leftList = safeList(left);
        PacketList rightList = safeList(right);

        int numberOfIterations = Math.min(leftList.getSize(), rightList.getSize());
        for (int i = 0; i < numberOfIterations; i++) {
            PacketComponent leftIter = leftList.get(i);
            PacketComponent rightIter = rightList.get(i);

            OrderStatus result = isPairInRightOrder(leftIter, rightIter);
            if (result != OrderStatus.UNDETERMINED) {
                return result;
            }
        }

        return leftList.getSize() == numberOfIterations ? rightList.getSize() == numberOfIterations ? OrderStatus.UNDETERMINED : OrderStatus.CORRECT : OrderStatus.INCORRECT;
    }

    private PacketList safeList(PacketComponent packetComponent) {
        if (packetComponent instanceof PacketList packetList) {
            return packetList;
        }

        return new PacketList(packetComponent);
    }

    private enum OrderStatus {
        CORRECT, UNDETERMINED, INCORRECT
    }
}
