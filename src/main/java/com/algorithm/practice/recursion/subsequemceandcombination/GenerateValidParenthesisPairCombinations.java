package com.algorithm.practice.recursion.subsequemceandcombination;

import java.util.ArrayList;
import java.util.List;

public class GenerateValidParenthesisPairCombinations {
    static List<String> generate(String str, int max, List<String> list, int open, int close) {
        if (str.length() == max * 2) {
            list.add(str);
            return list;
        }
        if (open < max) {
            generate(str + "(", max, list, open + 1, close);
        }
        if (close < open) {
            generate(str + ")", max, list, open, close + 1);
        }
        return list;
    }

    public static void main(String[] args) {
        generate("", 3, new ArrayList<>(), 0, 0).forEach(ch -> System.out.println(ch));
    }
}
