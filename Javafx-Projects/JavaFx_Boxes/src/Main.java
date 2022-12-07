import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {
    Stage window;
    Button button1, button2;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage){
        window = stage;

        Label label = new Label("I am Main Window");
        button1 = new Button("Alert Box");
        button1.setOnAction(e -> AlertBox.display("Alert Box", "I am an Alert Box"));

        button2 = new Button("Confirm Box");
        button2.setOnAction(e -> ConfirmBox.display("Confirm Box", "I am Confirm Box"));

        VBox vBox = new VBox(20);
        vBox.getChildren().addAll(label, button1, button2);

        window.setOnCloseRequest(e ->{
            e.consume();
            closeProgram();
        });

        Scene scene = new Scene(vBox, 300, 250);

        window.setTitle("JavaFx Boxes");
        window.setScene(scene);
        window.show();
    }

    private void closeProgram(){
        if (ConfirmBox.display("Exit", "Are you sure you want to exit?"))
            window.close();
    }
}