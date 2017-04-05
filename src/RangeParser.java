/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3poker;

import java.util.ArrayList;

/**
 *
 * @author usuario_local
 */
public class RangeParser {

    private boolean[][] table;
    private boolean[][] fullTable;
    private String[] results;
    private ArrayList<String> individuals;
    private RankingParser rankingParser = null;

    public RangeParser(RankingParser rankingParser) {
        table = new boolean[13][13];
        fullTable = new boolean[52][52];

        // 0 - pares
        // 1-As, 2-Ao, 3-Ks, 4-Ko
        results = new String[27];

        individuals = new ArrayList<>();
        this.rankingParser = rankingParser;
    }

    public int[] getNumbers(String str) {
        int[] result = new int[2];
        result[0] = Poker.letterNumber(str.charAt(0));
        result[1] = Poker.letterNumber(str.charAt(1));

        if (result[0] < result[1]) {
            int tmp = result[0];
            result[0] = result[1];
            result[1] = tmp;
        }

        return result;
    }

    public double getPercentage() {
        int size = 0;

        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 13; j++) {
                if (table[i][j]) {
                    if (i == j) {
                        size += 6;
                    } else if (i < j) {
                        size += 4;
                    } else {
                        size += 12;
                    }
                }
            }
        }

        return size * 100.0 / Poker.TOTAL_SIZE;
    }

    public void setRange(String range) {
        individuals.clear();

        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 13; j++) {
                table[i][j] = false;
            }
        }
        for (int i = 0; i < 52; i++) {
            for (int j = 0; j < 52; j++) {
                fullTable[i][j] = false;
            }
        }

        if (range.length() >= 1 && range.charAt(0) == '(') {
            // rango polarizado
            String[] parts = range.substring(1, range.length()-1).split(",");
            try {
                double start1 = Double.parseDouble(parts[0]);
                double end1 = start1 + Double.parseDouble(parts[1]);
                double start2 = end1 + Double.parseDouble(parts[2]);
                double end2 = start2 + Double.parseDouble(parts[3]);
                
                sumRange(rankingParser.getPercentage(end2));
                subRange(rankingParser.getPercentage(start2));
                sumRange(rankingParser.getPercentage(end1));
                subRange(rankingParser.getPercentage(start1));
            }
            catch (Exception ex) { }
        } else {

            String[] parts = range.split(",");

            for (int i = 0; i < parts.length; i++) {
                parts[i] = parts[i].trim();
                if (parts[i].length() == 0) {
                    continue;
                }

                if (parts[i].equalsIgnoreCase("random")) {
                    for (int x = 0; x < 13; x++) {
                        for (int y = 0; y < 13; y++) {
                            if (Math.random() >= 0.5) {
                                table[x][y] = true;
                            }
                        }
                    }
                    continue;
                }

                String minText;
                boolean isSuited = false;
                int[] minNumbers, maxNumbers;

                if (parts[i].length() >= 5 && parts[i].indexOf("-") >= 2) {
                    // intervalo (xx-yy)
                    String[] intervalParts = parts[i].split("-");
                    minText = intervalParts[1];
                    minNumbers = getNumbers(minText);
                    maxNumbers = getNumbers(intervalParts[0]);
                } else if (parts[i].length() == 4 && parts[i].charAt(3) != '+') {
                    // combinacion unica (AhAs)
                    individuals.add(parts[i]);
                    continue;
                } else if (parts[i].length() >= 3 && parts[i].charAt(parts[i].length() - 1) == '+') {
                    // intervalo (xx+)
                    minText = parts[i].substring(0, parts[i].length() - 1);
                    minNumbers = getNumbers(minText);
                    maxNumbers = minNumbers.clone();

                    if (maxNumbers[0] == maxNumbers[1]) {
                        maxNumbers[0] = 12;
                        maxNumbers[1] = 12;
                    } else {
                        maxNumbers[1] = maxNumbers[0] - 1;
                    }

                } else {
                    minText = parts[i];
                    minNumbers = getNumbers(minText);
                    maxNumbers = minNumbers.clone();
                }

                if (minText.length() == 3 && minText.charAt(2) == 's') {
                    isSuited = true;
                }

                while (minNumbers[1] <= maxNumbers[1]) {

                    if (minNumbers[0] == minNumbers[1]) {
                        // pareja
                        table[minNumbers[0]][minNumbers[1]] = true;
                        minNumbers[0]++;
                        minNumbers[1]++;
                    } else {
                        if (isSuited) {
                            // suited
                            table[minNumbers[1]][minNumbers[0]] = true;
                        } else {
                            // offsuit
                            table[minNumbers[0]][minNumbers[1]] = true;
                        }
                        minNumbers[1]++;
                    }
                }
            }
        }

        calculateAll();
    }

    public void setTable(boolean[][] newTable) {
        for (int x = 0; x < 13; x++) {
            System.arraycopy(newTable[x], 0, table[x], 0, 13);
        }
        calculateAll();
    }

    public boolean[][] getTable() {
        boolean[][] newTable = new boolean[13][13];
        for (int x = 0; x < 13; x++) {
            System.arraycopy(table[x], 0, newTable[x], 0, 13);
        }
        return newTable;
    }

    public boolean[][] getFullTable() {
        boolean[][] newTable = new boolean[52][52];
        for (int x = 0; x < 52; x++) {
            System.arraycopy(fullTable[x], 0, newTable[x], 0, 52);
        }
        return newTable;
    }

    public void calculateSuited(int n) {
        StringBuilder sb = new StringBuilder();

        int max = -1, min = -1;
        boolean active = false;

        for (int i = n - 1; i >= -1; i--) {

            if (i == -1 || table[i][n] == false) {
                // no cogido
                if (active) {
                    if (sb.length() != 0) {
                        sb.append(',');
                    }

                    if (max == n - 1) {
                        sb.append(Poker.numberLetter[n]);
                        sb.append(Poker.numberLetter[min]);
                        sb.append("s+");
                    } else if (max != min) {
                        sb.append(Poker.numberLetter[n]);
                        sb.append(Poker.numberLetter[max]);
                        sb.append('s');
                        sb.append('-');
                        sb.append(Poker.numberLetter[n]);
                        sb.append(Poker.numberLetter[min]);
                        sb.append('s');
                    } else {
                        sb.append(Poker.numberLetter[n]);
                        sb.append(Poker.numberLetter[min]);
                        sb.append('s');
                    }
                    active = false;
                }
            } else {

                for (int color1 = 0; color1 < 4; color1++) {
                    int card1 = Poker.cardIndex(i, color1);
                    int card2 = Poker.cardIndex(n, color1);
                    fullTable[card1][card2] = true;
                    fullTable[card2][card1] = true;
                }

                if (!active) {
                    max = i;
                    active = true;
                }
                min = i;
            }

        }
        results[1 + 2 * (12 - n)] = sb.toString();

    }

    public void calculateOffsuit(int n) {
        StringBuilder sb = new StringBuilder();

        int max = -1, min = -1;
        boolean active = false;

        for (int i = n - 1; i >= -1; i--) {

            if (i == -1 || table[n][i] == false) {
                // no cogido
                if (active) {
                    if (sb.length() != 0) {
                        sb.append(',');
                    }

                    if (max == n - 1) {
                        sb.append(Poker.numberLetter[n]);
                        sb.append(Poker.numberLetter[min]);
                        sb.append("o+");
                    } else if (max != min) {
                        sb.append(Poker.numberLetter[n]);
                        sb.append(Poker.numberLetter[max]);
                        sb.append('o');
                        sb.append('-');
                        sb.append(Poker.numberLetter[n]);
                        sb.append(Poker.numberLetter[min]);
                        sb.append('o');
                    } else {
                        sb.append(Poker.numberLetter[n]);
                        sb.append(Poker.numberLetter[min]);
                        sb.append('o');
                    }
                    active = false;
                }
            } else {

                for (int color1 = 0; color1 < 3; color1++) {
                    for (int color2 = color1 + 1; color2 < 4; color2++) {
                        int card1 = Poker.cardIndex(i, color1);
                        int card2 = Poker.cardIndex(n, color2);
                        fullTable[card1][card2] = true;
                        fullTable[card2][card1] = true;

                        card1 = Poker.cardIndex(i, color2);
                        card2 = Poker.cardIndex(n, color1);
                        fullTable[card1][card2] = true;
                        fullTable[card2][card1] = true;
                    }
                }

                if (!active) {
                    max = i;
                    active = true;
                }
                min = i;
            }

        }
        results[2 + 2 * (12 - n)] = sb.toString();

    }

    public void calculatePairs() {
        StringBuilder sb = new StringBuilder();

        int max = -1, min = -1;
        boolean active = false;

        for (int i = 12; i >= -1; i--) {

            if (i == -1 || table[i][i] == false) {
                // no cogido
                if (active) {
                    if (sb.length() != 0) {
                        sb.append(',');
                    }

                    if (max == 12) {
                        sb.append(Poker.numberLetter[min]);
                        sb.append(Poker.numberLetter[min]);
                        sb.append('+');
                    } else if (max != min) {
                        sb.append(Poker.numberLetter[max]);
                        sb.append(Poker.numberLetter[max]);
                        sb.append('-');
                        sb.append(Poker.numberLetter[min]);
                        sb.append(Poker.numberLetter[min]);
                    } else {
                        sb.append(Poker.numberLetter[min]);
                        sb.append(Poker.numberLetter[min]);
                    }
                    active = false;
                }
            } else {

                for (int color1 = 0; color1 < 3; color1++) {
                    for (int color2 = color1 + 1; color2 < 4; color2++) {
                        int card1 = Poker.cardIndex(i, color1);
                        int card2 = Poker.cardIndex(i, color2);
                        fullTable[card1][card2] = true;
                        fullTable[card2][card1] = true;
                    }
                }

                if (!active) {
                    max = i;
                    active = true;
                }
                min = i;
            }

        }

        results[0] = sb.toString();
    }

    public void calculateAll() {
        calculatePairs();
        for (int i = 1; i <= 12; i++) {
            calculateSuited(i);
            calculateOffsuit(i);
        }

        for (String part : individuals) {
            if (part.length() >= 1) {
                int card1 = Poker.cardIndex(part.substring(0, 2));
                int card2 = Poker.cardIndex(part.substring(2, 4));
                fullTable[card1][card2] = true;
                fullTable[card2][card1] = true;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        boolean started = false;

        for (int i = 0; i < 27; i++) {
            if (results[i] != null && results[i].length() != 0) {
                if (started) {
                    result.append(',');
                }
                result.append(results[i]);
                started = true;
            }
        }

        return result.toString();
    }

    private void sumRange(String range) {
        RangeParser rp = new RangeParser(rankingParser);
        rp.setRange(range);
        boolean[][] otherTable = rp.getTable();
        
        for (int x=0; x<otherTable.length; x++) {
            for (int y=0; y<otherTable.length; y++) {
                table[x][y] = table[x][y] || otherTable[x][y];
            }
        }
    }

    private void subRange(String range) {
        RangeParser rp = new RangeParser(rankingParser);
        rp.setRange(range);
        boolean[][] otherTable = rp.getTable();
        
        for (int x=0; x<otherTable.length; x++) {
            for (int y=0; y<otherTable.length; y++) {
                table[x][y] = table[x][y] && (!otherTable[x][y]);
            }
        }
    }

    void setRankingParser(RankingParser newRankingParser) {
        rankingParser = newRankingParser;
    }

}
