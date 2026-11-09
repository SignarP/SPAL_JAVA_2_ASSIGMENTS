package bombastic.menu.settingsmenu;

import bombastic.ScreenState;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyStringProperty;

public class SettingsMenuController {

    private final SettingsMenuModel settingsModel;
    private final SettingsMenuView view;


    public SettingsMenuController(
            ReadOnlyStringProperty backgroundName,
            ReadOnlyStringProperty arenaName,
            ReadOnlyObjectProperty<ScreenState> screenState,
            java.util.function.Consumer<String> changeBackground,
            java.util.function.Consumer<String> changeArena,
            Runnable returnToMainMenu) {

        settingsModel = new SettingsMenuModel();

        view = new SettingsMenuView(
                backgroundName,
                arenaName,
                screenState,
                settingsModel.getBackgrounds(),
                settingsModel.getArenas(),
                returnToMainMenu,
                changeBackground,
                changeArena
        );
    }

    public SettingsMenuView getView() {
        return view;
    }
}