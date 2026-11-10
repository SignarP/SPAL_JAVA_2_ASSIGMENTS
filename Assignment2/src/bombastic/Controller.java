
package bombastic;

import bombastic.game.GameController;
import bombastic.menu.mainmenu.MainMenuController;
import bombastic.menu.settingsmenu.SettingsMenuController;
import bombastic.menu.chatmenu.ChatMenuController;

import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;

public class Controller {

    private final Model model;
    private final View view;

    public Controller() {
        this.model = new Model();

        MainMenuController mainMenuController = new MainMenuController(this::setState);

        Region mainMenu = mainMenuController.getView();

        GameController gameController = new GameController(this::setState);

        Region gameMenu = gameController.getView();

        SettingsMenuController settingsMenuController = new SettingsMenuController(model, this::setState);

        Region settingsMenu = settingsMenuController.getView();

        ChatMenuController chatMenuController = new ChatMenuController(this::setState);

        Region chatMenu = chatMenuController.getView();

        view = new View(mainMenu, gameMenu, settingsMenu, chatMenu).build();

        mainMenu.backgroundProperty().bind(model.backgroundProperty());
        settingsMenu.backgroundProperty().bind(model.backgroundProperty());
        chatMenu.backgroundProperty().bind(model.backgroundProperty());

        model.stateProperty().addListener((observable, oldState, newState) -> view.showState(newState));
        view.showState(model.stateProperty().get());
    }

    private void setState(State state) {
        model.setState(state);
    }

    public StackPane getView() {
        return view;
    }
}
