import java.util.Random;

public class Dice {
    private int sideFacingUp;
    private int sides;
    private Random randomGenerator;

    // Constructor
    public Dice(int sides) {
        this.sides = sides;  // this is a keyword for "this" object that's being created.
        this.randomGenerator = new Random();
    }
    public void roll() {
        this.sideFacingUp = this.randomGenerator.nextInt(this.sides) + 1;
    }
    public int view() {
        return this.sideFacingUp;
    }
}
