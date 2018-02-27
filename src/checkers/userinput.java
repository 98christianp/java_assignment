package checkers;

import java.util.Scanner;

public class userinput extends Move {
	Scanner userInput = new Scanner(System.in);
	int[] CoordList = new int[4];
	public int[] getUserInput(){
	        String userInputVal;
	        boolean userNotDone = true;

	        int coordInput;
	        // by index: colfrom,rowFrom,colTo,colTo

	        int currentCoordinateIndex = 0;
	        System.out.println("\nPlayer " + (Checkers.playOneTurn?1:2));
	        System.out.println("Choose piece");

	        while(userNotDone){

	            if(currentCoordinateIndex==0 || currentCoordinateIndex==2) {
	                System.out.print("Enter X: ");
	            }
	            else{
	                System.out.print("Enter Y: ");
	            }


	            if(this.userInput.hasNextLine()) {
	                userInputVal = this.userInput.nextLine();

	                try {
	                    coordInput = Integer.parseInt(userInputVal);
	                    if(coordInput>=0 && coordInput < 8){
	                        this.CoordList[currentCoordinateIndex] = coordInput;
	                        currentCoordinateIndex++; // Next value

	                        if(currentCoordinateIndex==2) {
	                            if (super.validPiece(this.CoordList[1],this.CoordList[0])){
	                                System.out.println("\nChoose new position or 'x' to choose again");
	                            }
	                            else{	
	                                System.out.println("\nThis is not your piece! Choose again");
	                                currentCoordinateIndex = 0;
	                            }

	                        }
	                        else if(currentCoordinateIndex>3) {
	                            int[] direction = super.getDirection(this.CoordList[1],this.CoordList[0],this.CoordList[3],this.CoordList[2]);
	                            if (!super.validSpace(this.CoordList[3],this.CoordList[2],direction)){
	                                System.out.println("\nYou cannot move to that space! Choose again");
	                                currentCoordinateIndex = 2;
	                            }
	                            else if (!super.validMove(direction)) {
	                                System.out.println("\nIllegal move! Choose again");
	                                currentCoordinateIndex = 2;
	                            }
	                            else{
	                            	
	                                userNotDone = false;
	                            }

	                        }
	                    }
	                    else{
	                        System.out.println("\nThe input has to be between the values 0 and 7! Choose again");
	                    }


	                } catch (NumberFormatException e) {
	                    // User error msg
	                    if(userInputVal.equals("x")){
	                        currentCoordinateIndex = 0;
	                        System.out.println("\nPlayer " + (Checkers.playOneTurn?1:2));
	                        System.out.println("Choose piece");
	                    }
	                    else {
	                        System.out.println("You can only put integers and input!");
	                    }
	                }

	            }
	        }

	        return this.CoordList;
	    }
}
