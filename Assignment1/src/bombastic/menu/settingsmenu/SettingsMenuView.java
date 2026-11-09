
package bombastic.menu.settingsmenu;

import bombastic.ScreenState;
import bombastic.View;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class SettingsMenuView extends StackPane {

    public SettingsMenuView(
            ReadOnlyStringProperty backgroundName,
            ReadOnlyStringProperty arenaName,
            ReadOnlyObjectProperty<ScreenState> screenState,
            ObservableList<String> backgrounds,
            ObservableList<String> arenas,
            Runnable returnToMainMenu,
            java.util.function.Consumer<String> changeBackground,
            java.util.function.Consumer<String> changeArena) {

        Label title = new Label("Settings");

        title.setStyle(
                "-fx-font-size: 40px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: white;"
        );

        MenuButton backgroundMenu = new MenuButton("Choose Background");

        for (String background : backgrounds) {
            MenuItem item = new MenuItem(background);

            item.setOnAction(event ->
                    changeBackground.accept(background)
            );
            backgroundMenu.getItems().add(item);
        }

        MenuButton arenaMenu = new MenuButton("Choose Arena");

        for (String arena : arenas) {
            MenuItem item = new MenuItem(arena);

            item.setOnAction(event ->
                    changeArena.accept(arena)
            );

            arenaMenu.getItems().add(item);
        }

        Label currentBackground = new Label();
        currentBackground.textProperty().bind(
                backgroundName
        );

        Label currentArena = new Label();
        currentArena.textProperty().bind(
                arenaName
        );

        currentBackground.setStyle("-fx-text-fill: white;");
        currentArena.setStyle("-fx-text-fill: white;");

        Button backButton = new Button("Main Menu");
        backButton.setOnAction(event -> returnToMainMenu.run());

        VBox layout = new VBox(
                50,
                title,
                backgroundMenu,
                currentBackground,
                arenaMenu,
                currentArena,
                backButton
        );

        layout.setAlignment(Pos.CENTER);
        layout.setMaxWidth(350);

        layout.setStyle(
                "-fx-background-color: rgba(0,0,0,0.00);" +
                "-fx-padding: 40;" +
                "-fx-background-radius: 15;"
        );

        getChildren().add(layout);
        setAlignment(Pos.CENTER);

        View.applyBackground(this, backgroundName);
        View.bindToScreenState(this, screenState, ScreenState.SETTINGS_MENU_ACTIVE);
    }
}
