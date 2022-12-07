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

public class BMI {
    private static final GridPane grid = new GridPane();
    private static final Scene scene = new Scene(grid, 600, 450);
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
        grid.add(weightsPreference, 2,0);

        Label name = new Label("Name: ");
        grid.add(name, 0,1);

        TextField nameField = new TextField();
        grid.add(nameField, 1,1);

        Label genderLabel= new Label("Gender");
        grid.add(genderLabel, 0, 2);

        RadioButton male = new RadioButton("Male");
        RadioButton female = new RadioButton("Female");

        ToggleGroup genderToggle = new ToggleGroup();

        male.setToggleGroup(genderToggle);
        female.setToggleGroup(genderToggle);

        grid.add(male, 1,2);
        grid.add(female, 2,2);

        Label dob = new Label("DOB");
        grid.add(dob, 0,3);

        DatePicker datePicker = new DatePicker();
        grid.add(datePicker, 1,3);


        Label weight = new Label("Weight: ");
        grid.add(weight, 0,4);

        TextField weightInput = new TextField();
        weightInput.setPrefWidth(200);
        weightInput.setPrefHeight(FEILDHEIGHT);
        weightInput.setMinHeight(20);
        grid.add(weightInput, 1,4);

        Slider weightSlider = new Slider();
        weightSlider.setShowTickMarks(true);
        weightSlider.setShowTickLabels(true);
        weightSlider.setMajorTickUnit(50);
        weightSlider.setMin(0);
        weightSlider.setMax(1000);
        grid.add(weightSlider, 2,4);

        weightSlider.valueProperty().addListener((observableValue, number, t1) -> weightInput.setText(String.format("%.2f", t1.doubleValue())));


        Label height = new Label("Height: ");
        grid.add(height, 0, 5);

        Slider heightSlider = new Slider();
        heightSlider.setShowTickMarks(true);
        heightSlider.setShowTickLabels(true);
        heightSlider.setMajorTickUnit(50);
        heightSlider.setMin(0);
        heightSlider.setMax(1000);
        grid.add(heightSlider, 2,5);



        TextField heightInput = new TextField();
        heightInput.setPrefWidth(200);
        heightInput.setPrefHeight(FEILDHEIGHT);
        heightInput.setMinHeight(20);
        grid.add(heightInput, 1,5);

        heightSlider.valueProperty().addListener((observableValue, number, t1) -> heightInput.setText(String.format("%.2f", t1.doubleValue())));



        Label bmiLabel = new Label("BMI: ");
        grid.add(bmiLabel, 0, 6);

        Text resultBMI = new Text();
        grid.add(resultBMI, 1, 6);

        Button btn = new Button("Calculate");
        HBox hBox = new HBox(btn);
        hBox.setAlignment(Pos.CENTER);
        grid.add(hBox,0,7,2,1);

        Text result = new Text();
        grid.add(result, 0, 8, 2, 1);



        weightsPreference.setOnAction((EventHandler<ActionEvent>) actionEvent -> {
            if (weightsPreference.getValue() == "Metric Units"){
                weightInput.setPromptText("Weight in Kg");
                heightInput.setPromptText("Height in cm");
            }
            else {
                weightInput.setPromptText("Weight in pounds");
                heightInput.setPromptText("Height in inches");
            }
        });

        btn.setOnAction(actionEvent -> {
            if (weightsPreference.getValue() == "Metric Units"){
                resultBMI.setText(metricBmiCalc(heightInput.getText(), weightInput.getText()) + " Kg/m^2" );
                result.setText(bmiCategory(metricBmiCalc(heightInput.getText(), weightInput.getText())));
            }
            else if (weightsPreference.getValue() == "Standard") {
                resultBMI.setText(standardBmiCalc(heightInput.getText(), weightInput.getText()) + " Kg/m^2");
                result.setText(bmiCategory(standardBmiCalc(heightInput.getText(), weightInput.getText())));
            }
        });

        return scene;
    }

    private static String metricBmiCalc(String h, String w){
        double height = Double.parseDouble(h);
        double weight = Double.parseDouble(w);
//        return Double.toString();
        return String.format("%.2f", weight/Math.pow(height/100,2));
    }

    private static String standardBmiCalc(String h, String w){
        double height = Double.parseDouble(h);
        double weight = Double.parseDouble(w);
//        return Double.toString();
        return String.format("%.2f", weight/Math.pow(height,2)*703);
    }

    private static String bmiCategory(String input){
        double bmi = Double.parseDouble(input);

        if (bmi < 18.5)
            return "You are Underweight";
        else if (bmi <= 24.9)
            return "You have Normal Weight";
        else if (bmi <= 29.9)
            return "You are Overweight";
        else
            return "You have Obesity";
        }
}
