/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour;

/**
 *
 * @author ShadowX
 */
public class Node {
    //what player the node is occupied by
    private int value = 0;
    //Node links
    private Node up, down, left, right, upleft, upright, downleft, downright;

    public Node() {
    }
    
     /**
     * *********************************************************************
     * Method: Getters and Setters
     * Description: gets and sets variables for each node
     * Parameters: N/A, the value to set the variable as
     * Pre-conditions: Called relative to each object to set and get their 
     * variables
     * Post-conditions: variables set or returned
     * *********************************************************************
     */
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getUp() {
        return up;
    }

    public void setUp(Node up) {
        this.up = up;
    }

    public Node getDown() {
        return down;
    }

    public void setDown(Node down) {
        this.down = down;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getUpleft() {
        return upleft;
    }

    public void setUpleft(Node upleft) {
        this.upleft = upleft;
    }

    public Node getUpright() {
        return upright;
    }

    public void setUpright(Node upright) {
        this.upright = upright;
    }

    public Node getDownleft() {
        return downleft;
    }

    public void setDownleft(Node downleft) {
        this.downleft = downleft;
    }

    public Node getDownright() {
        return downright;
    }

    public void setDownright(Node downright) {
        this.downright = downright;
    }
}
