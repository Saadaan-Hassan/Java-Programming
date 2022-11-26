import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        GridPane grid = new GridPane();
        Scene scene = new Scene(grid, 400,250);

        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25));

        Text title = new Text("Celsius To Fahrenheit Convertor");
        title.setFont(Font.font(20));
        grid.add(title,0,0,2,1);


        Label celsius = new Label("Celsius");
        grid.add(celsius,0,1);

        Label fahrenheit = new Label("Fahrenheit");
        grid.add(fahrenheit,1,1);

        TextField celsiusInput = new TextField();
        grid.add(celsiusInput,0,2);

        Text fahrenheitOutput = new Text();
        grid.add(fahrenheitOutput,1,2);

        Button btn = new Button("Convert");
        HBox btnContainer = new HBox(btn);
        btnContainer.setAlignment(Pos.CENTER);
        grid.add(btnContainer, 0,3, 6,1);

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                double temp = Double.parseDouble(celsiusInput.getText());
                double result = (temp * 1.8) + 32;

                String output = Double.toString(result);
                fahrenheitOutput.setText(output);

            }
        });

        Button exit = new Button("Exit");
        grid.add(exit, 3,7);

        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.hide();            }
        });


        stage.setTitle("Celsius To Fahrenheit");
        stage.setScene(scene);
        stage.show();
    }
}