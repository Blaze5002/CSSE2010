package game.core;

import game.ui.ObjectGraphic;

/**
 * Represents an enemy UFO in the game.
 */
public class Enemy extends DescendingEnemy {

    /**
     * Creates an enemy at the given coordinates.
     *
     * @param x the given x coordinate
     * @param y the given y coordinate
     */
    public Enemy(int x, int y) {
        super(x, y);
    }

    /**
     * Returns a new ObjectGraphic with the appropriate text representation and image path.
     * Text: "👾"
     * Image: "assets/enemy.png"
     *
     * @return the appropriate new ObjectGraphic
     */
    @Override
    public ObjectGraphic render() {
        return new ObjectGraphic("👾", "assets/enemy.png");
    }
}
