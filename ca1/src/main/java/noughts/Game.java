/*
 * Game.java
 *
 * Represents a game of noughts and crosses
 */

package noughts;

import java.util.ArrayList;
import java.util.List;

public class Game {
    
    BoxStatus[] board = new BoxStatus[9]; // board contains 9 boxes
    
    /** Creates a new instance of game */
    public Game() {
        for(int i = 0; i<9; i++)
            board[i] = BoxStatus.Empty; // initially each box is empty (not taken)
        
    }
    
    public boolean isEmpty(int n) {
        // is a box empty?
        return (board[n-1] == BoxStatus.Empty);
    }
    
    public boolean isComputer(int n) {
        // is a box taken by the Computer?
        return (board[n-1] == BoxStatus.Computer);
    }
    
    public boolean isHuman(int n) {
        // is a box taken by the Human?
        return (board[n-1] == BoxStatus.Human);
    }
    
    public void setHuman(int n) {
        // human claims square N
        board[n-1] = BoxStatus.Human;
    }
    
    public void setComputer(int n) {
        // computer claims square N
        board[n-1] = BoxStatus.Computer;
    }
    
    public BoxStatus getBox(int n) {
        // return square N
        return board[n-1];
    }

    public char boxChar(int n) {
        // return a character which shows whether a square is empty, taken by the computer, or taken by the human
        switch (board[n-1]) {
            case Human: return 'X';
            case Computer: return 'O';
            case Empty: return '.';
        }
        return ' ';
    }

    public BoxStatus checkWin() {
    for (int i = 0; i < 3; i++) {
        if (board[i*3] == board[i*3+1] && board[i*3] == board[i*3+2]) {
            return board[i*3]; // The winner is the common BoxStatus value in this row
        }
    }
    for (int i = 0; i < 3; i++) {
        if (board[i] == board[i+3] && board[i] == board[i+6]) {
            return board[i]; // The winner is the common BoxStatus value in this column
        }
    }
    if (board[0] == board[4] && board[0] == board[8]) {
        return board[0]; // The winner is the common BoxStatus value on the main diagonal
    }
    if (board[2] == board[4] && board[2] == board[6]) {
        return board[2]; // The winner is the common BoxStatus value on the secondary diagonal
    }
    return BoxStatus.Empty; // No winner, the game continues
    }



    public void printBoard() {
        // print the noard on System.out
        System.out.println("Board");
        System.out.printf("| %c %c %c |\n", boxChar(1), boxChar(2), boxChar(3));
        System.out.printf("| %c %c %c |\n", boxChar(4), boxChar(5), boxChar(6));
        System.out.printf("| %c %c %c |\n", boxChar(7), boxChar(8), boxChar(9));
    }
    
}
