
package bombastic;

import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;

public class Model {

    private final ReadOnlyStringWrapper backgroundName =
            new ReadOnlyStringWrapper("Background 1");

    private final ReadOnlyStringWrapper arena =
            new ReadOnlyStringWrapper("Classic Arena");

    public ReadOnlyStringProperty backgroundNameProperty() {
        return backgroundName.getReadOnlyProperty();
    }

    public ReadOnlyStringProperty arenaProperty() {
        return arena.getReadOnlyProperty();
    }

    public void setBackground(String selection) {
        backgroundName.set(selection);
    }

    public void setArena(String arenaName) {
        arena.set(arenaName);
    }
}
