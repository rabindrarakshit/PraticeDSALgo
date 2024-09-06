package com.algorithm.practice.arrays.easy;

/*
* Two input Arrays: competitions, results
* competitions : Matches ex: [["HTML","C#"],["C#","Python"],["Python","HTML"]] : Format : [Home, Away]
* results : Winners [0,0,1]
* Here in results 0 means Away Team won, 1 means Home Team won
* Winning team receives 3 point, and losing team 0.
* Find the winner
* */

import java.util.HashMap;
import java.util.Map;

public class TournamentWinner {
    String findWinner(Integer[] results, String[][] competitions){
        Map<String, Integer> pointsBoard = new HashMap<>();
        for(int i=0;i<results.length;i++){
            if(results[i]==0){
                pointsBoard.put(competitions[i][1],pointsBoard.getOrDefault(competitions[i][1],0)+3);
            }else{
                pointsBoard.put(competitions[i][0],pointsBoard.getOrDefault(competitions[i][0],0)+3);
            }
        }
        int max=0;
        String winner = null;
        for(Map.Entry<String, Integer> entry :pointsBoard.entrySet()){
            if(entry.getValue()>max){
                max = entry.getValue();
                winner = entry.getKey();
            }
        }
        return winner;
    }
}
