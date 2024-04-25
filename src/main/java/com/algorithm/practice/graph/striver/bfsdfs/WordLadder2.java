package com.algorithm.practice.graph.striver.bfsdfs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder2 {
    static ArrayList<ArrayList<String>> getPaths(ArrayList<String> list, String startString, String targetString) {
        Queue<ArrayList<String>> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        ArrayList<String> stringsOnPrevLevel = new ArrayList<>();
        ArrayList<ArrayList<String>> paths = new ArrayList<>();
        int level = 0;

        for (String s : list) {
            set.add(s);
        }
        ArrayList<String> intialString = new ArrayList<>();
        intialString.add(startString);
        q.add(intialString);
        stringsOnPrevLevel.add(startString);

        while (!q.isEmpty()) {
            ArrayList<String> current = q.poll();
            if (current.size() > level) {
                level++;
                for (String it : stringsOnPrevLevel) {
                    set.remove(it);
                }
            }
            String lastText = current.get(current.size() - 1);
            if (lastText.equals(targetString)) {
                if (paths.isEmpty()) {
                    paths.add(current);
                } else {
                    if (paths.get(0).size() == current.size()) {
                        paths.add(current);
                    }
                }
            }
            for (int i = 0; i < lastText.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] lastTextArray = lastText.toCharArray();
                    lastTextArray[i] = ch;
                    String textToCheck = new String(lastTextArray);
                    if (set.contains(textToCheck)) {
                        current.add(textToCheck);
                        ArrayList<String> temp = new ArrayList<>(current);
                        q.add(temp);
                        stringsOnPrevLevel.add(textToCheck);
                        current.remove(current.size() - 1);
                    }
                }
            }
        }
        return paths;
    }

    public static void main(String[] args) {
        String startWord = "der", targetWord = "dfs";
        String[] wordList = {
                "des",
                "der",
                "dfr",
                "dgt",
                "dfs"
        };
        ArrayList<String> input = new ArrayList<>();
        input.addAll(List.of(wordList));
        ArrayList<ArrayList<String>> ans = getPaths(input, startWord, targetWord);

        // If no transformation sequence is possible.
        if (ans.size() == 0)
            System.out.println(-1);
        else {

            //Collections.sort(ans, new comp());
            for (int i = 0; i < ans.size(); i++) {
                for (int j = 0; j < ans.get(i).size(); j++) {
                    System.out.print(ans.get(i).get(j) + " ");
                }
                System.out.println();
            }
        }
    }

    // A comparator function to sort the answer.
    static class comp implements Comparator<ArrayList<String>> {

        public int compare(ArrayList<String> a, ArrayList<String> b) {
            String x = "";
            String y = "";
            for (int i = 0; i < a.size(); i++)
                x += a.get(i);
            for (int i = 0; i < b.size(); i++)
                y += b.get(i);
            return x.compareTo(y);
        }
    }
}
