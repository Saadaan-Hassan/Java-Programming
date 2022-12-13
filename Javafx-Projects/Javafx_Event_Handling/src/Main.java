import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;



public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 400, 300);

        Circle circle = new Circle(20, Color.RED);

        root.setCenter(circle);

        Button left = new Button("Left");
        Button right = new Button("Right");

        HBox hBox = new HBox(20);
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(10));
        hBox.getChildren().addAll(left, right);

        root.setBottom(hBox);

        stage.setScene(scene);
        stage.setTitle("Javafx Event Handling");
        stage.show();

    }
}