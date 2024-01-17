package com.algorithm.practice.string.easy;

// Ref: https://leetcode.com/problems/remove-outermost-parentheses/
// Input: s = "()()"
// Output: ""

// Input: s = "(()())(())(()(()))"
// Output: "()()()()(())"

// Time Complexity: O(n)
// Space Complexity: O(1)

public class RemoveOutermostParenthesis {
    static StringBuilder removeOutermostParenthesis(String str){
        StringBuilder s = new StringBuilder();
        int openCount = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='(' && openCount++>0){
                s.append(str.charAt(i));
            }
            if(str.charAt(i)==')' && openCount-->1){
                s.append(str.charAt(i));
            }
        }
        return s;
    }

    public static void main(String[] args) {
        String str1 ="()()()";
        String str2 = "(())";
        System.out.println(removeOutermostParenthesis(str1));
        System.out.println(removeOutermostParenthesis(str2));
    }
}
