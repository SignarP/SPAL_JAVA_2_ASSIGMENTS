package bombastic;

import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

public class Model {

    private final Background background;

    public Model() {
        var resource = Model.class.getResource("/resources/images/bg1.png");
        if (resource == null) {
            throw new IllegalStateException("Image not found: /resources/images/bg1.png");
        }

        Image image = new Image(resource.toExternalForm());
        if (image.isError()) {
            throw new IllegalStateException(
                    "Failed to load image: /resources/images/bg1.png",
                    image.getException()
            );
        }

        BackgroundImage backgroundImage = new BackgroundImage(
                image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(1, 1, true, true, false, false)
        );
        background = new Background(backgroundImage);
    }

    public Background getBackground() {
        return background;
    }
}
