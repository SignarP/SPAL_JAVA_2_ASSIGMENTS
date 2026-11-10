
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

    private final Runnable sendMessage;
    private final Runnable exit;
    private final ChatMenuModel model;
    private final TextField messageInput = new TextField();

    public ChatMenuView(
            ChatMenuModel model,
            Runnable sendMessage,
            Runnable exit) {

        this.model = model;
        this.sendMessage = sendMessage;
        this.exit = exit;
    }

    public ChatMenuView build() {

        Label title = new Label("Messages");
        title.setFont(Font.font("System", FontWeight.BOLD, 32));
        title.setTextFill(Color.RED);

        TextArea messages = new TextArea();
        messages.textProperty().bind(model.messagesProperty());
        messages.setEditable(false);
        messages.setWrapText(true);

        ListView<String> users = new ListView<>();
        users.setItems(model.usersProperty());

        Label playersOnline = new Label("Players online");
        playersOnline.setTextFill(Color.RED);
        playersOnline.setFont(Font.font("System", FontWeight.BOLD, 18));

        VBox userArea = new VBox(5, playersOnline, users);
        userArea.setPrefWidth(160);

        Button sendButton = new Button("Send");
        sendButton.setOnAction(_ -> sendMessage.run());

        messageInput.setPromptText("Write a message...");
        messageInput.setOnAction(_ -> sendMessage.run());

        Button exitButton = new Button("Main Menu");
        exitButton.setOnAction(_ -> exit.run());

        HBox inputArea = new HBox(10, messageInput, sendButton, exitButton);
        inputArea.setAlignment(Pos.CENTER);

        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(20));

        layout.setTop(title);
        layout.setCenter(messages);
        layout.setRight(userArea);
        layout.setBottom(inputArea);

        BorderPane.setMargin(messages, new Insets(15, 15, 15, 0));
        BorderPane.setMargin(userArea, new Insets(15, 0, 15, 0));
        BorderPane.setMargin(inputArea, new Insets(10, 0, 0, 0));

        setPadding(new Insets(30));
        getChildren().setAll(layout);

        return this;
    }

    public String getMessageInput() {
        return messageInput.getText();
    }

    public void clearMessageInput() {
        messageInput.clear();
    }
}
