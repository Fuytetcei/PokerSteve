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
public interface MatchupCalculator {

    public void stopThreads();

    public void start();

    public double[] getPlayerEquities();

    public String getOutput();

    public double getMatchupsCount();
    
}
