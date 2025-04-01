package game.core;

import game.ui.ObjectGraphic;

/**
 * Represents a bullet fired by the ship.
 */
public class Bullet extends ObjectWithPosition {

    /**
     * Creates a bullet at the given coordinates.
     *
     * @param x the given x coordinate
     * @param y the given y coordinate
     */
    public Bullet(int x, int y) {
        super(x, y);
    }

    /**
     * Moves the bullet upwards by one, regardless of the provided game tick.
     *
     * @param tick the given game tick (unused)
     */
    @Override
    public void tick(int tick) {
        y -= 1; // Move up by 1
    }

    /**
     * Returns a new ObjectGraphic representing the bullet.
     * Text representation: "🔺"
     * Image path: "assets/bullet.png"
     *
     * @return the ObjectGraphic for this bullet
     */
    @Override
    public ObjectGraphic render() {
        return new ObjectGraphic("🔺", "assets/bullet.png");
    }
}
