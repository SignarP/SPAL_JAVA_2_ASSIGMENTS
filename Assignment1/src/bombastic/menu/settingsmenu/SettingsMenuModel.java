package bombastic.menu.settingsmenu;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SettingsMenuModel {

    private final ObservableList<String> backgrounds =
            FXCollections.observableArrayList(
                    "Background 1",
                    "Background 2",
                    "Background 3"
            );

    private final ObservableList<String> arenas =
            FXCollections.observableArrayList(
                    "Classic Arena",
                    "Magic Arena",
                    "Legend Arena"
            );

    public ObservableList<String> getBackgrounds() {
        return backgrounds;
    }

    public ObservableList<String> getArenas() {
        return arenas;
    }
}