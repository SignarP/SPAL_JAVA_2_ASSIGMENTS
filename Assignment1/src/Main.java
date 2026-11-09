import bombastic.Model;
import bombastic.View;
import bombastic.Controller;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        Model model = new Model();
        View view = new View(stage);
        Controller controller = new Controller(model, view);

        controller.showMainMenu();
    }

    public static void main() {
        launch();
    }
}