
package bombastic.game;

import bombastic.State;
import java.util.function.Consumer;

public class GameController {

    private final GameModel model;
    private final GameView view;
    private final Consumer<State> changeState;
    private final GameLoop gameLoop;

    public GameController(Consumer<State> changeState) {
        this.changeState = changeState;
        model = new GameModel();
        view = new GameView(this::openMainMenu);
        gameLoop = new GameLoop(model, view);

        view.visibleProperty().addListener((observable, oldValue, visible) -> {
            if (visible) {
                gameLoop.start();
            } else {
                gameLoop.stop();
            }
        });
    }

    private void openMainMenu() {
        changeState.accept(State.MAIN_MENU_ACTIVE);
    }

    public GameView getView() {
        return view;
    }
}
