package ticTacToeProblem;

import java.util.Scanner;

public class TicTacToeGame
{
    public static void main(String[] args)
    {
    	final int MAX_TURNS = 9;
        Scanner input = new Scanner(System.in);
        TicTacToe board = new TicTacToe();
        int row = 0;
        int col = 0;
        
        boolean gameOver = false;
        boolean doneChoosingSpace = false;
        System.out.print("*** TIC TAC TOE ***");
        
        while (!gameOver && board.getTurn() < MAX_TURNS) {
            
            doneChoosingSpace = false;
            
            while(!doneChoosingSpace) {
                printYourTurn(board);
                board.printBoard();
                System.out.print("\nEnter a row: 0-2:\t");
                row = getInt(input);
                
                System.out.print("Enter a col: 0-2:\t");
                col = getInt(input);
                
                if (board.pickLocation(row, col)) {
                    doneChoosingSpace = true;
                    board.takeTurn(row, col);
                    
                    if (board.checkWin()) {
                        gameOver = true;
                    }
                }
                else {
                    System.out.println("I'm sorry, that space isn't available.  Please pick again.");
                }
            }
        }
        
        if (board.getTurn() == MAX_TURNS) {
            printTieScreen(board);
        }
        else {
            printWinnerScreen(board);
        }
    }
    
    public static int getInt(Scanner in) {
        int num = in.nextInt();
        while (num > 2 || num < 0) {
            System.out.print("Only enter a number between 0-2:  ");
            num = in.nextInt();
        }
        return num;
    }
    
    public static void printWinnerScreen(TicTacToe game) {
        System.out.println("\n*** GAME OVER ***\n");
        game.printBoard();
        int turnCount = game.getTurn() - 1;
        
        if (turnCount % 2 == 0) {
                System.out.println("\n'X' wins in " + game.getTurn() + " turns!");
            }
            else {
                System.out.println("\n'O' wins in " + game.getTurn() + " turns!");
            }
    }
    
    public static void printTieScreen(TicTacToe game) {
        System.out.println("\n*** TIE GAME ***\n");
        game.printBoard();
    }
    
    public static void printYourTurn(TicTacToe game) {
      if (game.getTurn() % 2 == 0) {
                System.out.println("\n'X' it is your turn\n");
            }
            else {
                System.out.println("\n'O' it is your turn\n");
            }   
    }
    
}