
package checkers;

public class Move extends Checkers{
	
	// This class will take the user input and validate it.
	
	
    boolean validMove(int[] direction) {
        return (direction[0]==-1 || direction[0]==1) && (direction[1]==-1 || direction[1]==1);
	}

	boolean validSpace(int i, int j, int[] direction) {
    	// Is the play destroying another player's piece
        boolean onBoard = true;
        if (board.Board[i][j]==(!Checkers.playOneTurn ? 1 : 2)){

            // Get the new coordinates of the jump after
            i +=direction[0];
            j +=direction[1];

            // Check if the new coordinates are on the board, ie. within the board's border
            onBoard = i < 8 &&
                    i >= 0 &&
                    j >=0 &&
                    j < 8;
        }

        // Check if the space is free

        return board.Board[i][j] == 0 && onBoard;
    }
	public void movePiece(int colFrom, int rowFrom, int colTo, int rowTo){


        // Get the direction of the move
        int[] direction = this.getDirection(rowFrom,colFrom,rowTo,colTo);
        
        if (board.Board[rowTo][colTo]==(!Checkers.playOneTurn ? 1 : 2)){
        	System.out.println((!Checkers.playOneTurn ? 1 : 2));
            board.Board[rowTo][colTo] = 0;

            // The new coordinates is the ones behind the enemy
            rowTo +=direction[0];
            colTo +=direction[1];
            System.out.println("You attacked an enemy! You get an extra turn.");

            // Decrement the number of pieces for the enemy player
            if(Checkers.playOneTurn){
            	System.out.println("removing player 2 piece");
                super.setPlayerOnePieces(getPlayerOnePieces()-1);
            }
            else{
            	System.out.println("removing player 1 piece");
                super.setPlayerTwoPieces(getPlayerTwoPieces()-1);
            }


        }
        else{
            Checkers.playOneTurn = !Checkers.playOneTurn;
        }
        board.Board[rowTo][colTo] = board.Board[rowFrom][colFrom];
        board.Board[rowFrom][colFrom] = 0;

        // Toggle turn


    }
	

	public int[] getDirection(int rowFrom, int colFrom, int rowTo, int colTo) {
        return new int[] {rowTo-rowFrom,colTo-colFrom};
	}

	boolean validPiece(int row,int col){
        return board.Board[row][col] == (Checkers.playOneTurn ? 1 : 2);
    }

}
