/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3poker;

import java.util.Arrays;

/**
 *
 * @author Jakub
 */
public final class PokerCalculator {

    int deckCards[];
    int usedCards[];
    int deckCardsCount;

    long playerWins[];
    int playersCount;
    int totalHands;

    private final int[] factorials;
    private final int[] bestPlayers;

    private final int playerColorCount[][];
    private final int playerColorMasks[][];
    private final int[] playerColors;
    private final long[] playerMasks3;

    private final int[] realToShiftedTable;
    private final int[] highCardsTable;
    private final int[] colorsTable;
    private final int[] lowestOneTable;
    private final int[] highestOneTable;

    private final int PAIR_MIN_VALUE = 1287;
    private final int TWO_PAIR_MIN_VALUE = PAIR_MIN_VALUE + 14 * 286;
    private final int THREE_MIN_VALUE = TWO_PAIR_MIN_VALUE + 13 * 78 + 12;
    private final int STRAIGHT_MIN_VALUE = THREE_MIN_VALUE + 13 * 78;
    private final int COLOR_MIN_VALUE = STRAIGHT_MIN_VALUE + 10;
    private final int FULL_HOUSE_MIN_VALUE = COLOR_MIN_VALUE + 1287;
    private final int POKER_MIN_VALUE = FULL_HOUSE_MIN_VALUE + 13 * 13;
    private final int STRAIGHT_FLUSH_MIN_VALUE = POKER_MIN_VALUE + 13 * 13;
    private final double[] playerTies;
    private int[] tableCards;

    public PokerCalculator(int playersCount) throws Exception {

        factorials = new int[52 * 8];
        for (int i = 0; i < 7; i++) {
            for (int upper = 0; upper < 52; upper++) {
                int lower = i + 1;
                factorials[lower + (upper << 3)] = (int) (getFactorialDivision(upper, upper - lower) / getFactorial(lower));
            }
        }

        realToShiftedTable = getRealMasksTable();
        highestOneTable = getHighestOneTable();
        lowestOneTable = getLowestOneTable();
        highCardsTable = getHighCardsTable();
        colorsTable = getColorsTable();

        totalHands = 0;

        this.playersCount = playersCount;
        bestPlayers = new int[playersCount];

        playerMasks3 = new long[playersCount];

        playerColors = new int[playersCount];
        for (int i = 0; i < playersCount; i++) {
            playerColors[i] = -1;
        }

        playerColorMasks = new int[playersCount][4];
        playerColorCount = new int[playersCount][4];

        playerWins = new long[playersCount];
        playerTies = new double[playersCount];

        usedCards = new int[52];

        deckCards = new int[(13 * 4 - playersCount * 2)];

    }

    public void setCards(int playerHands[][], int tableCards[], int deadCards[], boolean clear) {
        this.tableCards = tableCards;
        Arrays.fill(usedCards, 0);
        Arrays.fill(playerMasks3, 0);
        Arrays.fill(playerColors, -1);

        if (clear) {
            Arrays.fill(playerWins, 0);
            Arrays.fill(playerTies, 0);
            totalHands = 0;
        }

        // System.out.printf("%d, %d, %d, %d\n", playerHands[0][0], playerHands[0][1], playerHands[1][0], playerHands[1][1]);
        for (int i = 0; i < tableCards.length; i++) {
            usedCards[tableCards[i]]++;
        }

        for (int i = 0; i < deadCards.length; i++) {
            usedCards[deadCards[i]]++;
        }

        for (int i = 0; i < playersCount; i++) {
            Arrays.fill(playerColorMasks[i], 0);
            Arrays.fill(playerColorCount[i], 0);
            usedCards[playerHands[i][0]]++;
            usedCards[playerHands[i][1]]++;
            addCardToPlayer(i, playerHands[i][0]);
            addCardToPlayer(i, playerHands[i][1]);
        }

        int pos = 0;
        for (int i = 0; i < 52; i++) {
            if (usedCards[i] == 0) {
                deckCards[pos++] = i;
            }
        }
        deckCardsCount = pos;
    }

    public long[] getPlayerWins() {
        return playerWins.clone();
    }

    public int getTotalHands() {
        return totalHands;
    }

