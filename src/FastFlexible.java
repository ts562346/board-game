/**
 * @author Tasneem Hoque
 * @description this class extends the FastPiece class. It creates a type of game piece that can move
 *              right, left like the FastPiece class, in addition to that it can also move up or down
 *              by n number of spaces.
 */
public class FastFlexible extends FastPiece{
    public FastFlexible (String name, String colour, Point position) {
        super(name, colour, position);
    }

    /**
     * This method is used to move a piece right, left, up or down by n number of spaces
     * @param direction tells whether the piece should be moved right, left or up or down
     * @param n tells how many spaces the piece should move
     * @return boolean, true if the move was done correctly
     */

    public boolean move (String direction, int n){
        if(super.move(direction, n)){ // calls the move method in SlowPiece class to check ...
                                        // ... if the direction was right or left
            return true; // if it was then return true otherwise check if the direction is up or down
        } else if (direction.equals("up")) {
            if (x-n >= 0) { // check if moving up is a valid move
                p = new Point(x - n, y); // if the direction is up, move up n row by subtracting from x
                this.setPosition(p); // set the location of this piece to the new location
                return true; // return true once the move is successful
            }
        } else if (direction.equals("down")) {
            if (x+n <= 7) { // check if moving down is a valid move
                p = new Point(x + n, y); // if the direction is down, move down n row by adding to x
                this.setPosition(p); // set the location of this piece to the new location
                return true; // return true once the move is successful
            }
        } return false; // return false if the direction is wrong
    }

    public String toString() {
        return super.toString() + "F"; // calls super class to get the name and colour and since it's a fast flexible
                                        // piece, a 'F' is printed at the end
    }
}
