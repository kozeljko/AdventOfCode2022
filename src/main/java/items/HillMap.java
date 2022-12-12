package items;

import java.util.*;
import java.util.function.Predicate;

public class HillMap {
    private final List<List<Hill>> hillMap;
    private final Hill startingHill;
    private final Hill endingHill;

    public HillMap(List<List<Hill>> hillMap) {
        this.hillMap = hillMap;

        this.startingHill = hillMap.stream().flatMap(List::stream).filter(o -> o.mark().equals("S")).findFirst().orElseThrow();
        this.endingHill = hillMap.stream().flatMap(List::stream).filter(o -> o.mark().equals("E")).findFirst().orElseThrow();
    }

    public Integer findHikeDistanceFromStart() {
        return findHikeDistance(startingHill);
    }

    public Integer findHikeDistanceScenic() {
        var startingHills = hillMap.stream().flatMap(List::stream).filter(o -> o.mark().equals("a") || o.mark().equals("S")).toList();
        return startingHills.stream().mapToInt(this::findHikeDistance).filter(o -> o >= 0).min().orElse(-1);
    }

    private Integer findHikeDistance(Hill startingHill) {
        Queue<HillCost> queue = new PriorityQueue<>(Comparator.comparing(HillCost::cost));
        queue.add(new HillCost(startingHill, 0));

        Set<Hill> visitedHills = new HashSet<>();
        while (!queue.isEmpty()) {
            HillCost hillCost = queue.poll();
            Hill hill = hillCost.hill();

            if (visitedHills.contains(hill)) {
                continue;
            }

            visitedHills.add(hill);

            Integer currentCost = hillCost.cost();
            if (endingHill.equals(hillCost.hill())) {
                // We found it!
                return currentCost;
            }

            // Find hill cost candidates from the current hill
            List<HillCost> potentialHills = findNeighbourHills(hill).stream().filter(Predicate.not(visitedHills::contains)).filter(hill::canMoveTo).map(o -> new HillCost(o, currentCost + 1)).toList();

            queue.addAll(potentialHills);
        }

        return - 1;
    }

    private List<Hill> findNeighbourHills(Hill hill) {
        List<Hill> hills = new ArrayList<>();

        if (hill.x() != 0) {
            hills.add(hillMap.get(hill.x() - 1).get(hill.y()));
        }

        if (hill.x() != hillMap.size() - 1) {
            hills.add(hillMap.get(hill.x() + 1).get(hill.y()));
        }

        if (hill.y() != 0) {
            hills.add(hillMap.get(hill.x()).get(hill.y() - 1));
        }

        if (hill.y() != hillMap.get(0).size() - 1) {
            hills.add(hillMap.get(hill.x()).get(hill.y() + 1));
        }

        return hills;
    }

    private record HillCost(Hill hill, Integer cost) {

    }
}
