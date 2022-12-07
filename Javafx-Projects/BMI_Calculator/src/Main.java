import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage){

        stage.setTitle("BMI Calculator");
        stage.setScene(BMI.getScene());
        stage.setResizable(false);
        stage.show();
    }
}