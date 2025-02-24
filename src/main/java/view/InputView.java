package view;

import model.PlayerName;
import model.PlayerNames;
import model.PrizeName;
import model.PrizeNames;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static PlayerNames inputPlayerNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        PlayerNames playerNames = new PlayerNames(Arrays.stream(scanner.nextLine().split(","))
                .map((playerName) -> new PlayerName(playerName.trim()))
                .collect(Collectors.toList()));

        return playerNames;
    }

    public static PrizeNames inputPrizeNames() {
        System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        PrizeNames prizeNames = new PrizeNames(Arrays.stream(scanner.nextLine().split(","))
                .map((prizeName) -> new PrizeName(prizeName.trim()))
                .collect(Collectors.toList()));

        return prizeNames;
    }

    public static int inputLadderHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");

        return Integer.parseInt(scanner.nextLine());
    }

    public static PlayerName inputPlayerNameForResult() {
        System.out.println("\n결과를 보고 싶은 사람은? (all: 전체 / exit: 게임 종료)");

        return new PlayerName(scanner.nextLine().trim());
    }
}
