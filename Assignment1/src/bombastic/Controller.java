package bombastic;

import bombastic.menu.mainmenu.MainMenuController;
import javafx.scene.layout.Region;

public class Controller {

    private final MainMenuController mainMenuController;

    public Controller() {
        mainMenuController = new MainMenuController();
    }

    public Region getView() {
        return mainMenuController.getView();
    }
}