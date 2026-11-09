package bombastic.game;

import bombastic.State;
import java.util.function.Consumer;

public class GameController {

    private final GameView view;
    private final Consumer<State> changeState;

    public GameController(Consumer<State> changeState) {

        this.changeState = changeState;

        view = new GameView(this::openMainMenu);
    }

    private void openMainMenu() {
        changeState.accept(State.MAIN_MENU_ACTIVE);
    }

    public GameView getView() {
        return view;
    }
}