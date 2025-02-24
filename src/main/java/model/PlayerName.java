package model;

import java.util.ArrayList;
import java.util.List;

public class PlayerName {
    private final String playerName;

    private static final int MIN_PLAYER_NAME_LENGTH = 1;
    private static final int MAX_PLAYER_NAME_LENGTH = 5;

    public PlayerName(String playerName) {
        validatePlayerName(playerName);
        this.playerName = playerName;
    }

    private void validatePlayerName(String playerName) {
        if (playerName.length() < MIN_PLAYER_NAME_LENGTH || playerName.length() > MAX_PLAYER_NAME_LENGTH) {
            throw new IllegalArgumentException("참가자의 이름은 " + MIN_PLAYER_NAME_LENGTH + "글자 이상 " +
                    MAX_PLAYER_NAME_LENGTH + "이하여야 합니다.");
        }
    }

    public String getName() {
        return playerName;
    }
}
