package bombastic;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class View {
    private final Stage stage;
    private final Scene scene;
    private final Model model;

    public View(Stage stage) {
        this.stage = stage;
        model = new Model();
        scene = new Scene(new StackPane(), 1000, 700);
    }

}