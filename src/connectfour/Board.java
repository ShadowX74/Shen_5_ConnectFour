/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour;

import java.util.List;

/**
 *
 * @author ShadowX
 */
public class Board {
    
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_WHITE = "\u001B[37m";

    
    Node a1, a2, a3, a4, a5, a6, a7;
    Node b1, b2, b3, b4, b5, b6, b7;
    Node c1, c2, c3, c4, c5, c6, c7;
    Node d1, d2, d3, d4, d5, d6, d7;
    Node e1, e2, e3, e4, e5, e6, e7;
    Node f1, f2, f3, f4, f5, f6, f7;
    
    final Node[][] board = {{a1, a2, a3, a4, a5, a6, a7},
        {b1, b2, b3, b4, b5, b6, b7},
        {c1, c2, c3, c4, c5, c6, c7}, 
        {d1, d2, d3, d4, d5, d6, d7}, 
        {e1, e2, e3, e4, e5, e6, e7}, 
        {f1, f2, f3, f4, f5, f6, f7}};
    
    int h = 6, w = 7;
    
    public Board() {
        for (int i = 0; i < h; i++) { //For each row
            for (int j = 0; j < w; j++) { //For each column
                board[i][j] = new Node();
                
                boolean up = false, down = false, left = false, right = false;
                
                if (i < h - 1) { //if not bottom
                    down = true;
                    board[i][j].setDown(board[i + 1][j]);
                }
                if (j < w - 1) { //if not right
                    right = true;
                    board[i][j].setRight(board[i][j + 1]);
                }
                if (i != 0) { //if not top
                    up = true;
                    board[i][j].setUp(board[i - 1][j]);
                }
                if (j != 0) { //if not left
                    left = true;
                    board[i][j].setLeft(board[i][j - 1]);
                }
                if (up && left) {
                    board[i][j].setUpleft(board[i - 1][j - 1]);
                }
                if (up && right) {
                    board[i][j].setUpright(board[i - 1][j + 1]);
                }
                if (down && left) {
                    board[i][j].setDownleft(board[i + 1][j - 1]);
                }
                if (down && right) {
                   board[i][j].setDownright(board[i + 1][j + 1]);
                }
                
            }
        }
    }
    
    public void printBoard() {
        for (Node[] row : board) {
            for (Node n : row) {
                if (n.getValue() == 0) {
                    System.out.print("○");
                } else if (n.getValue() == 1) {
                    System.out.print(ANSI_BLUE + "⬤");
                } else if (n.getValue() == 2) {
                    System.out.print(ANSI_RED + "⬤");
                }
            }
            System.out.println("");
        }
    }
}
