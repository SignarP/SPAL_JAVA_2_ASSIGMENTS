package bombastic.menu.chatmenu;

import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;

public class ChatMenuModel {

    private final SimpleListProperty<String> users =
            new SimpleListProperty<>(FXCollections.observableArrayList(
                    "Signar",
                    "Niels",
                    "Christian"
            ));

    private final SimpleStringProperty messages =
            new SimpleStringProperty("");

    public SimpleListProperty<String> usersProperty() {
        return users;
    }

    public SimpleStringProperty messagesProperty() {
        return messages;
    }

    public void addMessage(String message) {
        messages.set(messages.get() + message + "\n");
    }
}