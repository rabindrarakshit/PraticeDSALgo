package com.algorithm.practice.recursion;

public class MoveAllOccurrenceOfALiteralToLast {
    public static void main(String[] args) {
        System.out.println(move(new StringBuilder("axbxc"), 0, 'x', 1));
    }

    public static StringBuilder move(StringBuilder sb, int idx, char c, int depth){
        if(depth == sb.length()){
            return sb;
        }
        if(sb.charAt(idx)==c){
            sb.deleteCharAt(idx);
            sb.append(c);
            return move(sb, idx, c, depth+1);
        }
        return move(sb, idx+1, c, depth);
    }
}
