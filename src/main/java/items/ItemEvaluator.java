package items;

public class ItemEvaluator {

    public static Integer getItemValue(String itemCode) {
        if (itemCode.length() != 1) {
            throw new RuntimeException("Wtf");
        }

        String lowerCase = itemCode.toLowerCase();
        int finalValue = ((int) lowerCase.charAt(0)) - 96;
        if (!lowerCase.equals(itemCode)) {
            finalValue += 26;
        }

        return finalValue;
    }

}
