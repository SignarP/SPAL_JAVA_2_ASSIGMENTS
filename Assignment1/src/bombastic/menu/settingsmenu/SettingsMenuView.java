
package bombastic.menu.settingsmenu;

import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class SettingsMenuView extends StackPane {

    private final Runnable exit;
    private final Runnable bg1;
    private final Runnable bg2;
    private final Runnable bg3;
    private final Runnable arena1;
    private final Runnable arena2;
    private final Runnable arena3;

    public SettingsMenuView(Runnable exit, Runnable bg1, Runnable bg2,
                            Runnable bg3, Runnable arena1, Runnable arena2,
                            Runnable arena3) {

        this.exit = exit;
        this.bg1 = bg1;
        this.bg2 = bg2;
        this.bg3 = bg3;
        this.arena1 = arena1;
        this.arena2 = arena2;
        this.arena3 = arena3;
    }

    public SettingsMenuView build() {

        Label title = new Label("Settings");
        title.setStyle("-fx-font-size: 36px; -fx-font-weight: bold;");

        Label backgroundLabel = new Label("Choose Background");
        backgroundLabel.setStyle("-fx-font-size: 18px;");

        ComboBox<String> backgroundBox = new ComboBox<>();
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

        Label arenaLabel = new Label("Choose Arena");
        arenaLabel.setStyle("-fx-font-size: 18px;");

        ComboBox<String> arenaBox = new ComboBox<>();
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

        Button exitButton = new Button("Main Menu");
        exitButton.setPrefWidth(180);
        exitButton.setPrefHeight(40);
        exitButton.setOnAction(_ -> exit.run());

        VBox layout = new VBox(
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

        layout.setStyle(
                "-fx-background-color: rgba(0, 0, 0, 0.65);" +
                "-fx-background-radius: 15;"
        );

        setAlignment(Pos.CENTER);
        getChildren().setAll(layout);

        return this;
    }
}
