/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour;

import java.util.Scanner;

/**
 *
 * @author ShadowX
 */
public class Game {

    static Scanner scan = new Scanner(System.in);
    static boolean play = true;

    public static void menu() {
        while (play) {
            System.out.println("What would you like to do?");
            System.out.println("A) Play");
            System.out.println("B) Best of 3");
            System.out.println("C) Exit");

            String choice = scan.nextLine().toUpperCase();
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
        }
    }

    private static void play3() {
        int p1w = 0;
        int p2w = 0;
        while (p1w < 2 && p2w < 2) {
            int outcome = game();
            if (outcome == 1) {
                p1w++;
            } else if (outcome == 2){
                p2w++;
            } else {
                break;
            }
        }
        if (p1w == 2) {
            System.out.println("Player 1 wins!");
        } else if (p2w == 2) {
            System.out.println("Player 2 wins!");
        }
    }

    private static int game() {
        Board board = new Board();
        boolean notWin = true;
        int counter = 1;
        while (notWin) {
            board.printBoard();
            System.out.println("Player " + counter + ", what column will you play in?");
            String choice = scan.nextLine();
            if (Integer.parseInt(choice) > board.w || Integer.parseInt(choice) > board.w) {
                System.out.println("Please try again.");
                counter --;
            } else {
                checkDown(board, Integer.parseInt(choice) - 1);
            }
            counter++;
        }
        return 1;
    }
    
    private static boolean checkDown(Board b, int c) {
        if (b.board[0][c].getDown().getValue() == 0) {
            checkDown(b, int c);
        }
    }
}
