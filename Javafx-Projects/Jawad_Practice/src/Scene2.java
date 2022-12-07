import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class Scene2 {

    public static Scene display(){
        GridPane grid = new GridPane();

        Text text = new Text("I am Scene 2");
        grid.add(text, 0, 0);

        Button btn = new Button("Back");
        grid.add(btn, 0,1);

        btn.setOnAction(f -> Main.window.setScene(Main.scene));

        Scene scene = new Scene(grid, 600, 300);

        return scene;

    }
}
