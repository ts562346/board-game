/**
 * @author Tasneem Hoque
 * @description This class that holds the x and y values for any point
 */
public class Point {
    private int x; // the x value
    private int y; // the y value

    public Point (int x, int y){
        this.x = x;
        this.y = y;
    }

    // getters and setters

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX (int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String toString (){
        return "(" +  x + ", " + y + ")"; // returns the location as a string
    }
}
