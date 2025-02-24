import model.Ladder;
import model.LadderGenerator;
import model.LadderRow;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LadderTest {
    @Nested
    @DisplayName("Test #1 - 사다리 생성 검증 테스트")
    class LadderValidationTest {
        @Test
        @DisplayName("주어지는 사다리가 올바르다면 예외를 발생시켜서는 안 된다.")
        void should_notThrowException_If_ValidLadderRowGiven() {
            assertDoesNotThrow(() -> {
                Ladder ladder = new Ladder(List.of(
                        new LadderRow(List.of(false, true, false)),
                        new LadderRow(List.of(true, false, true)),
                        new LadderRow(List.of(false, false, true)),
                        new LadderRow(List.of(true, false, false))
                ));
            });
        }

        @Test
        @DisplayName("사다리의 행이 빌 경우 관련 예외를 설명하는 예외를 발생시켜야 한다.")
        void should_throwException_If_EmptyLadderRowGiven() {
            assertThatIllegalArgumentException().isThrownBy(() -> {
                Ladder ladder = new Ladder(List.of(
                        new LadderRow(List.of())
                ));
            }).withMessage("사다리를 이루는 행은 비어서는 안 됩니다.");
        }

        @Test
        @DisplayName("사다리의 가로 라인이 겹치는 사다리가 주어질 경우 관련 예외를 설명하는 예외를 발생시켜야 한다.")
        void should_throwException_If_InvalidLadderRowGiven() {
            assertThatIllegalArgumentException().isThrownBy(() -> {
                Ladder ladder = new Ladder(List.of(
                        new LadderRow(List.of(false, false, false)),
                        new LadderRow(List.of(false, true, true)),
                        new LadderRow(List.of(true, false, false))
                ));
            }).withMessage("사다리를 이루는 행의 연결선은 겹칠 수 없습니다.");
        }

        @Test
        @DisplayName("크기가 서로 다른 사다리 행으로 구성된 사다리가 주어질 경우 관련 예외를 설명하는 예외를 발생시켜야 한다.")
        void should_throwException_If_DifferentLengthLadderRowGiven() {
            assertThatIllegalArgumentException().isThrownBy(() -> {
                Ladder ladder = new Ladder(List.of(
                        new LadderRow(List.of(false, true, false)),
                        new LadderRow(List.of(true, false, true, false))
                ));
            }).withMessage("사다리를 이루는 행의 크기는 모두 같아야 합니다.");
        }
    }

    @Nested
    @DisplayName("Test #2 - 사다리 관계 연결 테스트")
    class LadderConnectionTest {
        /**
         * 사다리 모양 및 관계는 아래와 같습니다.
         *
         * 0     1     2     3
         * |     |-----|     |
         * |-----|     |-----|
         * |     |     |-----|
         * |-----|     |     |
         * 0     1     2     3
         *
         * 0 -> 0
         * 1 -> 2
         * 2 -> 1
         * 3 -> 3
         */
        @Test
        @DisplayName("사다리가 주어질 경우 참가자와 실행 결과를 올바르게 짝지어야 한다.")
        void should_returnPlayerAndPrizeConnection_If_LadderGiven() {
            Ladder ladder = new Ladder(List.of(
                    new LadderRow(List.of(false, true, false)),
                    new LadderRow(List.of(true, false, true)),
                    new LadderRow(List.of(false, false, true)),
                    new LadderRow(List.of(true, false, false))
            ));
            List<Integer> expectedConnection = List.of(0, 2, 1, 3);

            assertThat(ladder.getConnections()).isEqualTo(expectedConnection);
        }
    }
}
