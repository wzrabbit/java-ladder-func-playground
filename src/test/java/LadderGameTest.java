import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {
    @Nested
    @DisplayName("Test #1 - 게임 결과 반환 테스트")
    class LadderGameResultTest {
        private LadderGame ladderGame;

        /**
         * 사다리 모양 및 관계는 아래와 같습니다.
         *
         * Alice   Bob  Cara  Drew  Elsa
         *     |     |-----|     |     |
         *     |-----|     |     |-----|
         *     |-----|     |     |     |
         *     |     |     |-----|     |
         *     |-----|     |     |-----|
         *     |     |     |     |-----|
         *   30$    0$ 1000$   10$  150$
         *
         * Alice ->    0$
         * Bob   ->   10$
         * Cara  ->   30$
         * Drew  ->  150$
         * Elsa  -> 1000$
         */
        @BeforeEach
        void setupLadder() {
            TestLadderConnectionGenerator testLadderConnectionGenerator =
                    new TestLadderConnectionGenerator(List.of(
                            false, true, false, true, false, true, true, false, false, false,
                            false, true, true, false, true, false, false, false, true
                    ));
            LadderGenerator ladderGenerator = new LadderGenerator(testLadderConnectionGenerator);
            PlayerNames playerNames = new PlayerNames(List.of(
                    new PlayerName("Alice"),
                    new PlayerName("Bob"),
                    new PlayerName("Cara"),
                    new PlayerName("Drew"),
                    new PlayerName("Elsa")
            ));
            PrizeNames prizeNames = new PrizeNames(List.of(
                    new PrizeName("30$"),
                    new PrizeName("0$"),
                    new PrizeName("1000$"),
                    new PrizeName("10$"),
                    new PrizeName("150$")
            ));
            int ladderHeight = 6;

            ladderGame = new LadderGame(ladderGenerator, playerNames, prizeNames, ladderHeight);
        }

        @Test
        @DisplayName("전체 참가자의 결과를 조회할 경우 전체 참가자의 결과가 올바르게 짝지어 반환되어야 한다.")
        void should_returnCorrectConnectionOfAllPlayers_IfCalled() {
            List<LadderGamePlayerResult> ladderGamePlayerResults = List.of(
                    new LadderGamePlayerResult(new PlayerName("Alice"), new PrizeName("0$")),
                    new LadderGamePlayerResult(new PlayerName("Bob"), new PrizeName("10$")),
                    new LadderGamePlayerResult(new PlayerName("Cara"), new PrizeName("30$")),
                    new LadderGamePlayerResult(new PlayerName("Drew"), new PrizeName("150$")),
                    new LadderGamePlayerResult(new PlayerName("Elsa"), new PrizeName("1000$"))
            );

            assertThat(ladderGame.getAllPlayersResult())
                    .usingRecursiveComparison()
                    .isEqualTo(ladderGamePlayerResults);
        }

        @Test
        @DisplayName("각 참가자의 결과를 조회할 경우 각 참가자의 결과가 올바르게 짝지어 반환되어야 한다.")
        void should_returnCorrectConnectionOfPlayer_IfCalled() {
            assertThat(ladderGame.getPlayerPrize(new PlayerName("Cara")))
                    .isEqualTo("30$");

            assertThat(ladderGame.getPlayerPrize(new PlayerName("Elsa")))
                    .isEqualTo("1000$");
        }
    }
}
