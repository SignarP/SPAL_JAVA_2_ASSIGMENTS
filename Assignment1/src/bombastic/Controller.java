package bombastic;
import bombastic.game.GameController;
import bombastic.menu.mainmenu.MainMenuController;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import bombastic.menu.chatmenu.ChatMenuController;
import bombastic.menu.settingsmenu.SettingsMenuController;

public class Controller {

    private final StackPane root;

    private final Region mainMenu;
    private final Region gameMenu;
    private final Region settingsMenu;
    private final Region chatMenu;

    private State currentState;

    public Controller() {

        MainMenuController mainMenuController =
                new MainMenuController(this::setState);

        mainMenu = mainMenuController.getView();

        GameController gameController = new GameController(this::setState);
        gameMenu = gameController.getView();

        ChatMenuController chatMenuController = new ChatMenuController(this::setState);
        chatMenu = chatMenuController.getView();


        SettingsMenuController settingsMenuController = new SettingsMenuController(this::setState);
        settingsMenu = settingsMenuController.getView();
        
        


        root = new StackPane(
                mainMenu,
                gameMenu,
                settingsMenu,
                chatMenu
        );

        setState(State.MAIN_MENU_ACTIVE);
    }

    private void setState(State state) {

        currentState = state;

        mainMenu.setVisible(false);
        gameMenu.setVisible(false);
        settingsMenu.setVisible(false);
        chatMenu.setVisible(false);

   

        switch (currentState) {

            case MAIN_MENU_ACTIVE:
                mainMenu.setVisible(true);
                break;

            case GAME_MENU_ACTIVE:
                gameMenu.setVisible(true);
                break;

            case SETTINGS_MENU_ACTIVE:
                settingsMenu.setVisible(true);
                break;

            case CHAT_MENU_ACTIVE:
                chatMenu.setVisible(true);
                break;
        }
    }

    public StackPane getView() {
        return root;
    }
}