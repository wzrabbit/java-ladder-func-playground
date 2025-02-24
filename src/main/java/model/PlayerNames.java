package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerNames {
    private final List<PlayerName> playerNames;

    private static int MINIMUM_PLAYER_COUNT = 2;
    private static List<String> BANNED_PLAYER_NAMES = List.of("all", "exit");

    public PlayerNames(List<PlayerName> playerNames) {
        validatePlayerNames(playerNames);
        this.playerNames = new ArrayList<>(playerNames);
    }

    private void validatePlayerNames(List<PlayerName> playerNames) {
        if (playerNames.size() < MINIMUM_PLAYER_COUNT) {
            throw new IllegalArgumentException("참가자 수는 최소 " + MINIMUM_PLAYER_COUNT + "명이어야 합니다.");
        }

        boolean hasDuplicates = playerNames
                .stream()
                .map(PlayerName::getName)
                .distinct()
                .count() != playerNames.size();

        if (hasDuplicates) {
            throw new IllegalArgumentException("참가자 이름이 중복됩니다.");
        }

        playerNames.forEach((playerName) -> {
            if (BANNED_PLAYER_NAMES.contains(playerName.getName())) {
                throw new IllegalArgumentException(playerName.getName() +
                        "은 참가자의 이름으로 정하실 수 없습니다. 다른 이름을 골라주세요.");
            }
        });
    }

    public List<String> getNames() {
        return playerNames.stream()
                .map(PlayerName::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    public String get(int index) {
        return playerNames.get(index).getName();
    }

    public int size() {
        return playerNames.size();
    }
}
