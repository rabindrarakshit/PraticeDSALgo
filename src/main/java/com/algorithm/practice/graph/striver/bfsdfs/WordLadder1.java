package com.algorithm.practice.graph.striver.bfsdfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

// Ref: https://takeuforward.org/graph/word-ladder-i-g-29/
// Time Complexity: O(N * M * 26)
// Space: O( N )

public class WordLadder1 {
    static class Pair {
        String text;
        int steps;

        Pair(String text, int steps) {
            this.text = text;
            this.steps = steps;
        }
    }

    static int getSteps(List<String> list, String startWord, String targetWord) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(startWord, 1));
        Set<String> set = new HashSet<>();
        for (String s : list) {
            set.add(s);
        }
        set.remove(startWord);

        while (!q.isEmpty()) {
            Pair p = q.poll();
            String current = p.text;
            int steps = p.steps;

            if (current.equals(targetWord)) {
                return steps;
            }

            for (int i = 0; i < current.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] replaced = current.toCharArray();
                    replaced[i] = ch;
                    String replacedString = new String(replaced);
                    if (set.contains(replacedString)) {
                        set.remove(replaced);
                        q.add(new Pair(replacedString, steps + 1));
                    }
                }
            }
        }
        return 0;
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
        List<String> list = List.of(wordList);
        int ans = getSteps(list, startWord, targetWord);

        System.out.print(ans);

        System.out.println();
    }
}
