package bombastic;

import bombastic.menu.mainmenu.MainMenuController;
import bombastic.menu.settingsmenu.SettingsMenuController;
import bombastic.menu.chatmenu.ChatMenuController;
import bombastic.game.GameController;

import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.layout.StackPane;

public class Controller {

    private final View view;
    private final ObjectProperty<ScreenState> screenState =
            new SimpleObjectProperty<>(ScreenState.MAIN_MENU_ACTIVE);

    private final MainMenuController mainMenuController;
    private final SettingsMenuController settingsMenuController;
    private final ChatMenuController chatController;
    private final GameController gameController;

    public Controller(Model model, View view) {
        this.view = view;

        mainMenuController = new MainMenuController(
                model.backgroundNameProperty(),
                screenState,
                this::showGame,
                this::showChat,
                this::showSettings,
                Platform::exit
        );

        settingsMenuController = new SettingsMenuController(
                model.backgroundNameProperty(),
                model.arenaProperty(),
                screenState,
                model::setBackground,
                model::setArena,
                this::showMainMenu
        );

        chatController = new ChatMenuController(
                model.backgroundNameProperty(),
                screenState,
                this::showMainMenu
        );

        gameController = new GameController(
                model.backgroundNameProperty(),
                screenState,
                this::showMainMenu
        );

        StackPane screens = new StackPane(
                mainMenuController.getView(),
                settingsMenuController.getView(),
                chatController.getView(),
                gameController.getView()
        );
        view.show(screens);
    }


    public void showMainMenu() {
        screenState.set(ScreenState.MAIN_MENU_ACTIVE);
    }


    public void showSettings() {
        screenState.set(ScreenState.SETTINGS_MENU_ACTIVE);
    }


    public void showChat() {
        screenState.set(ScreenState.CHAT_MENU_ACTIVE);
    }


    public void showGame() {
        screenState.set(ScreenState.GAME_ACTIVE);
    }
}