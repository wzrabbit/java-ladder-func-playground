package model;

import java.util.List;

public class LadderGameStatus {
    private final Ladder ladder;
    private final PlayerNames playerNames;
    private final PrizeNames prizeNames;

    public LadderGameStatus(Ladder ladder, PlayerNames playerNames, PrizeNames prizeNames) {
        this.ladder = ladder;
        this.playerNames = playerNames;
        this.prizeNames = prizeNames;
    }

    public List<LadderRow> getLadder() {
        return ladder.getLadder();
    }

    public List<String> getPlayerNames() {
        return playerNames.getNames();
    }

    public List<String> getPrizeNames() {
        return prizeNames.getNames();
    }
}
