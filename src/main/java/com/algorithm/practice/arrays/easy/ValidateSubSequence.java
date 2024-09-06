package com.algorithm.practice.arrays.easy;

public class ValidateSubSequence{
    boolean validateSubSequence(String input, String subSequence){
        int input_idx=0, subsq_idx=0;
        while(input_idx<input.length() && subsq_idx<subSequence.length()){
            if(input.charAt(input_idx)==subSequence.charAt(subsq_idx))
                subsq_idx++;
            input_idx++;
        }
        return subsq_idx==subSequence.length();

    }
}
