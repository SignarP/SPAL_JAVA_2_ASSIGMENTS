package bombastic.game.entities;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class Entity {

    private final double x;
    private final double y;
    private final double width;
    private final double height;
    private final Image image;

    protected Entity(double x, double y, double width, double height, Image image) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.image = image;
    }

    protected static Image loadImage(String resourcePath) {
        var resource = Entity.class.getResource(resourcePath);
        if (resource == null) {
            throw new IllegalStateException("Image not found: " + resourcePath);
        }

        Image image = new Image(resource.toExternalForm());
        if (image.isError()) {
            throw new IllegalStateException("Could not load image: " + resourcePath, image.getException());
        }
        return image;
    }

    public abstract boolean isOccupying();

    public abstract void interact(Entity other);

    public abstract void update(double dt);

    public void render(GraphicsContext gc) {
        gc.drawImage(image, x, y, width, height);
    }
}