    public void calculate() throws Exception {
        for (int c1 = 0; c1 < deckCardsCount - 4; c1 += 1) {
            if (tableCards.length >= 1) {
                // Si hay cartas en la mesa, no recorremos las posibilidades
                // En su lugar, añadimos la carta fija
                addCardToPlayers(tableCards[0]);
                // c1=-1 para que c2 empiece en 0
                c1 = -1;
            } else {
                addCardToPlayers(deckCards[c1]);
            }

            for (int c2 = c1 + 1; c2 < deckCardsCount - 3; c2 += 1) {
                if (tableCards.length >= 2) {
                    addCardToPlayers(tableCards[1]);
                    c2 = -1;
                } else {
                    addCardToPlayers(deckCards[c2]);
                }

                for (int c3 = c2 + 1; c3 < deckCardsCount - 2; c3 += 1) {
                    if (tableCards.length >= 3) {
                        addCardToPlayers(tableCards[2]);
                        c3 = -1;
                    } else {
                        addCardToPlayers(deckCards[c3]);
                    }

                    for (int c4 = c3 + 1; c4 < deckCardsCount - 1; c4 += 1) {
                        if (tableCards.length >= 4) {
                            addCardToPlayers(tableCards[3]);
                            c4 = -1;
                        } else {
                            addCardToPlayers(deckCards[c4]);
                        }

                        for (int c5 = c4 + 1; c5 < deckCardsCount; c5 += 1) {
                            if (tableCards.length >= 5) {
                                addCardToPlayers(tableCards[4]);
                            } else {
                                addCardToPlayers(deckCards[c5]);
                            }

                            int bestPlayersCount = 1;
                            bestPlayers[0] = 0;
                            int bestResult = getPlayerResult(0);

                            for (int i = 1; i < playersCount; i++) {
                                int result = getPlayerResult(i);
                                if (result > bestResult) {
                                    bestPlayersCount = 1;
                                    bestPlayers[0] = i;
                                    bestResult = result;
                                } else if (result == bestResult) {
                                    bestPlayers[bestPlayersCount++] = i;
                                }
                            }

                            if (bestPlayersCount == 1) {
                                playerWins[bestPlayers[0]] += 1;
                            } else {
                                for (int i = 0; i < bestPlayersCount; i++) {
                                    playerTies[bestPlayers[i]] += 1.0 / bestPlayersCount;
                                }
                            }

                            totalHands++;

                            if (tableCards.length >= 5) {
                                removeCardFromPlayers(tableCards[4]);
                                break;
                            } else {
                                removeCardFromPlayers(deckCards[c5]);
                            }
                        }
                        if (tableCards.length >= 4) {
                            removeCardFromPlayers(tableCards[3]);
                            break;
                        } else {
                            removeCardFromPlayers(deckCards[c4]);
                        }
                    }
                    if (tableCards.length >= 3) {
                        removeCardFromPlayers(tableCards[2]);
                        break;
                    } else {
                        removeCardFromPlayers(deckCards[c3]);
                    }
                }
                if (tableCards.length >= 2) {
                    removeCardFromPlayers(tableCards[1]);
                    break;
                } else {
                    removeCardFromPlayers(deckCards[c2]);
                }
            }
            if (tableCards.length >= 1) {
                removeCardFromPlayers(tableCards[0]);
                break;
            } else {
                removeCardFromPlayers(deckCards[c1]);
            }
        }
    }

    private void addCardToPlayers(int deckCard) {
        for (int i = 0; i < playersCount; i++) {
            addCardToPlayer(i, deckCard);
        }
    }

    private void addCardToPlayer(int player, int card) {
        int number = card >> 2;
        int color = card & 3;

        playerMasks3[player] += (1L << (number * 3));

        playerColorMasks[player][color] |= (1 << number);

        if (++playerColorCount[player][color] == 5) {
            playerColors[player] = color;
        }
    }

    private void removeCardFromPlayer(int player, int card) {
        int number = card >> 2;
        int color = card & 3;

        playerMasks3[player] -= (1L << (number * 3));

        playerColorMasks[player][color] -= (1 << number);

        if (--playerColorCount[player][color] == 4) {
            playerColors[player] = -1;
        }

    }

