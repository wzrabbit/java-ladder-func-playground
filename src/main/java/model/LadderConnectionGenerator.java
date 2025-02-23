package model;

import java.util.Random;

public class LadderConnectionGenerator implements BooleanValueGenerator {
    private final Random random = new Random();

    public boolean generate() {
        return random.nextBoolean();
    }
}
