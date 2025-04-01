package game.core;

import game.GameModel;
import game.utility.Direction;
import game.exceptions.BoundaryExceededException;


/**
 * Represents a controllable object in the space game.
 */
public abstract class Controllable extends ObjectWithPosition {

    /**
     * Creates a controllable object at the given coordinates.
     *
     * @param x the given x coordinate
     * @param y the given y coordinate
     */
    public Controllable(int x, int y) {
        super(x, y);
    }

    /**
     * Moves the Controllable by one in the direction given.
     *
     * @param direction the direction to move
     * @throws BoundaryExceededException if attempting to move outside the game boundaries
     */
    public void move(Direction direction) throws BoundaryExceededException {
        int newX = x;
        int newY = y;

        switch (direction) {
            case UP:
                newY -= 1;
                if (newY < 0)
                    throw new BoundaryExceededException("Cannot move up. Out of bounds!");
                break;
            case DOWN:
                newY += 1;
                if (newY >= GameModel.GAME_HEIGHT)
                    throw new BoundaryExceededException("Cannot move down. Out of bounds!");
                break;
            case LEFT:
                newX -= 1;
                if (newX < 0)
                    throw new BoundaryExceededException("Cannot move left. Out of bounds!");
                break;
            case RIGHT:
                newX += 1;
                if (newX >= GameModel.GAME_WIDTH)
                    throw new BoundaryExceededException("Cannot move right. Out of bounds!");
                break;
        }

        // Valid move
        x = newX;
        y = newY;
    }
}