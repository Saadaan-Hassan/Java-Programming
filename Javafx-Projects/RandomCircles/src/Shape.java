import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class Shape extends Circle {
    private static int id = 0;

    public Shape(double v, Paint paint) {
        super(v, paint);
        id = id++;
    }

    public static int Id() {
        return id;
    }
}
