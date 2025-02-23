package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayerNames {
    private final List<String> playerNames;

    public PlayerNames(List<String> playerNames) {
        validatePlayerNames(playerNames);
        this.playerNames = new ArrayList<>(playerNames);
    }

    private void validatePlayerNames(List<String> playerNames) {
        boolean hasDuplicates = playerNames
                .stream()
                .distinct()
                .count() != playerNames.size();

        if (hasDuplicates) {
            throw new IllegalArgumentException("참가자 이름이 중복됩니다.");
        }
    }

    public List<String> getNames() {
        return Collections.unmodifiableList(playerNames);
    }

    public String get(int index) {
        return playerNames.get(index);
    }

    public int size() {
        return playerNames.size();
    }
}
