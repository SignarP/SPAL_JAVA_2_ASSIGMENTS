package bombastic.menu.settingsmenu;

import bombastic.Model;
import bombastic.State;

import java.util.function.Consumer;

public class SettingsMenuController {

    private final SettingsMenuModel model;
    private final SettingsMenuView view;
    private final Consumer<State> changeState;

    public SettingsMenuController(Model mainModel, Consumer<State> changeState) {

        this.changeState = changeState;

        model = new SettingsMenuModel(mainModel);

        view = new SettingsMenuView(
                this::openMainMenu,
                () -> model.changeBackground("bg1.png"),
                () -> model.changeBackground("bg2.png"),
                () -> model.changeBackground("bg3.png"),
                () -> model.changeArena("Arena 1"),
                () -> model.changeArena("Arena 2"),
                () -> model.changeArena("Arena 3")
        );
    }

    private void openMainMenu() {
        changeState.accept(State.MAIN_MENU_ACTIVE);
    }

    public SettingsMenuView getView() {
        return view.build();
    }
}