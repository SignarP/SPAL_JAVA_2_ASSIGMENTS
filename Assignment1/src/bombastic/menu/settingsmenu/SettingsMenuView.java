package bombastic.menu.settingsmenu;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class SettingsMenuView extends StackPane {

    private final Runnable exit;

    public SettingsMenuView(Runnable exit) {
        this.exit = exit;
    }

    public SettingsMenuView build() {

        Label title = new Label("Settings");

        Button exitButton = new Button("Main Menu");
        exitButton.setOnAction(_ -> exit.run());

        VBox layout = new VBox(20, title, exitButton);
        layout.setAlignment(Pos.CENTER);

        getChildren().setAll(layout);

        return this;
    }
}