import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.math.RoundingMode;

public class BMI {
    private static GridPane grid = new GridPane();
    private static Scene scene = new Scene(grid, 600, 450);
    private final static int FEILDHEIGHT = 25;


    public static Scene getScene(){

        grid.setAlignment(Pos.CENTER);
        grid.setHgap(15);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));

        Text title = new Text("BMI Calculator");
        title.setFont(Font.font(18));
        grid.add(title,0,0,2,1);

        String [] weights = {"Metric Units", "Standard"};
        ComboBox weightsPreference = new ComboBox(FXCollections.observableArrayList(weights));
        weightsPreference.setPromptText("Select Criteria");
        grid.add(weightsPreference, 2,1);

        Label weight = new Label("Weight: ");
        grid.add(weight, 0,1);

        TextField weightInput = new TextField();
        weightInput.setPrefWidth(200);
        weightInput.setPrefHeight(FEILDHEIGHT);
        weightInput.setMinHeight(20);
        grid.add(weightInput, 1,1);

        Label height = new Label("Height: ");
        grid.add(height, 0, 2);

        TextField heightInput = new TextField();
        heightInput.setPrefWidth(200);
        heightInput.setPrefHeight(FEILDHEIGHT);
        heightInput.setMinHeight(20);
        grid.add(heightInput, 1,2);


        Label bmiLabel = new Label("BMI: ");
        grid.add(bmiLabel, 0, 3);

        Text resultBMI = new Text();
        grid.add(resultBMI, 1, 3);

        Button btn = new Button("Calculate");
        HBox hBox = new HBox(btn);
        hBox.setAlignment(Pos.CENTER);
        grid.add(hBox,0,4,2,1);

        weightsPreference.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (weightsPreference.getValue() == "Metric Units"){
                    weightInput.setPromptText("Weight in Kg");
                    heightInput.setPromptText("Height in cm");
                }
                else {
                    weightInput.setPromptText("Weight in pounds");
                    heightInput.setPromptText("Height in inches");
                }
            }
        });

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (weightsPreference.getValue() == "Metric Units")
                    resultBMI.setText(metricBmiCalc(heightInput.getText(), weightInput.getText()) + " Kg/m^2" );
                else if (weightsPreference.getValue() == "Standard")
                    resultBMI.setText(standardBmiCalc(heightInput.getText(), weightInput.getText()) + " Kg/m^2");
            }
        });

        return scene;
    }

    private static String metricBmiCalc(String h, String w){
        double height = Double.parseDouble(h);
        double weight = Double.parseDouble(w);
        return Double.toString(weight/Math.pow(height/100,2));
    }

    private static String standardBmiCalc(String h, String w){
        double height = Double.parseDouble(h);
        double weight = Double.parseDouble(w);
        return Double.toString(weight/Math.pow(height,2)*703);
    }
}