    public int getPlayerResult(int i) {
        int result = 0;

        if (playerColors[i] != -1) {
            result = colorsTable[playerColorMasks[i][playerColors[i]]];
        }

        long tmp = playerMasks3[i] & 0b100100100100100100100100100100100100100L;
        int pokers = (int) ((tmp & 0b100100100100) + ((tmp >> 13) & 0b10010010010) + (tmp >> 26));

        tmp = (playerMasks3[i] & 0b10010010010010010010010010010010010010L) << 1;
        int pairs = (int) ((tmp & 0b100100100100) + ((tmp >> 13) & 0b10010010010) + (tmp >> 26));

        tmp = (playerMasks3[i] & 0b1001001001001001001001001001001001001L) << 2;
        int kickers = (int) ((tmp & 0b100100100100) + ((tmp >> 13) & 0b10010010010) + (tmp >> 26));

        if (pokers == 0) {
            // carta alta o escalera
            result = max(result, highCardsTable[kickers | pairs]);

            int threes = pairs & kickers;
            pairs -= threes;
            kickers -= threes;

            if (threes != 0) {
                // AAABBBC -> AAABBC
                pairs |= threes - highestOneTable[threes];
                threes = highestOneTable[threes];

                if (pairs != 0) {
                    // full house
                    result = max(result, FULL_HOUSE_MIN_VALUE + 13 * highCardsTable[threes] + highCardsTable[highestOneTable[pairs]]);

                } else if (result < STRAIGHT_MIN_VALUE) {
                    // trio
                    result = max(result, THREE_MIN_VALUE + 78 * highCardsTable[threes] + highCardsTable[kickers]);
                }

            } else if (pairs != 0 & result < STRAIGHT_MIN_VALUE) {
                if ((pairs & (pairs - 1)) != 0) {
                    // doble par

                    if ((kickers & (kickers - 1)) == 0) {
                        // solo hay un kicker, asi que hay 3 pares
                        // AABBCCD -> AABBCD
                        kickers += lowestOneTable[pairs];
                        pairs -= lowestOneTable[pairs];
                    }
                    result = max(result, TWO_PAIR_MIN_VALUE + 13 * highCardsTable[pairs] + highCardsTable[highestOneTable[kickers]]);
                } else {
                    result = max(result, PAIR_MIN_VALUE + 286 * highCardsTable[pairs] + highCardsTable[kickers]);
                }
            }

        } else {
            // poker
            result = max(result, POKER_MIN_VALUE + 13 * highCardsTable[pokers] + highCardsTable[highestOneTable[kickers | pairs]]);
        }

        return result;
    }

    private void removeCardFromPlayers(int deckCard) {
        for (int i = 0; i < playersCount; i++) {
            removeCardFromPlayer(i, deckCard);
        }
    }

    private int max(int x, int y) {
        //return Math.max(x, y);
        return x ^ ((x ^ y) & ((x - y) >> 31));
    }

    private long getFactorial(int n) {
        long result = n;
        while (--n >= 2) {
            result *= n;
        }
        return result;
    }

    private long getFactorialDivision(int n, int n2) {
        long result = n;
        while (--n > n2) {
            result *= n;
        }
        return result;
    }

    private void resetPlayer(int i) {
        playerMasks3[i] = 0;
        playerColorCount[i] = new int[4];
        playerColorMasks[i] = new int[4];
        playerColors[i] = -1;
    }

