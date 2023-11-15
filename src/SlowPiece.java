/**
 * @author Tasneem Hoque
 * @description this class extends the Piece class. It creates a type of game piece that can move
 *              only right or left by one space.
 */
public class SlowPiece extends Piece {
    protected Point p; // a new point to set the new location of the piece
    protected int x; // x position for the original point
    protected int y; // y position for the original point

    public SlowPiece(String name, String colour, Point position) {
        super(name, colour, position);

        x = this.getPosition().getX(); // sets the x to the original point
        y = this.getPosition().getY(); // sets the y to the original point
        p = new Point(x, y); // sets the point to the original point
    }

    /**
     * This method is used to move a piece right or left by one space
     * @param direction tells whether the piece should be moved right or left
     * @return boolean, true if the move was done correctly
     */

    public boolean move(String direction) {
         if (direction.equals("right")) {
            if (y+1 <= 7) { // when the direction is right, adds 1 to the y and checks if its out of bounds
                p = new Point(x, y+1); // creates a new point for the move
                this.setPosition(p); // sets the position of the piece, the same as the new point
                return true; // once done, returns true to indicate the movement is done
            }
         }
        else if (direction.equals("left")) {
            if (y-1 >= 0) { // when the direction is left, subtracts 1 from the y and checks if its out of bounds
                p = new Point(x, y-1); // creates a new point for the move
                this.setPosition(p); // sets the position of the piece, the same as the new point
                return true; // once done, returns true to indicate the movement is done
            }
        } return false; // if the direction is neither left or right returns false cause the move cannot be done
    }

    public String toString() {
        return super.toString() + "S"; // calls super class to get the name and colour and since it's a slow
                                        // piece, a 'S' is printed at the end
    }
}
