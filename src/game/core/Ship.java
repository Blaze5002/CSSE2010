package game.core;

import game.ui.ObjectGraphic;

/**
 * Represents the player's ship.
 */
public class Ship extends Controllable {

    private int health;
    private int score;

    /**
     * Constructs a Ship with default position and health.
     * Default position: x = 5, y = 10
     * Default health: 100
     */
    public Ship() {
        this(5, 10, 100);
    }

    /**
     * Constructs a Ship with the specified position and health.
     * Also initialises score to 0.
     *
     * @param x      the initial x coordinate
     * @param y      the initial y coordinate
     * @param health the initial health of the ship
     */
    public Ship(int x, int y, int health) {
        super(x, y);
        this.health = health;
        this.score = 0;
    }

    /**
     * Reduces the ship's health by the specified damage amount.
     * Health cannot fall below 0.
     *
     * @param damage the amount of damage taken
     */
    public void takeDamage(int damage) {
        health = Math.max(0, health - damage);
    }

    /**
     * Heals the ship by the specified amount.
     * Health cannot exceed 100.
     *
     * @param amount the amount of health restored
     */
    public void heal(int amount) {
        health = Math.min(100, health + amount);
    }

    /**
     * Adds points to the ship's score.
     *
     * @param points the points to add
     */
    public void addScore(int points) {
        score += points;
    }

    /**
     * Returns the current health of the ship.
     *
     * @return the current health
     */
    public int getHealth() {
        return health;
    }

    /**
     * Returns the current score of the ship.
     *
     * @return the current score
     */
    public int getScore() {
        return score;
    }

    /**
     * As Ships have no tick-dependent behaviour, this method is left blank.
     *
     * @param tick the given game tick
     */
    @Override
    public void tick(int tick) {
        // Ships don't need to do anything each tick
    }

    /**
     * Returns a new ObjectGraphic with the appropriate text and image for the ship.
     *
     * @return the ObjectGraphic representing the ship
     */
    @Override
    public ObjectGraphic render() {
        return new ObjectGraphic("🚀", "assets/ship.png");
    }
}
