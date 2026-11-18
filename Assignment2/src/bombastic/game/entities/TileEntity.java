package bombastic.game.entities;

import javafx.scene.image.Image;

public abstract class TileEntity extends Entity {

    private final boolean occupying;

    protected TileEntity(double x, double y, double size, Image image, boolean occupying) {
        super(x, y, size, size, image);
        this.occupying = occupying;
    }

    @Override
    public boolean isOccupying() {
        return occupying;
    }

    @Override
    public void interact(Entity other) {
    }

    @Override
    public void update(double dt) {
    }
}
