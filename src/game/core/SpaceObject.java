package game.core;

import game.ui.Tickable;
import game.ui.ObjectGraphic;

public interface SpaceObject extends Tickable {

    /**
     * Returns the x coordinate of the SpaceObject.
     * 0 represents the left-most space; positive numbers extend to the right.
     *
     * @return the x coordinate of the SpaceObject
     */
    int getX();

    /**
     * Returns the y coordinate of the SpaceObject.
     * 0 represents the top-most space; positive numbers extend downwards.
     *
     * @return the y coordinate of the SpaceObject
     */
    int getY();

    /**
     * Returns a new ObjectGraphic with the appropriate text representation and image path.
     *
     * @return the ObjectGraphic representing this SpaceObject
     */
    ObjectGraphic render();
}
