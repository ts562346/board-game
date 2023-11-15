/**
 * @author Tasneem Hoque
 * @description This class that holds the information of any piece created
 */
public class Piece {
    private String name; // name of the piece
    private String colour; // colour of the piece
    private Point position; // position of the piece in (x, y) format

    public Piece(String name, String colour, Point position){ // constructor
        this.name = name;
        this.colour = colour;
        this.position = position;
    }

    // getters and setters

   public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) { // sets the x and y positions individually
        this.position.setX(position.getX());
        this.position.setY(position.getY());
    }

    public String toString() {
        return name + colour;
    } // toString prints only the name and colour
}
