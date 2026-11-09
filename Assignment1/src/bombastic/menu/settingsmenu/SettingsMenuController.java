package bombastic.menu.settingsmenu;

import bombastic.State;
import java.util.function.Consumer;

public class SettingsMenuController {

    private final SettingsMenuModel model;
    private final SettingsMenuView view;

    private final Consumer<State> changeState;

    public SettingsMenuController(Consumer<State> changeState) {

        this.changeState = changeState;

        model = new SettingsMenuModel();

        view = new SettingsMenuView(this::openMainMenu);
    }

    private void openMainMenu() {
        changeState.accept(State.MAIN_MENU_ACTIVE);
    }

    public SettingsMenuView getView() {
        return view.build();
    }
}