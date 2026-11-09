package bombastic;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class View {
    private Stage stage;
    private Scene scene;

    public View(Stage stage) {
        this.stage = stage;
        this.scene = new Scene(new StackPane(), 1000, 700);

        stage.setTitle("Bombastic");
        stage.setScene(scene);
    }

    public void show(Parent root) {
        scene.setRoot(root);
        stage.show();
    }

    public static void bindToScreenState(
            Node screen,
            ReadOnlyObjectProperty<ScreenState> screenState,
            ScreenState activeState) {

        BooleanBinding active = Bindings.createBooleanBinding(
                () -> screenState.get() == activeState,
                screenState
        );

        screen.visibleProperty().bind(active);
        screen.managedProperty().bind(active);
    }

    public static void applyBackground(
            Region root,
            ReadOnlyStringProperty backgroundName) {
        setBackground(root, backgroundName.get());
        backgroundName.addListener((obs, oldName, newName) ->
                setBackground(root, newName)
        );
    }

    private static void setBackground(Region root, String backgroundName) {
        String filename = switch (backgroundName) {
            case "Background 1" -> "bg1.png";
            case "Background 2" -> "bg2.png";
            case "Background 3" -> "bg3.png";
            default -> backgroundName;
        };



        String path = "/resources/images/" + filename;
        var resource = View.class.getResource(path);

        
        if (resource == null) {
            throw new IllegalStateException("Image not found: " + path);
        }

        Image image = new Image(resource.toExternalForm());
        if (image.isError()) {
            throw new IllegalStateException(
                    "Failed to load image: " + path,
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
        root.setBackground(new Background(backgroundImage));
    }
}