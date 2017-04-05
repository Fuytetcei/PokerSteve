/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practica3poker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author usuario_local
 */
public class FileRankingParser implements RankingParser {
    
    private String[] ranking;
    private String name;
    
    public FileRankingParser(String filename, String name) throws IOException {
        this.name = name;
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        
        String line;
        int pos = 0;
        
        ranking = new String[Poker.HANDS_COUNT];
        
        while((line = br.readLine()) != null) {
            ranking[pos++] = line;
        }
        
        br.close();
        fr.close();
    }
    
    public String getPercentage(double percentage) {
        StringBuilder result = new StringBuilder();
        
        double remaining = Poker.TOTAL_SIZE / 100.0 * percentage;
        
        for (int i=0; i<Poker.HANDS_COUNT; i++) {
            
            if (ranking[i].length() == 2) {
                remaining -= 6;
            }
            else if (ranking[i].charAt(2) == 's') {
                remaining -= 4;
            }
            else {
                remaining -= 12;
            }
            
            if (remaining < 0) break;
            if (i != 0) result.append(',');
            result.append(ranking[i]);
        }
        
        return result.toString();
    }
    
    
    @Override
    public String toString() {
        return name;
    }
    
}
