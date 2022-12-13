import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;

public class Driver extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {

        GridPane grid = new GridPane();
        Scene scene = new Scene(grid,500,350);

        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(15));

        Label filePath = new Label("File path: ");
        grid.add(filePath, 0, 0);

        TextArea fp = new TextArea();
        fp.setPrefHeight(10);
        fp.setPrefWidth(400);
        grid.add(fp, 1, 0);

        Button btn = new Button("Submit");
        grid.add(btn, 3, 0);

        Label dff = new Label("Data from file:");
        grid.add(dff, 0, 1);

        Text dataFromFile = new Text();

        dataFromFile.setWrappingWidth(500);
        grid.add(dataFromFile, 0,2, 2 ,1);

        Label oddNumber = new Label("Odd Numbers: ");
        grid.add(oddNumber, 0,3);

        Text noOfOdd = new Text();
        grid.add(noOfOdd,1,3);

        Label evenNumber = new Label("Even Numbers: ");
        grid.add(evenNumber, 0,4);

        Text noOfEven = new Text();
        grid.add(noOfEven,1,4);


        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                File file = new File(fp.getText());

                String data = Reader.readFromFile(file);
                System.out.println(data);

                String [] dataSplit = data.split(" ");

                String [] counts = Reader.countNumbers(dataSplit);

                dataFromFile.setText(data);
                noOfOdd.setText(counts[0]);
                noOfEven.setText(counts[1]);
            }
        });

        stage.setScene(scene);
        stage.setTitle("No. of Odd and Even Numbers");
//        stage.setResizable(false);
        stage.show();
    }
}