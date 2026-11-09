package bombastic.menu.chatmenu;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class ChatMenuView extends StackPane {

    private final Runnable exit;

    public ChatMenuView(Runnable exit) {
        this.exit = exit;
    }

    public ChatMenuView build() {

        Label title = new Label("Chat");

        Button exitButton = new Button("Main Menu");
        exitButton.setOnAction(_ -> exit.run());

        VBox layout = new VBox(20, title, exitButton);
        layout.setAlignment(Pos.CENTER);

        getChildren().setAll(layout);

        return this;
    }
}