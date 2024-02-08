package com.algorithm.practice.stack;

import java.util.Stack;

public class CheckForBalancedParenthesis {

    // This is good for a single type of brace
    static boolean check(String str){
        Stack<Character> s = new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch=='('){
                s.push(ch);
            }else{
                if(s.isEmpty()) return false;
                s.pop();
            }
        }
       return s.isEmpty();
    }

    // This is for mixed braces
    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        for (char it : s.toCharArray()) {
            if (it == '(' || it == '[' || it == '{')
                st.push(it);
            else {
                if(st.isEmpty()) return false;
                char ch = st.pop();
                if((it == ')' && ch == '(') ||  (it == ']' && ch == '[') || (it == '}' && ch == '{')) continue;
                else return false;
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(check("()()"));
        System.out.println(check("(((()"));
    }
}
