package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderRow {
    private final List<Boolean> ladderRow;

    public LadderRow(List<Boolean> ladderRow) {
        validateLadderLine(ladderRow);
        this.ladderRow = new ArrayList<>(ladderRow);
    }

    private void validateLadderLine(List<Boolean> ladderRow) {
        if (ladderRow.isEmpty()) {
            throw new IllegalArgumentException("사다리를 이루는 행은 비어서는 안 됩니다.");
        }

        for (int i = 0; i < ladderRow.size() - 1; i++) {
            if (ladderRow.get(i) && ladderRow.get(i + 1)) {
                throw new IllegalArgumentException("사다리를 이루는 행의 연결선은 겹칠 수 없습니다.");
            }
        }
    }

    public List<Boolean> getRow() {
        return Collections.unmodifiableList(ladderRow);
    }

    public boolean get(int index) {
        return ladderRow.get(index);
    }

    public int size() {
        return ladderRow.size();
    }
}
