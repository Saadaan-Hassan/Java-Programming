public class Rectangle {

    private double length;
    private double width;

    private int x, y;

    
    //Setters
    public void setLength(double length) {
        this.length = length;
    }
    
    public void setWidth(double width) {
        this.width = width;
    }
    
    public void setX(int val) {
        this.x = val;
    }

    public void setY(int val) {
        this.y = val;
    }

    //Getters
    public double getLength() {
        return length;
    }
    
    public double getWidth() {
        return width;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double calArea() {
        return (length * width);
    }
    
    public double calPerimeter() {
        return ((length*2)+(width*2));
    }
    
    public boolean isIntersect(Rectangle anotherRectangle) {
        int newPointX1 = (int)(this.x + this.width);
        int newPointY1 = (int)(this.y + this.length);

        boolean intersect = false;

        //Condition-1: When axes are same

        if(this.x == anotherRectangle.x && this.y == anotherRectangle.y){
            intersect = true;
        }

        //Conditon-2: When rectangles are intersecting 

        else if((anotherRectangle.x >= this.x && anotherRectangle.x<= newPointX1) && (anotherRectangle.y >= this.y && anotherRectangle.y<= newPointY1)){
            intersect = true;
        }
        else if((anotherRectangle.x <= this.x && anotherRectangle.x<= newPointX1) && (anotherRectangle.y <= this.y && anotherRectangle.y<= newPointY1)){
            intersect = true;
        }

        //Condition-3: When rectangles are not intersecting

        else if((this.x == anotherRectangle.x && newPointY1 != anotherRectangle.y) || (this.y == anotherRectangle.y && newPointX1 != anotherRectangle.x)){
            intersect = false;
        }
        return intersect;
    }

    public double intersectArea(Rectangle anotheRectangle){
        double anotheRectangleNewX = anotheRectangle.x + anotheRectangle.width;
        double anotheRectangleNewY = anotheRectangle.y + anotheRectangle.length;

        double intersetLength = (this.length - anotheRectangle.y) - (this.length > anotheRectangleNewY ? this.length - anotheRectangleNewY : 0);
        double intersetWidth = (this.width - anotheRectangle.x) - (this.width > anotheRectangleNewX ? this.width - anotheRectangleNewX : 0);

        double interArea = intersetLength * intersetWidth;

        return interArea;
    }
}
