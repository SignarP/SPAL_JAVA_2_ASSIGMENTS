
package bombastic.menu.settingsmenu;

import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class SettingsMenuView extends StackPane {

    private final Label title;
    private final Label backgroundLabel;
    private final Label arenaLabel;
    private final ComboBox<String> backgroundBox;
    private final ComboBox<String> arenaBox;
    private final Button exitButton;
    private final VBox layout;

    public SettingsMenuView(Runnable exit, Runnable bg1, Runnable bg2,
                            Runnable bg3, Runnable arena1, Runnable arena2,
                            Runnable arena3) {
        title = new Label("Settings");
        title.setFont(Font.font("System", FontWeight.BOLD, 36));

        backgroundLabel = new Label("Choose Background");
        backgroundLabel.setFont(Font.font("System", FontWeight.BOLD, 24));
        backgroundLabel.setTextFill(Color.RED);

        arenaLabel = new Label("Choose Arena");
        arenaLabel.setFont(Font.font("System", FontWeight.BOLD, 24));
        arenaLabel.setTextFill(Color.RED);

        backgroundBox = new ComboBox<>();
        backgroundBox.getItems().addAll(
                "Background 1",
                "Background 2",
                "Background 3"
        );
        backgroundBox.setValue("Background 1");
        backgroundBox.setPrefWidth(250);
        backgroundBox.setOnAction(_ -> {
            switch (backgroundBox.getValue()) {
                case "Background 1" -> bg1.run();
                case "Background 2" -> bg2.run();
                case "Background 3" -> bg3.run();
            }
        });

        arenaBox = new ComboBox<>();
        arenaBox.getItems().addAll("Arena 1", "Arena 2", "Arena 3");
        arenaBox.setValue("Arena 1");
        arenaBox.setPrefWidth(250);
        arenaBox.setOnAction(_ -> {
            switch (arenaBox.getValue()) {
                case "Arena 1" -> arena1.run();
                case "Arena 2" -> arena2.run();
                case "Arena 3" -> arena3.run();
            }
        });

        exitButton = new Button("Main Menu");
        exitButton.setPrefWidth(180);
        exitButton.setPrefHeight(40);
        exitButton.setOnAction(_ -> exit.run());

        layout = new VBox(
                20,
                title,
                backgroundLabel,
                backgroundBox,
                arenaLabel,
                arenaBox,
                exitButton
        );
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(40));
        layout.setMaxWidth(450);
        layout.setMinHeight(400);

        setAlignment(Pos.CENTER);
        getChildren().add(layout);
    }

    public VBox getLayout() {
        return layout;
    }
}
