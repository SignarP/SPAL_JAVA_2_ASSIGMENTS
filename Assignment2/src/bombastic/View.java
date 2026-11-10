package bombastic;

import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;

public class View extends StackPane {

    private final Region mainMenu;
    private final Region gameMenu;
    private final Region settingsMenu;
    private final Region chatMenu;

    public View(
            Region mainMenu,
            Region gameMenu,
            Region settingsMenu,
            Region chatMenu) {
        this.mainMenu = mainMenu;
        this.gameMenu = gameMenu;
        this.settingsMenu = settingsMenu;
        this.chatMenu = chatMenu;
    }

    public View build() {
        getChildren().setAll(
                mainMenu,
                gameMenu,
                settingsMenu,
                chatMenu
        );
        return this;
    }

    public void showState(State state) {
        mainMenu.setVisible(state == State.MAIN_MENU_ACTIVE);
        gameMenu.setVisible(state == State.GAME_MENU_ACTIVE);
        settingsMenu.setVisible(state == State.SETTINGS_MENU_ACTIVE);
        chatMenu.setVisible(state == State.CHAT_MENU_ACTIVE);
    }
}