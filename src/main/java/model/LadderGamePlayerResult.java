package model;

public class LadderGamePlayerResult {
    private final PlayerName playerName;
    private final PrizeName prizeName;

    public LadderGamePlayerResult(PlayerName playerName, PrizeName prizeName) {
        this.playerName = playerName;
        this.prizeName = prizeName;
    }

    public String getPlayerName() {
        return this.playerName.getName();
    }

    public String getPrizeName() {
        return this.prizeName.getName();
    }
}
