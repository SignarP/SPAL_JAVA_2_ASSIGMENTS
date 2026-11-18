
package bombastic.menu.chatmenu;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ChatMenuView extends StackPane {

    private final Label title;
    private final TextArea messages;
    private final ListView<String> users;
    private final Label playersOnline;
    private final Button sendButton;
    private final Button exitButton;
    private final TextField messageInput;
    private final HBox inputArea;
    private final VBox userArea;
    private final BorderPane layout;

    public ChatMenuView(
            ChatMenuModel model,
            Runnable sendMessage,
            Runnable exit) {
        title = new Label("Messages");
        title.setFont(Font.font("System", FontWeight.BOLD, 32));
        title.setTextFill(Color.RED);

        messages = new TextArea();
        messages.textProperty().bind(model.messagesProperty());
        messages.setEditable(false);
        messages.setWrapText(true);

        users = new ListView<>();
        users.setItems(model.usersProperty());

        playersOnline = new Label("Players online");
        playersOnline.setTextFill(Color.RED);
        playersOnline.setFont(Font.font("System", FontWeight.BOLD, 18));

        userArea = new VBox(5, playersOnline, users);
        userArea.setPrefWidth(160);

        sendButton = new Button("Send");
        sendButton.setOnAction(_ -> sendMessage.run());

        messageInput = new TextField();
        messageInput.setPromptText("Write a message...");
        messageInput.setOnAction(_ -> sendMessage.run());

        exitButton = new Button("Main Menu");
        exitButton.setOnAction(_ -> exit.run());

        inputArea = new HBox(10, messageInput, sendButton, exitButton);
        inputArea.setAlignment(Pos.CENTER);

        layout = new BorderPane();
        layout.setPadding(new Insets(20));
        layout.setTop(title);
        layout.setCenter(messages);
        layout.setRight(userArea);
        layout.setBottom(inputArea);

        BorderPane.setMargin(messages, new Insets(15, 15, 15, 0));
        BorderPane.setMargin(userArea, new Insets(15, 0, 15, 0));
        BorderPane.setMargin(inputArea, new Insets(10, 0, 0, 0));

        setPadding(new Insets(30));
        getChildren().add(layout);
    }

    public BorderPane getLayout() {
        return layout;
    }

    public String getMessageInput() {
        return messageInput.getText();
    }

    public void clearMessageInput() {
        messageInput.clear();
    }
}
