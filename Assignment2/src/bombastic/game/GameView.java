
package bombastic.game;

import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class GameView extends StackPane {

    private final Runnable exit;
    private final Canvas canvas;

    public GameView(Runnable exit) {
        this.exit = exit;

        canvas = new Canvas(800, 600);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFill(javafx.scene.paint.Color.DARKSLATEGRAY);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        
        
        Button mainMenuButton = new Button("Main Menu");
        StackPane.setAlignment(mainMenuButton, Pos.TOP_LEFT);
        mainMenuButton.setOnAction(_ -> exit.run());
        
        getChildren().addAll(canvas, mainMenuButton);
    }

    public Canvas getCanvas() {
        return canvas;
    }
}
