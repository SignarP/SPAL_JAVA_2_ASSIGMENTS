package bombastic.menu.chatmenu;

import bombastic.ScreenState;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyStringProperty;

public class ChatMenuController {

    private final ChatMenuModel chatModel;

    private final ChatMenuView view;


    public ChatMenuController(
            ReadOnlyStringProperty backgroundName,
            ReadOnlyObjectProperty<ScreenState> screenState,
            Runnable returnToMainMenu) {

        chatModel = new ChatMenuModel();

        view = new ChatMenuView(
                backgroundName,
                screenState,
                chatModel.getUsers(),
                chatModel.welcomeMessagesProperty(),
                returnToMainMenu,
                chatModel::addMessage
        );
    }


    public ChatMenuView getView() {
        return view;
    }
}