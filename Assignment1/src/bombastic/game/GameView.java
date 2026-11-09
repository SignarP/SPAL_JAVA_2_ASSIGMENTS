package bombastic.game;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class GameView extends StackPane {

    private final Runnable exit;

    public GameView(Runnable exit) {
        this.exit = exit;

        Button exitButton = new Button("Main Menu");
        exitButton.setOnAction(_ -> exit.run());

        VBox layout = new VBox(20, exitButton);
        layout.setAlignment(Pos.CENTER);

        getChildren().add(layout);
    }
}