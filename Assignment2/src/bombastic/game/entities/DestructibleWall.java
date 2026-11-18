package bombastic.game.entities;

import javafx.scene.image.Image;

public class DestructibleWall extends TileEntity {

    private static final Image IMAGE = loadImage("/resources/assets/terrain/crate.png");

    public DestructibleWall(double x, double y, double size) {
        super(x, y, size, IMAGE, true);
    }
}
