package bombastic.menu.mainmenu;

import javafx.application.Platform;

public class MainMenuController {

    private final MainMenuModel menuModel;

    private final MainMenuView view;

    public MainMenuController() {

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
        
    }

    private void openChat() {
    }

    private void openSettings() {
    }

    public MainMenuView getView() {
        return view.build();
    }
}