/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3poker;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jakub
 */
public class MatchupCalculatorThread extends Thread {

    private final PokerCalculator pc;
    private final int first;
    private final int last;
    private final Matchup[] matchups;
    
    private final long[] playerWins;
    private final double[] playerTies;
    private long totalHands;
    private final int playersCount;
    private boolean mustStop;
    private final MatchupEventListener listener;
    private EnumerateMatchupCalculator mc;

    public MatchupCalculatorThread(Matchup[] matchups, int first, int last, MatchupEventListener listener, EnumerateMatchupCalculator mc) throws Exception {
        pc = new PokerCalculator(matchups[0].playerHands.length);
        this.mc = mc;
        this.first = first;
        this.last = last;
        this.matchups = matchups;
        
        playersCount = matchups[0].playerHands.length;
        this.playerTies = new double[playersCount];
        this.playerWins = new long[playersCount];
        this.listener = listener;
        
        mustStop = false;
    }

    @Override
    public void run() {
        try {
            for (int i = first; i <= last && !mustStop; i++) {
                Matchup mp = matchups[i];
                pc.setCards(mp.playerHands, mp.tableCards, mp.deadCards, true);
                pc.calculate();
                
                final int step = 10;
                
                if (i % step == (first+step-1) % step) {
                    System.out.println(i + " / " + (last+1));
                    
                    mc.updateResults();
                    listener.matchupFinished(step);
                }
                totalHands += pc.getTotalHands();
                
                for (int j=0; j<playersCount; j++) {
                    playerWins[j] += pc.getPlayerWins()[j];
                    playerTies[j] += pc.getPlayerTies()[j];
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(1002);
        }
    }
    
    
    double[] getPlayerTies() {
        return playerTies.clone();
    }
    
    public long[] getPlayerWins() {
        return playerWins.clone();
    }

    public long getTotalHands() {
        return totalHands;
    }
    
    public void stopThread() {
        mustStop = true;
    }
}
