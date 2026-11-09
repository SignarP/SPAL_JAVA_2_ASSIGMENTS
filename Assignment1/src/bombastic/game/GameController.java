package bombastic.game;

import bombastic.ScreenState;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyStringProperty;

public class GameController {

    private final GameView view;


    public GameController(
            ReadOnlyStringProperty backgroundName,
            ReadOnlyObjectProperty<ScreenState> screenState,
            Runnable returnToMainMenu) {
        view = new GameView(
                backgroundName,
                screenState,
                returnToMainMenu
        );
    }


    public GameView getView() {
        return view;
    }
}