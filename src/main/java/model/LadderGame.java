package model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {
    private final Ladder ladder;
    private final PlayerNames playerNames;
    private final PrizeNames prizeNames;
    private final List<Integer> ladderConnections;

    /* 매개변수 4개는좀 에반데 -> 일단 뇌빼고구현 고 -> 나중에 DTO로빼낸다? */
    public LadderGame(LadderGenerator ladderGenerator, PlayerNames playerNames, PrizeNames prizeNames,
                      int ladderHeight) {
        this.ladder = ladderGenerator.generateLadder(ladderHeight, playerNames.size());
        this.playerNames = playerNames;
        this.prizeNames = prizeNames;
        this.ladderConnections = ladder.getConnections();
    }

    public String getPlayerPrize(PlayerName playerName) {
        int playerIndex = playerNames.getNames().indexOf(playerName.getName());

        if (playerIndex == -1) {
            return null;
        }

        return prizeNames.get(ladderConnections.get(playerIndex));
    }

    public List<LadderGamePlayerResult> getAllPlayersResult() {
        return playerNames
                .getNames()
                .stream()
                .map(playerName -> {
                    String prizeName = getPlayerPrize(new PlayerName(playerName));
                    return new LadderGamePlayerResult(new PlayerName(playerName), new PrizeName(prizeName));
                })
                .collect(Collectors.toList());
    }
}
