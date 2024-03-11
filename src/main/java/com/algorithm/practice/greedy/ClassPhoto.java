package com.algorithm.practice.greedy;

import java.util.ArrayList;
import java.util.Collections;

// Ref: https://www.algoexpert.io/questions/class-photos
// Time: O(nlogn) | O(1)
public class ClassPhoto {
    public boolean classPhotos(
            ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights
    ) {
        Collections.sort(redShirtHeights);
        Collections.sort(blueShirtHeights);

        String firstRow = redShirtHeights.get(0)<blueShirtHeights.get(0)? "RED" : "BLUE";

        for(int i=0;i<redShirtHeights.size();i++){
            if(firstRow.equals("RED")){
                if(redShirtHeights.get(i)>=blueShirtHeights.get(i)){
                    return false;
                }
            }else{
                if(blueShirtHeights.get(i)>=redShirtHeights.get(i)){
                    return false;
                }
            }
        }
        return true;
    }
}
