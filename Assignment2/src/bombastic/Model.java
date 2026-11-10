
package bombastic;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

public class Model {

    private final SimpleObjectProperty<State> state = new SimpleObjectProperty<>(State.MAIN_MENU_ACTIVE);
    private final SimpleObjectProperty<Background> background = new SimpleObjectProperty<>(createBackground("bg1.png"));
    private final SimpleStringProperty arena = new SimpleStringProperty("Arena 1");

    private Background createBackground(String imageName) {
        var resource = Model.class.getResource("/resources/images/" + imageName);

        if (resource == null) {
            throw new IllegalStateException("Image not found: " + imageName);
        }

        Image image = new Image(resource.toExternalForm());

        BackgroundImage backgroundImage = new BackgroundImage(
                image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(1, 1, true, true, false, false)
        );
        return new Background(backgroundImage);
    }

    public SimpleObjectProperty<Background> backgroundProperty() {
        return background;
    }

    public SimpleObjectProperty<State> stateProperty() {
        return state;
    }

    public void setState(State state) {
        this.state.set(state);
    }

    public void setBackground(String imageName) {
        background.set(createBackground(imageName));
    }

    public SimpleStringProperty arenaProperty() {
        return arena;
    }

    public void setArena(String arenaName) {
        arena.set(arenaName);
    }
}
