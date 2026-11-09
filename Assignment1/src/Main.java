import bombastic.Controller;
import bombastic.Model;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Controller controller = new Controller();
        Model model = new Model();
        Region root = controller.getView();
        root.setBackground(model.getBackground());
        Scene scene = new Scene(root, 600, 600);
        stage.setScene(scene);
        stage.setTitle("Bombastic Game");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}