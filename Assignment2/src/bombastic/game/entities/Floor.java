package bombastic.game.entities;

import javafx.scene.image.Image;

public class Floor extends TileEntity {

    private static final Image IMAGE = loadImage("/resources/assets/terrain/grass.png");

    public Floor(double x, double y, double size) {
        super(x, y, size, IMAGE, false);
    }
}
