/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3poker;

import java.util.Arrays;

/**
 *
 * @author usuario_local
 */
public class ChenRankingParser implements RankingParser {

    private class chenHand implements Comparable<chenHand> {

        private final int n1, n2;
        private int value = 0;

        public chenHand(int n1, int n2) {
            this.n1 = n1;
            this.n2 = n2;

            int high = Math.max(n1, n2);
            int low = Math.min(n1, n2);

            value = highestPoints[high];
            if (n1 == n2) {
                value = Math.max(50, value * 2);
                if (n1 == 3) {
                    // 55 tiene un punto extra
                    value += 10;
                }
            } else {
                if (n1 < n2) {
                    // suited
                    value += 20;
                }
            }

            if (high - low == 2) {
                value -= 10;
            } else if (high - low == 3) {
                value -= 20;
            } else if (high - low == 4) {
                value -= 40;
            } else if (high - low >= 5) {
                value -= 50;
            }

            if (high - low >= 1 && high - low <= 2 && high <= 9) {
                // punto extra por poder hacer escaleras superiores
                value += 10;
            }
        }

        public int getValue() {
            return value;
        }

        @Override
        public String toString() {
            if (n1 == n2) {
                return "" + Poker.numberLetter[n1] + Poker.numberLetter[n1];
            } else if (n1 < n2) {
                // suited
                return "" + Poker.numberLetter[n2] + Poker.numberLetter[n1] + "s";
            } else {
                return "" + Poker.numberLetter[n1] + Poker.numberLetter[n2] + "o";
            }
        }

        @Override
        public int compareTo(chenHand o) {
            return Integer.compare(value, o.getValue());
        }
    }

    private final static int[] highestPoints = new int[]{10, 15, 20, 25, 30, 35, 40, 45, 50, 60, 70, 80, 100};
    private chenHand[] hands;

    public ChenRankingParser() {

        hands = new chenHand[169];
        
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 13; j++) {
                hands[i*13+j] = new chenHand(i, j);
            }
        }
        
        Arrays.sort(hands);

    }

    @Override
    public String getPercentage(double percentage) {
        StringBuilder result = new StringBuilder();
        
        double remaining = Poker.TOTAL_SIZE / 100.0 * percentage;
        
        for (int i=0; i<Poker.HANDS_COUNT; i++) {
            String hand = hands[Poker.HANDS_COUNT-1-i].toString();
            
            if (hand.length() == 2) {
                remaining -= 6;
            }
            else if (hand.charAt(2) == 's') {
                remaining -= 4;
            }
            else {
                remaining -= 12;
            }
            
            if (remaining < 0) break;
            if (i != 0) result.append(',');
            result.append(hand);
        }
        
        return result.toString();
    }
    
    @Override
    public String toString() {
        return "Chen";
    }

}
