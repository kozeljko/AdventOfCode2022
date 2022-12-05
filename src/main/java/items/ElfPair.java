package items;

import java.util.Arrays;

public class ElfPair {
    private final int elfOneFirstAss;
    private final int elfOneSecondAss;
    private final int elfTwoFirstAss;
    private final int elfTwoSecondAss;

    private ElfPair(int elfOneFirstAss, int elfOneSecondAss, int elfTwoFirstAss, int elfTwoSecondAss) {
        this.elfOneFirstAss = elfOneFirstAss;
        this.elfOneSecondAss = elfOneSecondAss;
        this.elfTwoFirstAss = elfTwoFirstAss;
        this.elfTwoSecondAss = elfTwoSecondAss;
    }

    public boolean isOneFullyContained() {
        if (elfOneFirstAss >= elfTwoFirstAss && elfOneSecondAss <= elfTwoSecondAss) {
            return true;
        }

        return elfOneFirstAss <= elfTwoFirstAss && elfOneSecondAss >= elfTwoSecondAss;
    }

    public boolean isOnePartiallyCovered() {
        if (elfOneFirstAss >= elfTwoFirstAss && elfOneFirstAss <= elfTwoSecondAss) {
            return true;
        }

        if (elfOneSecondAss >= elfTwoFirstAss && elfOneSecondAss <= elfTwoSecondAss) {
            return true;
        }

        if (elfTwoFirstAss >= elfOneFirstAss && elfTwoFirstAss <= elfOneSecondAss) {
            return true;
        }

        return elfTwoSecondAss >= elfOneFirstAss && elfTwoSecondAss <= elfOneSecondAss;
    }

    public static ElfPair parseElfPair(String elfPairCode) {
        var asses = Arrays.stream(elfPairCode.split(",")).flatMap(o -> Arrays.stream(o.split("-"))).map(Integer::valueOf).toList();

        return new ElfPair(asses.get(0), asses.get(1), asses.get(2), asses.get(3));
    }
}