    private int[] getHighCardsTable() {
        int[] table = new int[8192];

        for (int c1 = 0; c1 < 13; c1++) {

            int mask1 = 0;
            mask1 |= 1 << c1;
            table[realToShiftedTable[mask1]] = c1;

            for (int c2 = c1 + 1; c2 < 13; c2++) {
                int mask2 = 0;
                mask2 |= 1 << c1;
                mask2 |= 1 << c2;
                table[realToShiftedTable[mask2]] = getLexicalOrder2(c2, c1);

                for (int c3 = c2 + 1; c3 < 13; c3++) {
                    int mask3_1 = 0;
                    mask3_1 |= 1 << c1;
                    mask3_1 |= 1 << c2;
                    mask3_1 |= 1 << c3;
                    table[realToShiftedTable[mask3_1]] = c3;

                    for (int c4 = c3 + 1; c4 < 13; c4++) {
                        int mask4_2 = 0;
                        mask4_2 |= 1 << c1;
                        mask4_2 |= 1 << c2;
                        mask4_2 |= 1 << c3;
                        mask4_2 |= 1 << c4;
                        table[realToShiftedTable[mask4_2]] = getLexicalOrder2(c4, c3);

                        for (int c5 = c4 + 1; c5 < 13; c5++) {

                            int mask5_3 = 0;
                            mask5_3 |= 1 << c1;
                            mask5_3 |= 1 << c2;
                            mask5_3 |= 1 << c3;
                            mask5_3 |= 1 << c4;
                            mask5_3 |= 1 << c5;
                            table[realToShiftedTable[mask5_3]] = getLexicalOrder3(c5, c4, c3);

                            for (int c6 = c5 + 1; c6 < 13; c6++) {
                                for (int c7 = c6 + 1; c7 < 13; c7++) {
                                    int mask7_5 = 0;
                                    mask7_5 |= 1 << c1;
                                    mask7_5 |= 1 << c2;
                                    mask7_5 |= 1 << c3;
                                    mask7_5 |= 1 << c4;
                                    mask7_5 |= 1 << c5;
                                    mask7_5 |= 1 << c6;
                                    mask7_5 |= 1 << c7;
                                    table[realToShiftedTable[mask7_5]] = getLexicalOrder5(c7, c6, c5, c4, c3);
                                }
                            }
                        }
                    }

                }
            }
        }

        for (int i = 3; i < 13; i++) {
            // escaleras, empezamos por 3 (5 / A2345) y terminamos por 12 (A / TKQJA)
            int mask = 0;
            mask |= (1 << ((i - 4 + 13) % 13));
            mask |= (1 << (i - 3));
            mask |= (1 << (i - 2));
            mask |= (1 << (i - 1));
            mask |= (1 << (i));

            for (int c6 = 0; c6 < 13; c6++) {
                // if ((mask & (1 << c6)) != 0) continue;

                for (int c7 = c6; c7 < 13; c7++) {
                    // if ((mask & (1 << c7)) != 0) continue;

                    int mask7 = mask | (1 << c7) | (1 << c6);
                    table[realToShiftedTable[mask7]] = STRAIGHT_MIN_VALUE + (i - 3);
                }
            }
        }

        return table;
    }

    private int getLexicalOrder5(int c5, int c4, int c3, int c2, int c1) {
        int result = 0;
        result += getFactorialDivision(c5, c5 - 5) / getFactorial(5);
        result += getFactorialDivision(c4, c4 - 4) / getFactorial(4);
        result += getFactorialDivision(c3, c3 - 3) / getFactorial(3);
        result += getFactorialDivision(c2, c2 - 2) / getFactorial(2);
        result += getFactorialDivision(c1, c1 - 1) / getFactorial(1);
        return result;
    }

    private int getLexicalOrder3(int c3, int c2, int c1) {
        int result = 0;
        result += getFactorialDivision(c3, c3 - 3) / getFactorial(3);
        result += getFactorialDivision(c2, c2 - 2) / getFactorial(2);
        result += getFactorialDivision(c1, c1 - 1) / getFactorial(1);
        return result;
    }

    private int getLexicalOrder2(int c2, int c1) {
        int result = 0;
        result += getFactorialDivision(c2, c2 - 2) / getFactorial(2);
        result += getFactorialDivision(c1, c1 - 1) / getFactorial(1);
        return result;
    }

    private int[] getRealMasksTable() {
        int[] realToShifted = new int[8192];
        for (int shiftedMask = 0; shiftedMask < 8192; shiftedMask++) {
            int realMask = 0;

            for (int i = 0; i < 13; i++) {
                int bitPos = (2 + i * 3) % 13;
                realMask |= ((shiftedMask >> bitPos) & 1) << i;
            }
            realToShifted[realMask] = shiftedMask;
        }
        return realToShifted;
    }

