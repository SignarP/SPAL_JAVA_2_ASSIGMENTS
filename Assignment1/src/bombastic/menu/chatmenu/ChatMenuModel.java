package bombastic.menu.chatmenu;

import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ChatMenuModel {

    private final ObservableList<String> users =
            FXCollections.observableArrayList(
                    "Niels",
                    "Bent",
                    "Karen",
                    "Sammy"
            );


    private final ReadOnlyStringWrapper welcomeMessage =
            new ReadOnlyStringWrapper(
                    "Welcome to Bombastic Chat!\n"
            );


    public ObservableList<String> getUsers() {
        return users;
    }


    public ReadOnlyStringProperty welcomeMessagesProperty() {
        return welcomeMessage.getReadOnlyProperty();
    }


    public void addMessage(String message) {

        if (message == null || message.isBlank()) {
            return;
        }

        welcomeMessage.set(
                welcomeMessage.get() + message.trim() + "\n"
        );
    }
}