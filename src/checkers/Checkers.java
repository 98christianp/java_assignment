package checkers;

public class Checkers {
	static boolean gameRunning = true;
    public int playerOnePieces;
    public int playerTwoPieces;
    static public boolean playOneTurn = true; // It is either player one or player two, thus a boolean is sufficient
    
	
	public static void main(String[] args) {
		board Board = new board();
		Board.printBoard();
		userinput Usr = new userinput();
		Move move = new Move();
		while (gameRunning) {
			Usr.getUserInput();
			move.movePiece(Usr.CoordList[0], Usr.CoordList[1], Usr.CoordList[2], Usr.CoordList[3]);
			Board.printBoard();
			
		}
		
		
	}
	
}
