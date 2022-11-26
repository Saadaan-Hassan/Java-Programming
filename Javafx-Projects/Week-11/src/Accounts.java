import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.Button;


public class Accounts extends GridPane {

    public static Scene createAccount(String name) {
        GridPane grid = new GridPane();

        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));

        Text greetingText = new Text("Welcome " + name + "!");
        greetingText.setFont(Font.font(20));
        grid.add(greetingText, 0,0);

        Button backBtn = new Button("Back");
        grid.add(backBtn, 0, 5);
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Main.getStage().setScene(Main.getScene());
            }
        });

        return new Scene(grid, 600, 400);
    }

}
