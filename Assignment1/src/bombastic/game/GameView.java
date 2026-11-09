package bombastic.game;

import bombastic.ScreenState;
import bombastic.View;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.geometry.Pos;

import javafx.scene.control.Button;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class GameView extends StackPane {

    public GameView(
            ReadOnlyStringProperty backgroundName,
            ReadOnlyObjectProperty<ScreenState> screenState,
            Runnable returnToMainMenu) {

        View.applyBackground(this, backgroundName);
        View.bindToScreenState(this, screenState, ScreenState.GAME_ACTIVE);



        Button backButton = new Button("Main Menu");

        backButton.setOnAction(
                event -> returnToMainMenu.run()
        );


        VBox layout = new VBox(
                25,
                backButton
        );

        layout.setAlignment(Pos.CENTER);

        layout.setStyle(
                "-fx-background-color: rgba(0,0,0,0.75);" +
                "-fx-padding: 40;" );


        getChildren().add(layout);

        setAlignment(Pos.CENTER);
    }
}