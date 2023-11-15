import java.util.Scanner;
/**
 * @author Tasneem Hoque
 * @description this is the demo class that runs the game by using Point, Piece, SlowPiece, SlowFlexible,
 *              FastFlexible, and the Board class. It makes sure the game runs smoothly without breaking
 *              the code
 */
public class GameDemo {
    public static void main (String [] args){
        Scanner sc = new Scanner(System.in);

        Board board = new Board(); // creates the new board to put the pieces in
        System.out.println ("Enter a command (type help for details): "); // prompts the first command
        String command = sc.nextLine(); // stores the first command in a variable

        while (!command.equals("exit")){ // keeps taking inputs until user types 'exit'
            String [] comm = command.split(" "); // breaks the string at any space
            if (comm.length == 0){ // if only a space is entered, user is asked to enter a command again
                System.out.println("Please enter a command.\n");
            }
            else if (comm[0].equals("help")){ // prints the following if 'help' is entered
                System.out.println("Possible commands are as follow:\n" +
                        "create location [fast][flexible]: Creates a new piece.\n" +
                        "move location direction [spaces]: Moves a piece.\n" +
                        "print: Displays the board.\n" +
                        "help: Displays help.\n" +
                        "exit: Exits the program.\n");
            }
            else if (comm[0].equals("print")){ // prints the board if 'print' is entered
                System.out.println(board.toString()); // calls toString() of the board object
            }
            else if (comm[0].equals("move") || comm[0].equals("create")) { // if the command is move or create...
                if (comm.length < 3) { // ... at least three parameters are required
                    System.out.println("Enter at least 3 parameters for create and 4 for move.\n");
                }
                // the second and third entries should have no more than one character, because its the location
                // and also check that the location entered is only number and not characters
                else if (comm[1].length() > 1 || comm[2].length() > 1 || comm[1].charAt(0) <= 48 || comm[1].charAt(0) >= 56 &&
                        comm[2].charAt(0) <= 48 || comm[2].charAt(0) >= 56) {
                    System.out.println("Enter proper location.\n");
                    // check if the command is move, and the length of the command is 4, then it's for
                    // SlowPiece or SlowFlexible piece
                } else if (comm[0].equals("move") && comm.length >= 5) {
                    // parse command 1 and 2 to make a point variable with the location provided
                    Point p = new Point(Integer.parseInt(comm[1]), Integer.parseInt(comm[2]));
                    // error checking for the spaces to move (i.e. must not be a character, only numbers)
                    if (comm[4].length() > 1 || comm[4].charAt(0) <= 48 || comm[4].charAt(0) >= 56)
                        System.out.println("Enter a valid number of spaces to move.\n");
                    else
                        board.move(p, comm[3], Integer.parseInt(comm[4])); // if there is no error, then make the move
                } else if (comm[0].equals("move") && comm.length >= 3) {
                        // parse command 1 and 2 to make a point variable with the location provided
                        Point p = new Point(Integer.parseInt(comm[1]), Integer.parseInt(comm[2]));
                        board.move(p, comm[3]); // call the move method in board to make the move
                        // check if the command is move, and the length of the command is 5, then it's for
                        // FastPiece or FastFlexible piece
                } else if (comm[0].equals("create")) { // if the user entered command is 'move'
                    // ... then ask for more inputs related to name and color
                    System.out.println("Input a name for the new piece: ");
                    String name = sc.nextLine();
                    System.out.println("Input a colour for the new piece: ");
                    String colour = sc.nextLine();
                    // parse command 1 and 2 to make a point variable with the location provided
                    Point position = new Point(Integer.parseInt(comm[1]), Integer.parseInt(comm[2]));
                    if (comm.length == 3) { // if only three parameters create default piece
                        Piece piece = new SlowPiece(name, colour, position);
                        board.addPiece(position, piece);
                    } else if (comm.length == 4 && comm[3].equals("slow")) { // for the rest, create the type of piece
                        Piece piece = new SlowPiece(name, colour, position); // ... wanted
                        board.addPiece(position, piece); // ... then add to the board
                    } else if (comm.length == 4 && comm[3].equals("fast")) {
                        Piece piece = new FastPiece(name, colour, position);
                        board.addPiece(position, piece);
                    } else if (comm.length == 5 && comm[3].equals("slow") && comm[4].equals("flexible")) {
                        Piece piece = new SlowFlexible(name, colour, position);
                        board.addPiece(position, piece);
                    } else if (comm.length == 5 && comm[3].equals("fast") && comm[4].equals("flexible")) {
                        Piece piece = new FastFlexible(name, colour, position);
                        board.addPiece(position, piece);
                    } else { // print error if the piece type is invalid
                        System.out.println("Error: piece must be of type slow, slow flexible, fast or fast flexible.\n");
                    }
                }
            }
            else
                System.out.println ("Invalid Command.\n"); // if the first parameter has errors print error statement

            // ask for user input again
            System.out.println ("Enter a command (type help for details): ");
            command = sc.nextLine();
        }
        System.out.println("Done."); // print done once exited
    }
}
