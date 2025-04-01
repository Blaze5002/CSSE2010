package game.core;



public abstract class PowerUp extends ObjectWithPosition implements PowerUpEffect {

    public PowerUp(int x, int y) {
        super(x, y);
    }

    @Override
    public void tick(int tick) {
        // PowerUps don't move
    }

    public void apply(Ship ship) {
        applyEffect(ship); // Delegates to specific subclass
    }
}

