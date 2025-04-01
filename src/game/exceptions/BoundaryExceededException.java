package game.exceptions;

/**
 * An exception indicating a Controllable is attempting to move outside the game boundaries.
 */
public class BoundaryExceededException extends RuntimeException {

    /**
     * Creates a new BoundaryExceededException with the provided message.
     *
     * @param message the provided message
     */
    public BoundaryExceededException(String message) {
        super(message);
    }
}
