package bombastic.menu.mainmenu;

import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;

public class MainMenuModel {

    private final SimpleStringProperty title = new SimpleStringProperty("Bombastic");


    public SimpleStringProperty titleProperty() {
        return title;
    }
}