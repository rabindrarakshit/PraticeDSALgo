package com.algorithm.practice.greedy;

// Ref: https://www.algoexpert.io/questions/valid-starting-city

public class StartingCity {
    static int validStartingCity(int[] distances, int[] fuel, int mpg) {
        int fuelLeft = 0;
        int minIndex = 0;
        int minFuel = 0;
        for(int i=0;i<distances.length;i++){
            fuelLeft += (fuel[i]*mpg)-distances[i];
           if(fuelLeft<minFuel){
               minFuel = fuelLeft;
               minIndex = i+1;
           }
       }
        return minIndex;
    }

    public static void main(String[] args) {
        validStartingCity(new int[]{5,25,15,10,15}, new int[]{1,2,1,0,3}, 10);
    }
}
