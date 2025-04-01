package game.core;

import game.ui.ObjectGraphic;

/**
 * Represents a shield power-up in the game.
 */
public class ShieldPowerUp extends PowerUp {

    /**
     * Creates a new ShieldPowerUp with the given coordinates.
     *
     * @param x the given x coordinate
     * @param y the given y coordinate
     */
    public ShieldPowerUp(int x, int y) {
        super(x, y);
    }

    /**
     * Applies the shield effect to the ship, increasing the score by 50.
     * Also prints a message to the console.
     *
     * @param ship the ship to apply the effect to
     */
    @Override
    public void applyEffect(Ship ship) {
        ship.addScore(50);
        System.out.println("Shield activated! Score increased by 50.");
    }

    /**
     * Returns a new ObjectGraphic with the appropriate text and image path.
     *
     * @return the ObjectGraphic representing the shield power-up
     */
    @Override
    public ObjectGraphic render() {
        return new ObjectGraphic("💠", "assets/shield.png");
    }
}

