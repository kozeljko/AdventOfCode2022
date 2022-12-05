package items;

public class Rucksack {
    private final String compartmentOne;
    private final String compartmentTwo;

    private Rucksack(String compartmentOne, String compartmentTwo) {
        this.compartmentOne = compartmentOne;
        this.compartmentTwo = compartmentTwo;
    }

    public static Rucksack fromString(String input) {
        var partOne = input.substring(0, input.length() / 2);
        var partTwo = input.substring(input.length() / 2);

        return new Rucksack(partOne, partTwo);
    }

    public Integer getCommonItemValue() {
        Character commonItem = null;
        for (int i = 0; i < compartmentOne.length(); i++) {
            char currentCharacter = compartmentOne.charAt(i);

            for (int j = 0; j < compartmentTwo.length(); j++) {
                if (currentCharacter == compartmentTwo.charAt(j)) {
                    commonItem = currentCharacter;
                    break;
                }
            }

            if (commonItem != null) {
                break;
            }
        }

        if (commonItem == null) {
            throw new RuntimeException("Fak");
        }

        return ItemEvaluator.getItemValue(commonItem.toString());
    }
}
