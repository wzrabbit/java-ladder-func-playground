package model;

import java.util.Random;

public class LadderConnectionGenerator implements BooleanValueGenerator {
    private final Random random = new Random();

    @Override
    public boolean generate() {
        return random.nextBoolean();
    }
}
