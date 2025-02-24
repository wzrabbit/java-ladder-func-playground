import model.*;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderGeneratorTest {
    @Nested
    @DisplayName("Test #1 - 사다리 생성 테스트")
    class LadderCreationTest {
        @Test
        @DisplayName("랜덤 값을 이용해 사다리를 생성할 경우 그 값이 반환되어야 한다.")
        void should_returnLadderWithoutException_IfValidLadderRandomValueGiven() {
            TestLadderConnectionGenerator testLadderConnectionGenerator =
                    new TestLadderConnectionGenerator(List.of(
                            true, false, true, false, true, true,
                            false, false, false, false, true
                    ));
            LadderGenerator ladderGenerator = new LadderGenerator(testLadderConnectionGenerator);
            Ladder expectedLadder = new Ladder(List.of(
                    new LadderRow(List.of(true, false, false, true, false)),
                    new LadderRow(List.of(false, true, false, true, false)),
                    new LadderRow(List.of(false, false, false, false, true))
            ));

            assertThat(ladderGenerator.generateLadder(3, 6))
                    .usingRecursiveComparison()
                    .isEqualTo(expectedLadder);
        }
    }
}
