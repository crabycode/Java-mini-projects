abstract class Vehichle {
    int speed;
    public static final int MAX_SPEED = 50;
    public static final int MIN_SPEED = 0;

    public Vehichle(int speed) {
        this.speed = speed;
    }
    public abstract void accelerate();
    public abstract void brake();
}
