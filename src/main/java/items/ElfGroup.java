package items;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ElfGroup {
    private final List<String> elfRucksacks;

    private ElfGroup(List<String> elfRucksacks) {
        this.elfRucksacks = elfRucksacks;
    }

    public Integer getBadgeCodeValue() {
        Set<Character> firstChars = elfRucksacks.get(0).chars().mapToObj(o -> (char) o).collect(Collectors.toSet());
        Set<Character> secondChars = elfRucksacks.get(1).chars().mapToObj(o -> (char) o).collect(Collectors.toSet());

        return elfRucksacks.get(2).chars().mapToObj(o -> (char) o).filter(o -> firstChars.contains(o) && secondChars.contains(o)).map(Object::toString).map(ItemEvaluator::getItemValue).findFirst().orElse(null);
    }

    public static List<ElfGroup> parseElfGroups(List<String> elfRucksacks) {
        List<String> rucksacks = new ArrayList<>();
        List<ElfGroup> elfGroups = new ArrayList<>();
        for (String rucksack : elfRucksacks) {
            rucksacks.add(rucksack);

            if (rucksacks.size() == 3) {
                elfGroups.add(new ElfGroup(new ArrayList<>(rucksacks)));
                rucksacks.clear();
            }
        }

        return elfGroups;
    }
}
