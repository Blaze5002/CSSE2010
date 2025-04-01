package game;


import game.core.*;
import game.utility.Logger;
import game.core.SpaceObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Represents the game information and state. Stores and manipulates the game state.
 */
public class GameModel {

    public static final int GAME_HEIGHT = 20;
    public static final int GAME_WIDTH = 10;
    public static final int START_SPAWN_RATE = 2;
    public static final int SPAWN_RATE_INCREASE = 5;
    public static final int START_LEVEL = 1;
    public static final int SCORE_THRESHOLD = 100;
    public static final int ASTEROID_DAMAGE = 10;
    public static final int ENEMY_DAMAGE = 20;
    public static final double ENEMY_SPAWN_RATE = 0.5;
    public static final double POWER_UP_SPAWN_RATE = 0.25;

    private final List<SpaceObject> spaceObjects;
    private final Random random;
    private final Logger logger;
    private final Ship ship;
    private int level;
    private int spawnRate;

    /**
     * Models a game, storing and modifying data relevant to the game.
     *
     * @param logger a functional interface for passing information between classes.
     */
    public GameModel(Logger logger) {
        this.logger = logger;
        this.random = new Random();
        this.spaceObjects = new ArrayList<>();
        this.level = START_LEVEL;
        this.spawnRate = START_SPAWN_RATE;
        this.ship = new Ship(GAME_WIDTH / 2, GAME_HEIGHT - 1, 100);    }

    /**
     * Adds a SpaceObject to the game.
     * Objects are considered part of the game only when they are tracked by the model.
     *
     * @param object the SpaceObject to be added to the game
     * @throws IllegalArgumentException if object is null
     */
    public void addObject(SpaceObject object) {
        if (object == null) {
            throw new IllegalArgumentException("object must not be null.");
        }
        spaceObjects.add(object);
    }

    /**
     * Returns a list of all SpaceObjects in the game.
     *
     * @return the list of space objects currently in the game
     */
    public List<SpaceObject> getSpaceObjects() {
        return spaceObjects;
    }

    public void updateGame(int tick) {
        // Move each object
        for (SpaceObject obj : spaceObjects) {
            obj.tick(tick);
        }

        // Remove objects that are off-screen
        spaceObjects.removeIf(obj -> obj.getY() > GAME_HEIGHT);
    }

    public void checkCollisions() {
        List<SpaceObject> toRemove = new ArrayList<>();
        int shipX = ship.getX();
        int shipY = ship.getY();

        for (SpaceObject obj : spaceObjects) {
            // Ship collisions
            if (obj.getX() == shipX && obj.getY() == shipY) {
                if (obj instanceof PowerUp) {
                    ((PowerUp) obj).apply(ship);
                    logger.log("Power-up collected: " + obj.render());
                } else if (obj instanceof Asteroid) {
                    ship.takeDamage(ASTEROID_DAMAGE);
                    logger.log("Hit by asteroid! Health reduced by " + ASTEROID_DAMAGE + ".");
                } else if (obj instanceof Enemy) {
                    ship.takeDamage(ENEMY_DAMAGE);
                    logger.log("Hit by enemy! Health reduced by " + ENEMY_DAMAGE + ".");
                }
                toRemove.add(obj); // Remove after any ship collision
            }
        }

        // Bullet vs Enemy
        for (SpaceObject obj1 : spaceObjects) {
            if (obj1 instanceof Bullet) {
                for (SpaceObject obj2 : spaceObjects) {
                    if (obj2 instanceof Enemy && obj1.getX() == obj2.getX() && obj1.getY() == obj2.getY()) {
                        toRemove.add(obj1);
                        toRemove.add(obj2);
                    }
                }
            }
        }

        spaceObjects.removeAll(toRemove);
    }

    public Ship getShip() {
        return ship;
    }

    public int getLevel() {
        return level;
    }

    public void fireBullet() {
        int x = ship.getX();
        int y = ship.getY() - 1; // Fire from just above the ship
        Bullet bullet = new Bullet(x, y);
        addObject(bullet);
        logger.log("Core.Bullet fired!");
    }

    public void spawnObjects() {
        // 1. Asteroid spawn check
        boolean spawnAsteroid = random.nextInt(100) < spawnRate;

        // 2. Asteroid x position
        int asteroidX = random.nextInt(GAME_WIDTH);
        if (spawnAsteroid && !isShipAt(asteroidX, 0)) {
            addObject(new Asteroid(asteroidX, 0));
        }

        // 3. Enemy spawn check
        boolean spawnEnemy = random.nextInt(100) < spawnRate * ENEMY_SPAWN_RATE;

        // 4. Enemy x position
        int enemyX = random.nextInt(GAME_WIDTH);
        if (spawnEnemy && !isShipAt(enemyX, 0)) {
            addObject(new Enemy(enemyX, 0));
        }

        // 5. Power-up spawn check
        boolean spawnPowerUp = random.nextInt(100) < spawnRate * POWER_UP_SPAWN_RATE;

        // 6. Power-up x position
        int powerUpX = random.nextInt(GAME_WIDTH);

        // 7. Determine power-up type (true = shield, false = health)
        boolean isShield = random.nextBoolean();

        if (spawnPowerUp && !isShipAt(powerUpX, 0)) {
            if (isShield) {
                addObject(new ShieldPowerUp(powerUpX, 0));
            } else {
                addObject(new HealthPowerUp(powerUpX, 0));
            }
        }
    }

    public void levelUp() {
        int score = ship.getScore(); // Score comes from the Ship instance

        if (score >= level * SCORE_THRESHOLD) {
            level += 1;
            spawnRate += SPAWN_RATE_INCREASE;

            logger.log("Level Up! Welcome to Level " + level +
                    ". Spawn rate increased to " + spawnRate + "%.");
        }
    }

    private boolean isShipAt(int x, int y) {
        return ship.getX() == x && ship.getY() == y;
    }


}
