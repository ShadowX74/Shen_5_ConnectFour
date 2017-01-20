/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ShadowX
 */
public class Game {

    //scanner for input
    static Scanner scan = new Scanner(System.in);
    //boolean to loop game
    static boolean play = true;
    //counting turns
    static int counter = 1;
    //current node we are working with
    static Node current;

    /**
     * *********************************************************************
     * Method: menu Description: Asks the user what they want to do and executes
     * it Parameters: N/A Pre-conditions: Called in Main Post-conditions: User
     * commands run
     * *********************************************************************
     */
    public static void menu() {
        while (play) {
            System.out.println("What would you like to do?");
            System.out.println("A) Play");
            System.out.println("B) Best of 3");
            System.out.println("C) Exit");

            String choice = scan.nextLine().toUpperCase();
            choice = scan.nextLine().toUpperCase();

            if (choice.equals("A")) {
                if (game() == 1) {
                    System.out.println("Player 1 wins!");
                } else {
                    System.out.println("Player 2 wins!");
                }
            } else if (choice.equals("B")) {
                play3();
            } else {
                play = false;
            }
            System.out.println("");
        }
    }

    /**
     * *********************************************************************
     * Method: play3 Description: plays a best of 3 round of connect four games
     * Parameters: N/A Pre-conditions: Called in menu after user chooses Bo3
     * Post-conditions: 2-3 connect four games run, winner chosen, user
     * redirected back to menu
     * *********************************************************************
     */
    private static void play3() {
        int p1w = 0;
        int p2w = 0;
        while (p1w < 2 && p2w < 2) {
            int outcome = game();
            if (outcome == 1) {
                System.out.println("Player 1 won a match!");
                p1w++;
            } else if (outcome == 2) {
                System.out.println("Player 2 won a match!");
                p2w++;
            } else {
                break;
            }
            System.out.println("Score: ");
            System.out.println("Player 1: " + p1w);
            System.out.println("Player 2: " + p2w);
        }
        if (p1w == 2) {
            System.out.println("Player 1 wins!");
        } else if (p2w == 2) {
            System.out.println("Player 2 wins!");
        }
    }

    /**
     * *********************************************************************
     * Method: game Description: runs a game of connect four Parameters: N/A
     * Pre-conditions: User chooses to play connect four Post-conditions: Game
     * run and winner chosen
     * *********************************************************************
     */
    private static int game() {
        Board board = new Board();
        boolean notWin = true;
        while (notWin) {
            int player = counter % 2;
            if (player == 0) {
                player = 2;
            }
            board.printBoard();
            System.out.println("Player " + player + ", what column will you play in?");
            int choice = scan.nextInt();
            if (choice > board.w || choice > board.w) {
                System.out.println("Not valid. Please try again.");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                }
                counter--;
            } else {
                int r = 0;
                boolean goDown = true;
                while (goDown) {
                    if (checkDown(board, choice - 1, r, player)) {
                        r++;
                    } else {
                        goDown = false;
                    }
                }
                if (checkWin(choice - 1, r)) {
                    board.printBoard();
                    return player;
                }

            }
            counter++;

//            for (int i = 0; i < 1000; i++) {
//                System.out.println("");
//            }
        }
        return 1;
    }

    /**
     * *********************************************************************
     * Method: checkDown Description: Places new piece as far down as it will go
     * in user specified column Parameters: Board b, int c, int r, int player
     * Pre-conditions: Called in when a player places a piece in the board b at
     * the column c. R is the row currently being checked and player is the
     * value the desired location is set to Post-conditions: Piece placed in
     * correct location, game goes on
     * *********************************************************************
     */
    private static boolean checkDown(Board b, int c, int r, int player) {
        if (r == b.h - 1) {
            b.board[r][c].setValue(player);
            current = b.board[r][c];
            return false;
        }
        if (b.board[r][c].getValue() != 0) {
            counter--;
            System.out.println("Not valid. Please try again.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        }

        boolean keepGoing = true;
        if (b.board[r][c].getDown().getValue() == 0) {
            keepGoing = true;
        } else {
            b.board[r][c].setValue(player);
            current = b.board[r][c];
            keepGoing = false;
        }

        return keepGoing;
    }

    /**
     * *********************************************************************
     * Method: checkWin Description: checks if a user has won Parameters: int c,
     * int r Pre-conditions: called after a user moves at column c and row r to
     * see if the move has won them the game Post-conditions: boolean returned
     * on whether game has been won or not
     * *********************************************************************
     */
    private static boolean checkWin(int c, int r) {
        boolean down = false, left = false, right = false, upleft = false, upright = false, downright = false, downleft = false;
        if (r <= 2) {
            if (current.getValue() == current.getDown().getValue()
                    && current.getValue() == current.getDown().getDown().getValue()
                    && current.getValue() == current.getDown().getDown().getDown().getValue()) {
                System.out.println(current.getValue());
                return true;
            }
        }
        if (current.getLeft() != null) {
            if (current.getValue() == current.getLeft().getValue()) {
                left = true;
            }
        }
        if (current.getRight() != null) {
            if (current.getValue() == current.getRight().getValue()) {
                right = true;
            }
        }
        if (current.getUpleft() != null) {
            if (current.getValue() == current.getUpleft().getValue()) {
                upleft = true;
            }
        }
        if (current.getDownleft() != null) {
            if (current.getValue() == current.getDownleft().getValue()) {
                downleft = true;
            }
        }
        if (current.getDownright() != null) {
            if (current.getValue() == current.getDownright().getValue()) {
                downright = true;
            }
        }
        if (current.getUpright() != null) {
            if (current.getValue() == current.getUpright().getValue()) {
                upright = true;
            }
        }
        System.out.println(left);
        System.out.println(right);
        if (left && right) {
            System.out.println(current.getRight().getRight().getValue());
            if (current.getRight().getRight() != null) {
                if (current.getRight().getRight().getValue() == current.getValue()) {
                    return true;
                }
            }
            if (current.getLeft().getLeft() != null) {
                if (current.getLeft().getLeft().getValue() == current.getValue()) {
                    return true;
                }
            }
        }
        
        if (left) {
            if (current.getLeft().getLeft() != null) {
                if (current.getLeft().getLeft().getLeft() != null 
                        && current.getLeft().getLeft().getValue() == current.getValue()) {
                    if (current.getLeft().getLeft().getLeft().getValue() == current.getValue()) {
                        return true;
                    }
                }
            }
        }
        
        if (right) {
            if (current.getRight().getRight() != null) {
                if (current.getRight().getRight().getRight() != null 
                        && current.getRight().getRight().getValue() == current.getValue()) {
                    if (current.getRight().getRight().getRight().getValue() == current.getValue()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
