package bombastic.menu.mainmenu;

import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;

public class MainMenuModel {

    private final ReadOnlyStringWrapper title =
            new ReadOnlyStringWrapper("BOMBASTIC");


    public ReadOnlyStringProperty titleProperty() {
        return title.getReadOnlyProperty();
    }
}