package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGenerator {
    private final BooleanValueGenerator booleanValueGenerator;

    public LadderGenerator(BooleanValueGenerator booleanValueGenerator) {
        this.booleanValueGenerator = booleanValueGenerator;
    }

    public Ladder generateLadder(int rowCount, int columnCount) {
        List<LadderRow> ladder = IntStream.range(0, rowCount)
                .mapToObj((index) -> generateRow(columnCount))
                .collect(Collectors.toList());

        return new Ladder(ladder);
    }

    private LadderRow generateRow(int ladderRowSize) {
        List<Boolean> ladderRow = new ArrayList<>();

        while (ladderRow.size() < ladderRowSize) {
            if (ladderRow.size() == 0 || ladderRow.get(ladderRow.size() - 1)) {
                ladderRow.add(booleanValueGenerator.generate());
                continue;
            }

            ladderRow.add(false);
        }

        return new LadderRow(ladderRow);
    }
}
