package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<LadderRow> ladder;
    private final int rowCount;
    private final int columnCount;

    public Ladder(List<LadderRow> ladder) {
        validateLadder(ladder);
        this.ladder = new ArrayList<>(ladder);
        this.rowCount = ladder.size();
        this.columnCount = ladder.get(0).size();
    }

    private void validateLadder(List<LadderRow> ladder) {
        boolean isAllLadderRowSizeSame = ladder.stream()
                .map(LadderRow::size)
                .distinct()
                .count() == 1;

        if (!isAllLadderRowSizeSame) {
            throw new IllegalArgumentException("사다리를 이루는 행의 크기는 모두 같아야 합니다.");
        }
    }

    private int getBottomIndex(int topIndex) {
        int column = topIndex;

        for (int row = 0; row < rowCount; row += 1) {
            if (column > 0 && ladder.get(row).get(column)) {
                column -= 1;
                continue;
            }

            if (column < columnCount - 1 && !ladder.get(row).get(column + 1)) {
                column += 1;
            }
        }

        return column;
    }

    public List<Integer> getConnections() {
        return IntStream.range(0, columnCount)
                .mapToObj((topIndex) -> getBottomIndex(topIndex))
                .collect(Collectors.toList());
    }

    public List<LadderRow> getLadder() {
        return Collections.unmodifiableList(ladder);
    }
}
