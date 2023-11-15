# board-game

This is a board game simulation with pieces that can be created, moved, and displayed on an 8x8 game board. There are four types of pieces: SlowPiece, FastPiece, SlowFlexiblePiece, and FastFlexiblePiece. Each piece has a name, color, and position on the board.

Piece Class:

Fields: Name (String), Color (String), Position (a pair of integers [x, y]).
Methods: Constructor, Getters and Setters, toString().
SlowPiece Class (extends Piece):

Additional method: move(String direction) - moves the piece left or right by one space.
FastPiece Class (extends Piece):

Additional method: move(String direction, int n) - moves the piece left or right by a specified number of spaces.
SlowFlexiblePiece Class (extends SlowPiece):

Inherits move(String direction) from SlowPiece.
FastFlexiblePiece Class (extends FastPiece):

Inherits move(String direction, int n) from FastPiece.
Board Class:

Holds an 8x8 game board with positions that can be either empty or occupied by a piece.
Methods:
addPiece(Piece piece, int x, int y) - adds a new piece to the board at the specified location.
movePiece(int fromX, int fromY, String direction, int spaces) - moves a piece from a given location in a given direction by a given number of spaces.
displayBoard() - displays the current state of the game board.
GameDemo Class:

Accepts user commands to create pieces, move them, and display the game board.
Commands:
create location [fast][flexible]: Creates a new piece at a given location with optional fast and flexible parameters.
move location direction [spaces]: Moves a piece from a given location in a specified direction, with an optional spaces parameter for fast pieces.
print: Displays the current state of the game board.
help: Lists all available commands.
exit: Exits the program.

The game simulation is interactive, allowing users to input commands to create pieces, move them on the board, and view the board's current state. Error checking is implemented to ensure the legality of parameters passed to the methods. The example commands provided demonstrate the functionality of creating pieces, moving them, displaying the board, and exiting the program
