import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicBoolean;

public class ConfirmBox {
    public static boolean display(String title, String message) {
        AtomicBoolean answer = new AtomicBoolean(false);


        Stage window = new Stage();
        window.setTitle(title);
        window.setMinWidth(200);
        window.initModality(Modality.APPLICATION_MODAL);

        Label label = new Label(message);
        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");

        yesButton.setOnAction(e ->{
            answer.set(true);
            window.close();
        } );

        noButton.setOnAction(e -> {
            answer.set(false);
            window.close();
        });

        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(label, noButton, yesButton);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.showAndWait();

        return answer.get();
    }
}
