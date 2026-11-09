package bombastic.menu.mainmenu;

import javafx.beans.property.ReadOnlyStringProperty;
import javafx.geometry.Pos;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class MainMenuView extends StackPane {

    private final ReadOnlyStringProperty titleText;
    private final Runnable startGame;
    private final Runnable openChat;
    private final Runnable openSettings;
    private final Runnable exitGame;

    public MainMenuView(
            ReadOnlyStringProperty titleText,
            Runnable startGame,
            Runnable openChat,
            Runnable openSettings,
            Runnable exitGame) {
        this.titleText = titleText;
        this.startGame = startGame;
        this.openChat = openChat;
        this.openSettings = openSettings;
        this.exitGame = exitGame;
    }

    public MainMenuView build() {
        Label title = new Label();
        title.textProperty().bind(titleText);
        title.setFont(Font.font("System", FontWeight.BOLD, 32));
        title.setTextFill(Color.WHITE);

        Button startButton = createButton("Start game", startGame);
        Button chatButton = createButton("Chat", openChat);
        Button settingsButton = createButton("Settings", openSettings);
        Button exitButton = createButton("Exit", exitGame);

        VBox menu = new VBox(
                20,
                title,
                startButton,
                chatButton,
                settingsButton,
                exitButton
        );
        menu.setAlignment(Pos.CENTER);
        menu.setMaxWidth(1000);
       

        setAlignment(Pos.CENTER);
        getChildren().setAll(menu);
        return this;
    }

    private Button createButton(String text, Runnable action) {
        Button button = new Button(text);
        button.setPrefWidth(250);
        button.setPrefHeight(45);
        button.setOnAction(_ -> action.run());
        return button;
    }
}