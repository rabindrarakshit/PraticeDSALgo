package com.algorithm.practice.recursion;

public class RemoveDuplicatesInAString {
    static boolean[] arr = new boolean[26];

    public static void main(String[] args) {
        System.out.println(remove(new StringBuilder(), "axbxc", 0));
        for (int i = 0; i < arr.length; i++) {
            arr[i] = false;
        }
    }

    public static String remove(StringBuilder result, String input, int index) {
        if (index == input.length()) {
            return result.toString();
        }
       /* if(result.indexOf(String.valueOf(input.charAt(index)))==-1){
            result.append(input.charAt(index));
        }*/
        if (arr[input.charAt(index) - 'a']) {
            return remove(result, input, index + 1);
        } else{
            arr[input.charAt(index) - 'a'] = true;
            return remove(result.append(input.charAt(index)), input, index + 1);
        }
    }
}
