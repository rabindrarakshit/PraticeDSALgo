package com.algorithm.practice.arrays.medium;

public class StringCompression {
    public static void stringCompression(String input){
        int count =1;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<input.length(); i++){
            if((i==input.length()-1)&& count==1){
                sb.append(input.charAt(i));
                sb.append(count);
                break;
            }
            if(input.charAt(i)==input.charAt(i+1))
                count++;
            else{
                sb.append(input.charAt(i));
                sb.append(count);
                count=1;
            }
        }
        if (sb.length() < input.length())
            System.out.println(sb.toString());
        else {
            System.out.println(input);
        }
    }

    public static void main(String[] args) {
        stringCompression("aaabbc");
    }
}
