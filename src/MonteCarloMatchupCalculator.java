/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3poker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;
import javax.swing.JButton;

/**
 *
 * @author usuario_local
 */
public class MonteCarloMatchupCalculator extends Thread implements MatchupCalculator {

    private int playersCount;
    private boolean[] usedCards;
    private int[][][] playerPairs;
    private int[] playerOffsets;
    private int matchupCount;
    private Matchup[] matchups;

    private ArrayList<Matchup> matchupsList;
    
    private int[] tableCards;
    private int[] randomTableCards;
    
    private int[] deadCards;
    private double[] playerEquities;
    private String out;

    private MatchupCalculatorThread[] threads;
    private String[] ranges;
    private String tableCardsStr;
    private String deadCardsStr;
    private RankingParser rankingParser;
    private JButton stopButton = null;
    private final MatchupEventListener listener;

    private long totalHands;
    private long[] playerWins;
    private double[] playerTies;
    private boolean stop = false;

    public MonteCarloMatchupCalculator(String[] ranges, String tableCardsStr, String deadCardsStr, RankingParser rankingParser, MatchupEventListener listener) throws Exception {
        this.ranges = ranges;
        this.tableCardsStr = tableCardsStr.replace(",", "");
        this.deadCardsStr = deadCardsStr.replace(",", "");
        this.rankingParser = rankingParser;

        int cores = Runtime.getRuntime().availableProcessors();
        threads = new MatchupCalculatorThread[cores];

        this.listener = listener;
    }

    public void run() {
        try {
            playersCount = ranges.length;
            usedCards = new boolean[52];
            playerOffsets = new int[playersCount];
            playerPairs = new int[playersCount][][];
            matchupsList = new ArrayList<>();

            playerEquities = new double[playersCount];
            playerWins = new long[playersCount];
            playerTies = new double[playersCount];

            tableCardsStr = tableCardsStr.trim();
            tableCards = new int[tableCardsStr.length() / 2];
            randomTableCards = new int[5];

            for (int i = 0; i < tableCards.length; i++) {
                tableCards[i] = Poker.cardIndex(tableCardsStr.substring(i * 2, i * 2 + 2));
                randomTableCards[i] = tableCards[i];
            }

            deadCardsStr = deadCardsStr.trim();
            deadCards = new int[deadCardsStr.length() / 2];

            for (int i = 0; i < deadCards.length; i++) {
                deadCards[i] = Poker.cardIndex(deadCardsStr.substring(i * 2, i * 2 + 2));
            }

            // Cogemos las tablas para los rangos de cada jugador
            // y los convertimos a pares de cartas
            // Es decir, para cada jugador ahora tenemos {(50,52),(48,45),...}
            for (int i = 0; i < playersCount; i++) {
                RangeParser rp = new RangeParser(rankingParser);
                rp.setRange(ranges[i]);
                boolean[][] table = rp.getFullTable();
                playerPairs[i] = tableToPairs(table);
            }

            PokerCalculator pc = new PokerCalculator(playersCount);

            int[][] playerHands = new int[playersCount][2];

            (new Thread() {
                public void run() {
                    int pos = 0;

                    long startTime = System.currentTimeMillis();

                    while (!stop) {
                        randomSelect();
                        if (isValidMatchup()) {
                            for (int i = 0; i < playersCount; i++) {
                                playerHands[i] = playerPairs[i][playerOffsets[i]];
                            }
                            pc.setCards(playerHands, randomTableCards, deadCards, false);
                            try {
                                pc.calculate();
                            } catch (Exception ex) {
                                Logger.getLogger(MonteCarloMatchupCalculator.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            if (pos++ % 1000 == 0) {
                                totalHands += pc.getTotalHands();
                                long[] newPlayerWins = pc.getPlayerWins();
                                double[] newPlayerTies = pc.getPlayerTies();
                                
                                for (int i=0; i<playersCount; i++) {
                                    playerWins[i] += newPlayerWins[i];
                                    playerTies[i] += newPlayerTies[i];
                                }

                                updateResults();
                                listener.matchupFinished(1000);
                                
                                pc.clear();
                            }
                        }
                    }

                    long endTime = System.currentTimeMillis();
                    long elapsedTime = (endTime - startTime);
                    double perSecond = 1000.0 * totalHands / elapsedTime;

                    out = "";
                    out += String.format("%,d juegos en %,.3f secs (%,.0f juegos/s)\n", totalHands, elapsedTime / 1000.0, perSecond);
                    out += "\n";
                    out += "Mesa: " + tableCardsStr + "\n";
                    out += "Muertas: " + deadCardsStr + "\n";
                    out += "\n";

                    for (int i = 0; i < playersCount; i++) {

                        double winEquity = 100.0 * playerWins[i] / totalHands;
                        double tieEquity = 100.0 * playerTies[i] / totalHands;
                        double equity = winEquity + tieEquity;

                        playerEquities[i] = equity;

                        out += String.format("Jugador %d: %,.3f%%, %,.2f%% victoria, %,.2f%% empate, %,d victorias, %,.2f empates {%s} \n",
                                i + 1,
                                equity,
                                winEquity,
                                tieEquity,
                                playerWins[i],
                                playerTies[i],
                                ranges[i]
                        );
                    }
                    listener.allMatchupsFinished();
                }
            }).start();

        } catch (Exception ex) {
            Logger.getLogger(MonteCarloMatchupCalculator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public double[] getPlayerEquities() {
        return playerEquities.clone();
    }

    public String getOutput() {
        return out;
    }

    public void stopThreads() {
        stop = true;
    }

    private int[][] tableToPairs(boolean[][] table) {
        ArrayList< Pair<Integer, Integer>> pairs = new ArrayList<>();
        for (int card1 = 0; card1 < 52; card1++) {
            for (int card2 = card1 + 1; card2 < 52; card2++) {
                if (table[card1][card2]) {
                    pairs.add(new Pair<>(card1, card2));
                }
            }
        }

        int[][] arr = new int[pairs.size()][2];
        for (int i = 0; i < arr.length; i++) {
            Pair<Integer, Integer> pair = pairs.get(i);
            arr[i][0] = pair.getKey();
            arr[i][1] = pair.getValue();
        }

        return arr;
    }

    private boolean isValidMatchup() {
        for (int i = 0; i < 52; i++) {
            usedCards[i] = false;
        }

        for (int i = 0; i < deadCards.length; i++) {
            usedCards[deadCards[i]] = true;
        }

        for (int i = 0; i < playersCount; i++) {
            if (playerOffsets[i] >= playerPairs[i].length) {
                return false;
            }

            int card1 = playerPairs[i][playerOffsets[i]][0];
            int card2 = playerPairs[i][playerOffsets[i]][1];

            if (usedCards[card1] || usedCards[card2]) {
                return false;
            }

            usedCards[card1] = true;
            usedCards[card2] = true;
        }

        for (int i = 0; i < 5; i++) {
            int card = randomTableCards[i];

            if (usedCards[card]) {
                return false;
            }

            usedCards[card] = true;
        }

        return true;
    }

    public double getMatchupsCount() {
        return -1;
    }

    private void updateResults() {
        for (int j = 0; j < playersCount; j++) {
            playerEquities[j] = 100.0 * (playerWins[j] + playerTies[j]) / totalHands;
        }
    }

    private void randomSelect() {
        for (int i = 0; i < playersCount; i++) {
            playerOffsets[i] = (int) Math.floor(Math.random() * playerPairs[i].length);
        }
        for (int i=tableCards.length; i<5; i++) {
            randomTableCards[i] = (int) Math.floor(Math.random()*52);
        }
    }
}
