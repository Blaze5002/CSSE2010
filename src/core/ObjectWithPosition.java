package game.core;

public abstract class ObjectWithPosition implements SpaceObject, Tickable {

    protected int x;
    protected int y;

    /**
     * Creates a movable and interactive object at the given coordinates.
     *
     * @param x the given x coordinate
     * @param y the given y coordinate
     */
    public ObjectWithPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the x coordinate of the SpaceObject.
     * 0 represents the left-most space with positive numbers extending to the right.
     *
     * @return x coordinate
     */
    @Override
    public int getX() {
        return x;
    }

    /**
     * Returns the y coordinate of the SpaceObject.
     * 0 represents the top-most space with positive numbers extending downwards.
     *
     * @return y coordinate
     */
    @Override
    public int getY() {
        return y;
    }

    /**
     * Each subclass must define how the object behaves per game tick.
     */
    @Override
    public abstract void tick();

    /**
     * Each subclass must define how the object renders itself.
     */
    @Override
    public abstract void render();
}