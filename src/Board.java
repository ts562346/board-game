/**
 * @author Tasneem Hoque
 * @description this is the board class that contains all the game pieces. This class can create, move and
 *              print the various kinds of pieces
 */
public class Board {
    private Piece [][] gameBoard;

    public Board () {
        gameBoard = new Piece [8][8]; // creates an 8 x 8 game board
    }

    /**
     * This method is used to add a new given piece in the board at the location (also give)
     * @param location of type Point, where the piece should be located
     * @param p of type Piece, which is to be added to the board
     */
    public void addPiece (Point location, Piece p) {
        if (location.getX() >= 0 && location.getX() < 8 && location.getY() >= 0 && location.getY() < 8 &&
                gameBoard[location.getX()][location.getY()] == null) { // check if the location is valid and there
                                                                        // are no piece there already
            gameBoard[location.getX()][location.getY()] = p; // get the a and y of the location and add the piece
            System.out.println ("Created new game piece.\n"); // print confirmation that piece was added
        }
        else if (!(location.getX() >= 0 && location.getX() < 8 && location.getY() >= 0 && location.getY() < 8))
            System.out.println("Location is out of range.\n"); // check if the location is out of range
        else
            System.out.println("Error: piece already exists at " + location + "\n");
        // print this if all the other statements are false
    }

    /**
     * This method is used to move a given piece (slow or slow flexible) in the board in some direction
     * @param location of type Point, where the piece to move is located
     * @param direction of type String, which is the direction the piece should be moved
     */

    public void move (Point location, String direction) {
        int x = location.getX(); // make an x variable equal to the x value of the location
        int y = location.getY(); // make an y variable equal to the y value of the location
        if (gameBoard[x][y] == null){ // if there is no piece at the location, nothing can be moved
            System.out.println("Error: no piece at " + location + "\n");
        }
        else if (x >= 0 && x < 8 && y >= 0 && y < 8) { // check if x and y are within range
            if (gameBoard[x][y].getClass() == SlowPiece.class) { // check if the class is of type SlowPiece
                SlowPiece p = new SlowPiece(gameBoard[x][y].getName(), gameBoard[x][y].getColour(),
                        gameBoard[x][y].getPosition()); // create a new piece with the same info as the original piece
                move2(p, direction, location);
            } else if (gameBoard[x][y].getClass() == SlowFlexible.class) { // check if the class is of type SlowFlexible
                SlowFlexible p = new SlowFlexible(gameBoard[x][y].getName(), gameBoard[x][y].getColour(),
                        gameBoard[x][y].getPosition()); // create a new piece with the same info as the original piece
                move2(p, direction, location);
            } else {
                System.out.println("Piece at " + location +  " could not be moved.\n"); // print error
            }
        } else {
            System.out.println("Location is out of range.\n"); // if move cannot be done, print error
        }
    }

    /**
     * This method, along with the move method is used to move a given piece (slow or slow flexible) in the
     * board in some direction
     * @param p the piece to be moved
     * @param direction of type String, which is the direction the piece should be moved
     * @param location of type Point, where the piece to move is located
     */

    public void move2 (SlowPiece p, String direction, Point location){
        if (p.move(direction)) { // check if the move was done successfully
            if (gameBoard[p.getPosition().getX()][p.getPosition().getY()] == null) {
                System.out.println("Piece at " + location + " moved " + direction + " by 1 space.\n");
                gameBoard[p.getPosition().getX()][p.getPosition().getY()] = p; // set the piece at the new location
                gameBoard[location.getX()][location.getY()] = null; // set the original piece position as null in the game board
            } else {
                p.setPosition(location);
                System.out.println("Error: move cannot be made, blocked by another piece.\n");
            }
        } else
            System.out.println("The direction is inaccurate.\n"); // print error
    }

    /**
     * This method is used to move a given piece (slow or slow flexible) in the board in some direction
     * @param location of type Point, where the piece to move is located
     * @param direction of type String, which is the direction the piece should be moved
     * @param space of type int, which is the amount of spaces the piece should be moved
     */

    public void move (Point location, String direction, int space){
        int x = location.getX(); // make an x variable equal to the x value of the location
        int y = location.getY(); // make an y variable equal to the y value of the location
        if (gameBoard[x][y] == null){ // if there is no piece at the location, nothing can be moved
            System.out.println("Error: no piece at " + location + "\n");
        }
        else if (x >= 0 && x < 8 && y >= 0 && y < 8) { // check if x and y are within range
            if (gameBoard[x][y].getClass() == FastPiece.class) { // check if the class is of type FastPiece
                FastPiece p = new FastPiece(gameBoard[x][y].getName(), gameBoard[x][y].getColour(),
                        gameBoard[x][y].getPosition()); // create a new piece with the same info as the original piece
                move2(p, direction, location, space);
            } else if (gameBoard[x][y].getClass() == FastFlexible.class){ // check if the class is of type FastFlexible
                FastFlexible p = new FastFlexible(gameBoard[x][y].getName(), gameBoard[x][y].getColour(),
                        gameBoard[x][y].getPosition()); // create a new piece with the same info as the original piece
                move2(p, direction, location, space);
            } else {
                System.out.println("Piece at " + location +  " could not be moved.\n");
            }
        } else {
            System.out.println("Location is out of range.\n"); // print error
        }
    }

    /**
     * This method, along with the move method is used to move a given piece (slow or slow flexible) in the
     * board in some direction
     * @param p the piece to be moved
     * @param direction of type String, which is the direction the piece should be moved
     * @param location of type Point, where the piece to move is located
     * @param space the number of spaces the piece should be moved
     */

    public void move2 (FastPiece p, String direction, Point location, int space){
        if (p.move(direction, space)) { // check if the move was done successfully
            if (gameBoard[p.getPosition().getX()][p.getPosition().getY()] == null) {
                System.out.println("Piece at " + location + " moved " + direction + " by " + space + " spaces\n");
                gameBoard[p.getPosition().getX()][p.getPosition().getY()] = p; // set the piece at the new location
                gameBoard[location.getX()][location.getY()] = null; // set the original piece position as null in the game board
            } else {
                p.setPosition(location);
                System.out.println("Error: move cannot be made, blocked by another piece.\n");
            }
        } else
            System.out.println("The direction or jump value is inaccurate.\n"); // print error
    }

    public String toString(){
        String returnString = ""; // make a variable string to return the entire board
        for (int i = 0; i < gameBoard.length; i++){
            for (int j = 0; j < gameBoard[i].length; j++){
                if (gameBoard[i][j] != null) { // if there is a piece on the board, print it
                    returnString +=  gameBoard[i][j].toString();
                } else {
                    returnString += "-\t"; // otherwise print dashes
                }
            }
            returnString += "\n"; // go to next line after printing a row
        }
        return returnString; // return the string variable
    }
}
