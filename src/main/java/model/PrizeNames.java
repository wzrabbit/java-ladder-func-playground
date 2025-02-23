package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrizeNames {
    private final List<String> prizeNames;

    public PrizeNames(List<String> prizeNames) {
        validatePrizeNames(prizeNames);
        this.prizeNames = new ArrayList<>(prizeNames);
    }

    private void validatePrizeNames(List<String> prizeNames) {
        boolean hasDuplicates = prizeNames
                .stream()
                .distinct()
                .count() != prizeNames.size();

        if (hasDuplicates) {
            throw new IllegalArgumentException("실행 결과가 중복됩니다.");
        }
    }

    public List<String> getNames() {
        return Collections.unmodifiableList(prizeNames);
    }

    public String get(int index) {
        return prizeNames.get(index);
    }

    public int size() {
        return prizeNames.size();
    }
}
