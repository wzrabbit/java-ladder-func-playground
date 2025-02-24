package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PrizeNames {
    private final List<PrizeName> prizeNames;

    private static int MINIMUM_PRIZE_COUNT = 2;

    public PrizeNames(List<PrizeName> prizeNames) {
        validatePrizeNames(prizeNames);
        this.prizeNames = new ArrayList<>(prizeNames);
    }

    private void validatePrizeNames(List<PrizeName> prizeNames) {
        if (prizeNames.size() < MINIMUM_PRIZE_COUNT) {
            throw new IllegalArgumentException("실행 결과의 수는 최소 " + MINIMUM_PRIZE_COUNT + "개여야 합니다.");
        }
    }

    public List<String> getNames() {
        return prizeNames.stream()
                .map(PrizeName::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    public String get(int index) {
        return prizeNames.get(index).getName();
    }

    public int size() {
        return prizeNames.size();
    }
}
