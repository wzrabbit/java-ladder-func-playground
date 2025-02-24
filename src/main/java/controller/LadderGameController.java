package controller;

import model.*;
import view.InputView;
import view.OutputView;

import java.util.InputMismatchException;

public class LadderGameController {
    private LadderGame ladderGame;
    private final LadderGenerator ladderGenerator = new LadderGenerator(new LadderConnectionGenerator());

    public void inputGameInfos() {
        PlayerNames playerNames = inputPlayerNames();
        PrizeNames prizeNames = inputPrizeNames(playerNames.size());
        int ladderHeight = inputLadderHeight();

        ladderGame = new LadderGame(ladderGenerator, playerNames, prizeNames, ladderHeight);
    }

    public void showGameStatus() {
        OutputView.printGameStatus(ladderGame.getGameStatus());
    }

    public void showGameResult() {
        while (true) {
            PlayerName playerNameForResult = InputView.inputPlayerNameForResult();

            if (playerNameForResult.getName().equals("all")) {
                OutputView.printAllPlayersResult(ladderGame.getAllPlayersResult());
                continue;
            }

            if (playerNameForResult.getName().equals("exit")) {
                OutputView.printExitMessage();
                break;
            }

            OutputView.printPlayerResult(ladderGame.getPlayerPrize(playerNameForResult));
        }
    }


    private PlayerNames inputPlayerNames() {
        while (true) {
            try {
                return InputView.inputPlayerNames();
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private PrizeNames inputPrizeNames(int prizeCount) {
        while (true) {
            try {
                return InputView.inputPrizeNames();
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private int inputLadderHeight() {
        while (true) {
            try {
                int ladderHeight = InputView.inputLadderHeight();

                if (ladderHeight <= 0) {
                    throw new IllegalArgumentException("사다리 높이를 양수로 입력해주세요.");
                }

                return ladderHeight;
            } catch (NumberFormatException e) {
                OutputView.printErrorMessage("사다리 높이를 정수로 입력해주세요!");
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private PlayerName inputPlayerNameForResult() {
        while (true) {
            try {
                return inputPlayerNameForResult();
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
