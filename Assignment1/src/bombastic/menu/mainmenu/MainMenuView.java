package bombastic.menu.mainmenu;

import bombastic.ScreenState;
import bombastic.View;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.geometry.Pos;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class MainMenuView extends StackPane {

    public MainMenuView(
            ReadOnlyStringProperty backgroundName,
            ReadOnlyStringProperty titleText,
            ReadOnlyObjectProperty<ScreenState> screenState,
            Runnable startGame,
            Runnable openChat,
            Runnable openSettings,
            Runnable exitGame) {

        View.applyBackground(this, backgroundName);
        View.bindToScreenState(this, screenState, ScreenState.MAIN_MENU_ACTIVE);

        Label title = new Label();

        title.textProperty().bind(titleText);

        title.setStyle(
                "-fx-font-size: 40px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: white;");



        Button startButton = createButton(
                "Start game",
                startGame
        );

        Button chatButton = createButton(
                "Chat",
                openChat
        );

        Button settingsButton = createButton(
                "Settings",
                openSettings
        );

        Button exitButton = createButton(
                "Exit",
                exitGame
        );



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

        menu.setStyle(
                "-fx-background-color: rgba(0,0,0,0.05);" +
                "-fx-padding: 40;"
        );


        setAlignment(Pos.CENTER);

        getChildren().add(menu);
    }


    private Button createButton(String text, Runnable action) {

        Button button = new Button(text);

        button.setPrefWidth(250);
        button.setPrefHeight(45);

        button.setOnAction(event -> action.run());

        return button;
    }
}