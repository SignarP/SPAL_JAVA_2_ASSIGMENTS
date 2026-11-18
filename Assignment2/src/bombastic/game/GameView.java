
package bombastic.game;

import bombastic.game.entities.Entity;
import java.util.List;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GameView extends StackPane {

    private final Runnable exit;
    private final Canvas canvas;

    public GameView(Runnable exit) {
        this.exit = exit;

        canvas = new Canvas(1000, 800);

        Button mainMenuButton = new Button("Main Menu");
        mainMenuButton.setFont(Font.font("System", FontWeight.BOLD, 20));

        StackPane.setAlignment(mainMenuButton, Pos.BOTTOM_CENTER);
        mainMenuButton.setOnAction(_ -> exit.run());

        getChildren().addAll(canvas, mainMenuButton);
    }

    public void render(List<Entity> entities) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.LIGHTBLUE);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        for (Entity entity : entities) {
            entity.render(gc);
        }
    }
}
