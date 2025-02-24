package view;

import model.LadderGamePlayerResult;
import model.LadderGameStatus;
import model.PlayerName;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static void printErrorMessage(String errorMessage) {
        System.out.println("\n[ERROR!] " + errorMessage);
        System.out.println("[i] 다시 입력해 주세요...\n");
    }

    public static void printGameStatus(LadderGameStatus ladderGameStatus) {
        System.out.println("\n사다리 결과\n");

        ladderGameStatus.getPlayerNames().forEach((playerName) -> {
            System.out.printf("%6s", playerName);
        });
        System.out.println();

        ladderGameStatus.getLadder().forEach(((ladderRow) -> {
            String asciiLadder = "     |" + ladderRow.getRow().stream()
                    .map(ladderConnection -> {
                        if (ladderConnection) {
                            return "-----";
                        }
                            return "     ";
                    })
                    .collect(Collectors.joining("|")) + "|";
            System.out.println(asciiLadder);
        }));


        ladderGameStatus.getPrizeNames().forEach((prizeName) -> {
            System.out.printf("%6s", prizeName);
        });
        System.out.println();
    }

    public static void printAllPlayersResult(List<LadderGamePlayerResult> ladderGamePlayerResults) {
        System.out.println("\n실행 결과");

        ladderGamePlayerResults.forEach(((ladderGamePlayerResult) -> {
            System.out.printf("%s : %s\n", ladderGamePlayerResult.getPlayerName(),
                    ladderGamePlayerResult.getPrizeName());
        }));
    }

    public static void printPlayerResult(String playerResult) {
        if (playerResult == null) {
            System.out.println("\n해당 참가자의 이름이 존재하지 않습니다.");
            return;
        }

        System.out.println("\n실행 결과");
        System.out.println(playerResult);
    }

    public static void printExitMessage() {
        System.out.println("\n사다리 게임을 종료합니다...");
    }
}
