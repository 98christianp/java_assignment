package checkers;

public class GameStatus extends Checkers {
	public void Check() {
		System.out.println(super.getPlayerOnePieces() + ":" + super.getPlayerTwoPieces());

		if (super.getPlayerOnePieces() == 0 || super.getPlayerTwoPieces() == 0) {
			System.out.println("The game is finished");
			if(super.getPlayerOnePieces() == 0) {
				System.out.println("Player 2 is the winner!");
			} else {
				System.out.println("Player 1 is the winner!");
			}
			Checkers.gameRunning = false;
			
		}
		
	}

}
