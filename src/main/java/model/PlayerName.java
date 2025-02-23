package model;

import java.util.List;

public class PlayerName {
    private final String playerName;

    private static final int MIN_PLAYER_NAME_LENGTH = 1;
    private static final int MAX_PLAYER_NAME_LENGTH = 5;
    private static final List<String> BANNED_PLAYER_NAMES = List.of("all", "exit");

    public PlayerName(String playerName) {
        validatePlayerName();
        this.playerName = playerName;
    }

    private void validatePlayerName() {
        if (playerName.length() < MIN_PLAYER_NAME_LENGTH || playerName.length() > MAX_PLAYER_NAME_LENGTH) {
            throw new IllegalArgumentException("참가자의 이름은 " + MIN_PLAYER_NAME_LENGTH + "글자 이상 " +
                    MAX_PLAYER_NAME_LENGTH + "이하여야 합니다.");
        }

        if (BANNED_PLAYER_NAMES.contains(playerName)) {
            throw new IllegalArgumentException(playerName +
                    "은 참가자의 이름으로 정하실 수 없습니다. 다른 이름을 골라주세요.");
        }
    }

    public String getName() {
        return playerName;
    }
}
