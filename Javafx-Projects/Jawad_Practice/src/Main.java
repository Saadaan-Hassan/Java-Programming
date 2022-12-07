import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    static Scene scene;
    static Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;

        VBox vBox = new VBox(10);

        Text heading = new Text("I am Main!!!");

        Button btn = new Button("Click ME");

        btn.setOnAction(actionEvent -> stage.setScene(Scene2.display()));

        vBox.getChildren().addAll(heading, btn);

        //Scene
        scene = new Scene(vBox, 400, 375);

        Image icon = new Image("Demo.jpg");
        stage.getIcons().add(icon);
        //Stage
        stage.setScene(scene);
        stage.setTitle("Saadaan Bro");
        stage.show();
    }
}