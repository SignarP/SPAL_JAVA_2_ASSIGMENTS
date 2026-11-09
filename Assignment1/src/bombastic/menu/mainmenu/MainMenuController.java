package bombastic.menu.mainmenu;

import bombastic.State;
import javafx.application.Platform;
import java.util.function.Consumer;

public class MainMenuController {

    private final MainMenuModel menuModel;
    private final MainMenuView view;

    private final Consumer<State> changeState;

    public MainMenuController(Consumer<State> changeState) {

        this.changeState = changeState;

        menuModel = new MainMenuModel();

        view = new MainMenuView(
                menuModel.titleProperty(),
                this::startGame,
                this::openChat,
                this::openSettings,
                Platform::exit
        );
    }

    private void startGame() {
        changeState.accept(State.GAME_MENU_ACTIVE);
    }

    private void openChat() {
        changeState.accept(State.CHAT_MENU_ACTIVE);
    }

    private void openSettings() {
        changeState.accept(State.SETTINGS_MENU_ACTIVE);
    }

    public MainMenuView getView() {
        return view.build();
    }
}