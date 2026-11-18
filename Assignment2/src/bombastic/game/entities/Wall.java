package bombastic.game.entities;

import javafx.scene.image.Image;

public class Wall extends TileEntity {

    private static final Image IMAGE = loadImage("/resources/assets/terrain/wall.png");

    public Wall(double x, double y, double size) {
        super(x, y, size, IMAGE, true);
    }
}
