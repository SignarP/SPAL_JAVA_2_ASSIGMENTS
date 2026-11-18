package bombastic.menu.mainmenu;

import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class MainMenuView extends StackPane {

    private final Label title;
    private final Button startButton;
    private final Button chatButton;
    private final Button settingsButton;
    private final Button exitButton;
    private final VBox menu;

    public MainMenuView(
            SimpleStringProperty titleText,
            Runnable startGame,
            Runnable openChat,
            Runnable openSettings,
            Runnable exitGame) {
        title = new Label();
        title.textProperty().bind(titleText);
        title.setFont(Font.font("System", FontWeight.BOLD, 32));
        title.setTextFill(Color.WHITE);

        startButton = new Button("Start game");
        startButton.setPrefSize(250, 45);
        startButton.setOnAction(_ -> startGame.run());

        chatButton = new Button("Chat");
        chatButton.setPrefSize(250, 45);
        chatButton.setOnAction(_ -> openChat.run());

        settingsButton = new Button("Settings");
        settingsButton.setPrefSize(250, 45);
        settingsButton.setOnAction(_ -> openSettings.run());

        exitButton = new Button("Exit");
        exitButton.setPrefSize(250, 45);
        exitButton.setOnAction(_ -> exitGame.run());

        menu = new VBox(20, title, startButton, chatButton, settingsButton, exitButton);
        menu.setAlignment(Pos.CENTER);
        menu.setMaxWidth(1000);
        

        setAlignment(Pos.CENTER);
        getChildren().add(menu);
    }
}
