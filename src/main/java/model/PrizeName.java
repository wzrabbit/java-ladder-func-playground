package model;

import java.util.List;

public class PrizeName {
    private final String prizeName;

    private static final int MIN_PRIZE_NAME_LENGTH = 1;
    private static final int MAX_PRIZE_NAME_LENGTH = 5;

    public PrizeName(String prizeName) {
        validatePrizeName();
        this.prizeName = prizeName;
    }

    private void validatePrizeName() {
        if (prizeName.length() < MIN_PRIZE_NAME_LENGTH || prizeName.length() > MAX_PRIZE_NAME_LENGTH) {
            throw new IllegalArgumentException("실행 결과의 길이는 " + MIN_PRIZE_NAME_LENGTH + "글자 이상 " +
                    MAX_PRIZE_NAME_LENGTH + "이하여야 합니다.");
        }
    }

    public String getName() {
        return prizeName;
    }
}