    private int[] getLowestOneTable() {
        int[] table = new int[8192];

        for (int c1 = 0; c1 < 13; c1++) {
            table[realToShiftedTable[1 << c1]] = realToShiftedTable[1 << c1];

            for (int c2 = c1 + 1; c2 < 13; c2++) {
                int mask2 = 0;
                mask2 |= 1 << c1;
                mask2 |= 1 << c2;
                table[realToShiftedTable[mask2]] = realToShiftedTable[1 << c1];

                for (int c3 = c2 + 1; c3 < 13; c3++) {
                    int mask3 = 0;
                    mask3 |= 1 << c1;
                    mask3 |= 1 << c2;
                    mask3 |= 1 << c3;

                    table[realToShiftedTable[mask3]] = realToShiftedTable[1 << c1];
                }
            }
        }
        return table;
    }

    private int[] getHighestOneTable() {
        int[] table = new int[8192];

        for (int c1 = 0; c1 < 13; c1++) {
            table[realToShiftedTable[1 << c1]] = realToShiftedTable[1 << c1];

            for (int c2 = c1 + 1; c2 < 13; c2++) {
                int mask2 = 0;
                mask2 |= 1 << c1;
                mask2 |= 1 << c2;
                table[realToShiftedTable[mask2]] = realToShiftedTable[1 << c2];

                for (int c3 = c2 + 1; c3 < 13; c3++) {
                    int mask3 = 0;
                    mask3 |= 1 << c1;
                    mask3 |= 1 << c2;
                    mask3 |= 1 << c3;

                    table[realToShiftedTable[mask3]] = realToShiftedTable[1 << c3];
                }
            }
        }
        return table;
    }

    private int[] getColorsTable() {
        int[] table = new int[8192];

        for (int c1 = 0; c1 < 13; c1++) {
            for (int c2 = c1 + 1; c2 < 13; c2++) {
                for (int c3 = c2 + 1; c3 < 13; c3++) {
                    for (int c4 = c3 + 1; c4 < 13; c4++) {
                        for (int c5 = c4 + 1; c5 < 13; c5++) {

                            int mask5 = 0;
                            mask5 |= 1 << c1;
                            mask5 |= 1 << c2;
                            mask5 |= 1 << c3;
                            mask5 |= 1 << c4;
                            mask5 |= 1 << c5;
                            table[mask5] = COLOR_MIN_VALUE + getLexicalOrder5(c5, c4, c3, c2, c1);

                            for (int c6 = c5 + 1; c6 < 13; c6++) {
                                int mask6_5 = 0;
                                mask6_5 |= 1 << c1;
                                mask6_5 |= 1 << c2;
                                mask6_5 |= 1 << c3;
                                mask6_5 |= 1 << c4;
                                mask6_5 |= 1 << c5;
                                mask6_5 |= 1 << c6;
                                table[mask6_5] = COLOR_MIN_VALUE + getLexicalOrder5(c6, c5, c4, c3, c2);

                                for (int c7 = c6 + 1; c7 < 13; c7++) {
                                    int mask7_5 = 0;
                                    mask7_5 |= 1 << c1;
                                    mask7_5 |= 1 << c2;
                                    mask7_5 |= 1 << c3;
                                    mask7_5 |= 1 << c4;
                                    mask7_5 |= 1 << c5;
                                    mask7_5 |= 1 << c6;
                                    mask7_5 |= 1 << c7;
                                    table[mask7_5] = COLOR_MIN_VALUE + getLexicalOrder5(c7, c6, c5, c4, c3);
                                }
                            }
                        }
                    }

                }
            }
        }

        for (int i = 3; i < 13; i++) {
            // escaleras, empezamos por 3 (5 / A2345) y terminamos por 12 (A / TKQJA)
            int mask = 0;
            mask |= (1 << ((i - 4 + 13) % 13));
            mask |= (1 << (i - 3));
            mask |= (1 << (i - 2));
            mask |= (1 << (i - 1));
            mask |= (1 << (i));

            for (int c6 = 0; c6 < 13; c6++) {
                // if ((mask & (1 << c6)) != 0) continue;

                for (int c7 = c6; c7 < 13; c7++) {
                    // if ((mask & (1 << c7)) != 0) continue;

                    int mask7 = mask | (1 << c7) | (1 << c6);
                    table[mask7] = STRAIGHT_FLUSH_MIN_VALUE + (i - 3);
                }
            }
        }

        return table;
    }

    double[] getPlayerTies() {
        return playerTies.clone();
    }

    void clear() {
        Arrays.fill(playerWins, 0);
        Arrays.fill(playerTies, 0);
        totalHands = 0;
    }

}
