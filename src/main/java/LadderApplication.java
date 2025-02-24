import controller.LadderGameController;

public class LadderApplication {
    public static void main(String[] args) {
        final LadderGameController ladderGameController = new LadderGameController();

        ladderGameController.inputGameInfos();
        ladderGameController.showGameStatus();
        ladderGameController.showGameResult();
    }
}
