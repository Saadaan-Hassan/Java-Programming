import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.application.Application;

public class Main extends Application {

    private static Stage stage;
    private static GridPane grid = new GridPane();
    private static Scene scene = new Scene(grid, 400, 300);

    public static Stage getStage() {
        return stage;
    }

    public static GridPane getGrid() {
        return grid;
    }

    public static Scene getScene() {
        return scene;
    }

    @Override
    public void start(Stage stage) throws Exception {
        Main.stage = stage;


            //Using GridPane for Layout

            grid.setAlignment(Pos.CENTER);
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setPadding(new Insets(25, 25, 25, 25));


            Text sceneTitle = new Text("Welcome");
            sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
            grid.add(sceneTitle, 0, 0, 2, 1);

            //Adding User Name Label and Field
            Label userName = new Label("User Name: ");
            grid.add(userName, 0, 1);

            TextField userTextField = new TextField();
            grid.add(userTextField, 1, 1);

            //Adding Password Label and Field
            Label pw = new Label("Password:");
            grid.add(pw, 0, 2);

            PasswordField pwBox = new PasswordField();
            grid.add(pwBox, 1, 2);

            //Adding Button
            Button btn = new Button("Sign in");
            HBox hbBtn = new HBox(10);
            hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
            hbBtn.getChildren().add(btn);
            grid.add(hbBtn, 1, 4);

            Text actionText = new Text();
            grid.add(actionText, 0, 5, 2, 1);

            btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    if (userTextField.getText().equals(CommonData.userName) && pwBox.getText().equals(CommonData.password))
                            stage.setScene(Accounts.createAccount(userTextField.getText()));
                    else {
                        actionText.setFill(Color.FIREBRICK);
                        actionText.setText("Invalid Username of Password");
                    }
                }
            });



//        grid.setGridLinesVisible(true); //To see grid lines


        //Setting resizeable property to false
        stage.setResizable(false);

        //Setting Title to Log in Form
        stage.setTitle("Log-In Form");
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}