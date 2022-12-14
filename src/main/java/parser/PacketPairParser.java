package parser;

import communicator.packet.PacketComponent;
import communicator.packet.PacketList;
import communicator.packet.PacketNumber;
import readers.LineReader;
import utils.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PacketPairParser {
    private final LineReader lineReader;

    public PacketPairParser() {
        this.lineReader = new LineReader();
    }

    public List<Pair<PacketComponent>> parsePacketPairs(String inputFile) {
        var stringGroups = lineReader.readStringGroups(inputFile);

        List<Pair<PacketComponent>> pairs = new ArrayList<>();
        for (var stringGroup : stringGroups) {
            String firstString = stringGroup.get(0);
            String secondString = stringGroup.get(1);

            pairs.add(new Pair<>(parsePacketComponent(firstString), parsePacketComponent(secondString)));
        }

        return pairs;
    }

    private PacketComponent parsePacketComponent(String componentString) {
        Stack<PacketList> packetListStack = new Stack<>();

        List<String> currentCharacterChain = new ArrayList<>();
        PacketList currentPacketList = null;
        for (String character : componentString.split("")) {
            switch (character) {
                case "[" -> {
                    if (currentPacketList != null) {
                        packetListStack.add(currentPacketList);
                    }

                    currentPacketList = new PacketList();
                }
                case "]" -> {
                    if (!currentCharacterChain.isEmpty() && currentPacketList != null) {
                        String token = String.join("", currentCharacterChain);
                        currentPacketList.addComponent(new PacketNumber(Integer.parseInt(token)));

                        currentCharacterChain.clear();
                    }

                    PacketList completedList = currentPacketList;
                    if (packetListStack.isEmpty()) {
                        return completedList;
                    }

                    currentPacketList = packetListStack.pop();
                    currentPacketList.addComponent(completedList);
                }
                case "," -> {
                    if (!currentCharacterChain.isEmpty() && currentPacketList != null) {
                        String token = String.join("", currentCharacterChain);
                        currentPacketList.addComponent(new PacketNumber(Integer.parseInt(token)));

                        currentCharacterChain.clear();
                    }
                }

                default -> currentCharacterChain.add(character);
            }
        }

        return null;
    }
}
