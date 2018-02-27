package checkers;

public class board {

	static int[][] Board;
        
    public void printBoardBorder(boolean axis){
        // Builds the top or bottom part of board
        if(axis){
            System.out.print(" ");
            for(int i = 0; i<8;i++){
                System.out.print(" " + i);
            }
            System.out.print("\n");
        }


        System.out.print(" +");
        for(int i = 0; i<8*2;i++){
            System.out.print("-");
        }
        System.out.print("+\n");
    }

    // Print the board
    public void printBoard(){

        String boardPiece; // Initialize the piece variable

        // Build top part of board
        this.printBoardBorder(true);

        // Build current state of the board
        for(int row = 0; row<8;row++){
            System.out.print(row+"|");
            for(int col = 0; col<8;col++){
                boardPiece = board.Board[row][col]==0 ? "  " : board.Board[row][col]==1 ? "1 " : "2 ";
                System.out.print(boardPiece);
            }
            System.out.print("|\n");

        }

        // Build bottom part of board
        this.printBoardBorder(false);
    }
    public board() {
    	board.Board = new int[][] {
            {0,1,0,1,0,1,0,1},
            {1,0,1,0,1,0,1,0},
            {0,1,0,1,0,1,0,1},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {2,0,2,0,2,0,2,0},
            {0,2,0,2,0,2,0,2},
            {2,0,2,0,2,0,2,0}};
    }
}
