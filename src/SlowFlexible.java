/**
 * @author Tasneem Hoque
 * @description this class extends the SlowPiece class. It creates a type of game piece that can move
 *              right, left like the SlowPiece class, in addition to that it can also move up or down
 *              by one space.
 */
public class SlowFlexible extends SlowPiece{
    public SlowFlexible (String name, String colour, Point position){
        super(name, colour, position);
    }

    /**
     * This method is used to move a piece up, down, right or left by one space
     * @param direction tells whether the piece should be moved up, down, right or left
     * @return boolean, true if the move was done correctly
     */

    public boolean move (String direction){
        if (super.move(direction)){ // calls the move method in SlowPiece class to check ...
                                    // ... if the direction was right or left
            return true; // if it was then return true otherwise check if the direction is up or down
        }
        else if (direction.equals("up")) {
            if (x-1 >= 0) { // check if moving up is a valid move
                p = new Point(x-1, y); // if the direction is up, move up one row by subtracting from x
                this.setPosition(p); // set the location of this piece to the new location
                return true; // return true once the move is successful
            }
        }
        else if (direction.equals("down")) {
            if (x+1 <= 7) { // check if moving down is a valid move
                p = new Point(x+1, y ); // if the direction is down, move down one row by adding to x
                this.setPosition(p); // set the location of this piece to the new location
                return true; // return true once the move is successful
            }
        } return false; // return false if the direction is wrong
    }

    public String toString() {
        return super.toString() + "F"; // calls super class to get the name and colour and since it's a slow flexible
                                        // piece, a 'F' is printed at the end
    }
}
