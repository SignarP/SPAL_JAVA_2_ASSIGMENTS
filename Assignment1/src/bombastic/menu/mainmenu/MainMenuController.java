package bombastic.menu.mainmenu;

import bombastic.ScreenState;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyStringProperty;

public class MainMenuController {

    private final MainMenuModel menuModel;

    private final MainMenuView view;


    public MainMenuController(
            ReadOnlyStringProperty backgroundName,
            ReadOnlyObjectProperty<ScreenState> screenState,
            Runnable startGame,
            Runnable openChat,
            Runnable openSettings,
            Runnable exitGame) {

        menuModel = new MainMenuModel();

        view = new MainMenuView(
                backgroundName,
                menuModel.titleProperty(),
                screenState,
                startGame,
                openChat,
                openSettings,
                exitGame
        );
    }


    public MainMenuView getView() {
        return view;
    }
}