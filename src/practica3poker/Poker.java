/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practica3poker;

/**
 *
 * @author usuario_local
 */
public class Poker {
    
    public final static int HANDS_COUNT = 13*13;
    public final static int TOTAL_SIZE = 13*6 + (HANDS_COUNT-13)/2 * 4 + (HANDS_COUNT-13)/2 * 12;
    
    public final static char[] numberLetter = {'2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'};

    public final static int letterNumber(char c) {
        if (c == 'A') {
            return 12;
        } else if (c == 'K') {
            return 11;
        } else if (c == 'Q') {
            return 10;
        } else if (c == 'J') {
            return 9;
        } else if (c == 'T') {
            return 8;
        } else {
            return c - '2';
        }
    }

    public final static char[] numberColor = {'c','d','h','s'};
    
    public final static int letterColor(char c) {
        if (c == 'h') {
            return 0;
        } else if (c == 's') {
            return 1;
        } else if (c == 'd') {
            return 2;
        } else if (c == 'c') {
            return 3;
        }
        else {
            return -1;
        }
    }
    
    public final static int numberForCard(int card) {
        return card >> 2;
    }
    
    public final static int colorForCard(int card) {
        return card % 4;
    }
    
    public final static int cardIndex(int number, int color) {
        return number*4 + color;
    }
    
    public final static int cardIndex(String str) {
        int number = letterNumber(str.charAt(0));
        int color = letterColor(str.charAt(1));
        return cardIndex(number, color);
    }
}
