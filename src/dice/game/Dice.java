package dice.game;

import java.util.Random;

public class Dice {

    private Integer face;
    private Random random = new Random();

    public Dice() {
        roll();
    }

    public void roll() {
        face = random.nextInt(6) + 1;
    }

    public Integer getFace() {
        return face;
    }

    public String toString() {
        return face.toString();
    }
}