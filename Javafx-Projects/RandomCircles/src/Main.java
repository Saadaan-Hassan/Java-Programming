import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

public class Main extends Application {
    public static void main(String[] args) {
        launch();
    }


    @Override
    public void start(Stage stage){
        BorderPane root = new BorderPane();
        Button next = new Button("Random");
        TextField field = new TextField();

        HBox hBox = new HBox(20);
        hBox.getChildren().addAll(field,next);
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(10));

        //Setting Bottom of Border Pane
        root.setBottom(hBox);

        ArrayList<Shape> circles = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i <= 1000; i++) {
            Shape temp = new Shape(rand.nextInt(100), Color.rgb(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
            circles.add(temp);
        }

        HBox hBox2 = new HBox(10);
        Text noc = new Text();
        String text = String.format("%d out of %d", rand.nextInt(circles.size()),(circles.size()-1));
        noc.setText(text);

        hBox2.setAlignment(Pos.CENTER);
        hBox2.getChildren().add(noc);

        root.setTop(hBox2);

        //Setting Center of the BorderPane
        root.setCenter(circles.get(rand.nextInt(circles.size())));


            next.setOnAction(e -> {
                int ran = rand.nextInt(circles.size());
                root.setCenter(circles.get(ran));
                noc.setText(String.format("%d out of %d", ran,(circles.size()-1)));
                field.setText(Integer.toString(ran));
            });
            field.setOnAction(e -> {
                root.setCenter(circles.get(Integer.parseInt(field.getText())));
                noc.setText(String.format("%s out of %d", field.getText(),(circles.size()-1)));
            });
            Scene scene = new Scene(root, 600, 400);

            stage.setScene(scene);
            stage.show();
        }


}