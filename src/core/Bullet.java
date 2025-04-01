package game.core;

public class Bullet extends SpaceObject {

    private final int speed;
    private int x;

    public Bullet(int x, int y, int speed) {
        super(x, y); // Call the constructor of SpaceObject
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void move() {
        this.x += speed; // For example, moving to the right
    }

    @Override
    public String toString() {
        return "Bullet at (" + getX() + ", " + getY() + ") moving at speed " + speed;
    }

    private java.lang.String getY() {
    }

    private java.lang.String getX() {
        return null;
    }
}
