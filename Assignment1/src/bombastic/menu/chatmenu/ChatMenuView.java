package bombastic.menu.chatmenu;

import bombastic.ScreenState;
import bombastic.View;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class ChatMenuView extends StackPane {

    public ChatMenuView(ReadOnlyStringProperty backgroundName,
                        ReadOnlyObjectProperty<ScreenState> screenState,
                        ObservableList<String> users,
                        ReadOnlyStringProperty messages,
                        Runnable backToMenu,
                        java.util.function.Consumer<String> sendMessage) {

        View.applyBackground(this, backgroundName);
        View.bindToScreenState(this, screenState, ScreenState.CHAT_MENU_ACTIVE);

        Label title = new Label("Bombastic Chat");
        title.setStyle("-fx-font-size: 28px; -fx-text-fill: white;");

        Label usersTitle = new Label("Online Players");
        usersTitle.setStyle("-fx-font-size: 28px; -fx-text-fill: white;");

        ListView<String> usersList = new ListView<>();
        usersList.setItems(users);
        usersList.setPrefWidth(200);

        VBox usersBox = new VBox(10, usersTitle, usersList);
        usersBox.setPrefWidth(200);

        TextArea messagesArea = new TextArea();
        messagesArea.setEditable(false);
        messagesArea.setWrapText(true);

        messagesArea.textProperty().bind(messages);

        TextField messageInput = new TextField();
        messageInput.setPromptText("Write a message...");

        Button sendButton = new Button("Send");

        Runnable send = () -> {
            String message = messageInput.getText().trim();

            if (!message.isEmpty()) {
                sendMessage.accept(message);
                messageInput.clear();
            }
        };

        sendButton.setOnAction(e -> send.run());
        messageInput.setOnAction(e -> send.run());

        HBox inputBox = new HBox(10, messageInput, sendButton);

        VBox chatBox = new VBox(10, title, messagesArea, inputBox);
        VBox.setVgrow(messagesArea, Priority.ALWAYS);

        Button backButton = new Button("Main Menu");
        backButton.setOnAction(e -> backToMenu.run());

        HBox content = new HBox(10, usersBox, chatBox);
        HBox.setHgrow(chatBox, Priority.ALWAYS);
        VBox.setVgrow(content, Priority.ALWAYS);

        VBox layout = new VBox(10, content, backButton);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);

        getChildren().add(layout);
    }
}