package com.algorithm.practice.dynamicprogramming;

//Ref: https://www.algoexpert.io/questions/levenshtein-distance

public class LevenshteinDistance {
    // Time: O(nm) | Space: O(nm)
    static int noOfEdits(String str1, String str2) {
        int[][] edits = new int[str2.length() + 1][str1.length() + 1];
        for (int i = 0; i <= str1.length(); i++) {
            edits[0][i] = i;
        }
        for (int i = 0; i <= str2.length(); i++) {
            edits[i][0] = i;
        }
        for (int i = 1; i <= str2.length(); i++) {
            for (int j = 1; j <= str1.length(); j++) {
                if (str2.charAt(i - 1) == str1.charAt(j - 1)) {
                    edits[i][j] = edits[i - 1][j - 1];
                } else {
                    edits[i][j] = 1 + Math.min(edits[i - 1][j - 1], Math.min(edits[i - 1][j], edits[i][j - 1]));
                }
            }
        }
        return edits[str2.length()][str1.length()];
    }

    static int noOfEditsMemoryOptimized(String str1, String str2) {
        String big = str1.length() >= str2.length() ? str1 : str2;
        String small = str1.length() < str2.length() ? str1 : str2;
        int[] odd = new int[small.length() + 1];
        int[] even = new int[small.length() + 1];
        int[] previous;
        int[] current;

        for (int i = 0; i <= small.length(); i++) {
            even[i] = i;
        }

        for (int i = 1; i <= big.length(); i++) {
            if (i % 2 == 1) {
                previous = even;
                current = odd;
            }else{
                previous = odd;
                current = even;
            }
            current[0] = i;
            for(int j=1;j<=small.length();j++){
                if(big.charAt(i-1)==small.charAt(j-1)){
                    current[j] = previous[j-1];
                }else{
                    current[j] = 1+Math.min(current[j-1], Math.min(previous[j], previous[j-1]));
                }
            }
        }
        return big.length()%2==1? odd[small.length()]: even[small.length()];
    }

    public static void main(String[] args) {
        System.out.println(noOfEditsMemoryOptimized("biting", "mitten"));
      //  System.out.println(noOfEdits("biting", "mitten"));
    }
}
