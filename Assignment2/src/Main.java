
import bombastic.Controller;
import bombastic.Model;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Controller controller = new Controller();
        Scene scene = new Scene(controller.getView(), 1000, 700);

        stage.setScene(scene);
        stage.setTitle("Bombastic Game");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}