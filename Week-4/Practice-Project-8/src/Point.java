public class Point {
    private int x;
    private int y;

    // Constructor
    public Point(int x, int y) {
        setX(x);
        setY(y);
    }

    // Setters
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    // Getters
    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    // To String
    @Override
    public String toString() {
        return String.format("%d , %d", x, y);
    }

}
