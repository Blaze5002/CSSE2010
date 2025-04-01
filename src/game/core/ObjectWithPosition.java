package game.core;

/**
 * Represents a movable and interactive object in the space game.
 * Implements basic position handling, meant to be extended by more specific game objects.
 */
public abstract class ObjectWithPosition implements SpaceObject {

    protected int x; // The x coordinate of the object
    protected int y; // The y coordinate of the object

    /**
     * Creates a movable and interactive object at the given coordinates.
     *
     * @param x the initial x coordinate
     * @param y the initial y coordinate
     */
    public ObjectWithPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the x coordinate of the SpaceObject.
     * 0 represents the left-most space, positive numbers extend to the right.
     *
     * @return the x coordinate
     */
    @Override
    public int getX() {
        return x;
    }

    /**
     * Returns the y coordinate of the SpaceObject.
     * 0 represents the top-most space, positive numbers extend downwards.
     *
     * @return the y coordinate
     */
    @Override
    public int getY() {
        return y;
    }

    // The tick() and render() methods are abstract, so subclasses must implement them
}
