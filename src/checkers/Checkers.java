package checkers;

public class Checkers {
	static boolean gameRunning = true;
    static private int playerOnePieces;
    static private int playerTwoPieces;
    static public boolean playOneTurn = true; // It is either player one or player two, thus a boolean is sufficient
    
    public int getPlayerTwoPieces() {
		return playerTwoPieces;
	}
	public int getPlayerOnePieces() {
		return playerOnePieces;
	}
	public void setPlayerOnePieces(int playerOnePieces) {
		Checkers.playerOnePieces = playerOnePieces;
	}
	public void setPlayerTwoPieces(int playerTwoPieces) {
		Checkers.playerTwoPieces = playerTwoPieces;

	}
	public Checkers() {
		Checkers.playerOnePieces = 12;
		Checkers.playerTwoPieces = 12;

	}

	public static void main(String[] args) {
		board Board = new board();
		Board.printBoard();
		userinput Usr = new userinput();
		Move move = new Move();
		GameStatus status = new GameStatus();
		
		while (gameRunning) {
			Usr.getUserInput();
			System.out.println();
			move.movePiece(Usr.CoordList[0], Usr.CoordList[1], Usr.CoordList[2], Usr.CoordList[3]);
			status.Check();
			Board.printBoard();
			
		}
		
		
	}
	
}
