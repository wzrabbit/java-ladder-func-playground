import model.BooleanValueGenerator;

import java.util.ArrayList;
import java.util.List;

class TestLadderConnectionGenerator implements BooleanValueGenerator {
    private int mockValueIndex = 0;
    private final List<Boolean> mockValues;

    TestLadderConnectionGenerator(List<Boolean> mockValues) {
        this.mockValues = new ArrayList<>(mockValues);
    }

    @Override
    public boolean generate() {
        if (mockValueIndex >= mockValues.size()) {
            throw new IllegalStateException("더 이상 사용할 모의 랜덤 값이 없습니다.");
        }

        boolean currentMockValue = mockValues.get(mockValueIndex);
        mockValueIndex += 1;

        return currentMockValue;
    }
}
