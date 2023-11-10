package com.algorithm.practice.directory;

import org.apache.commons.lang3.StringUtils;

public class Backbase {
    public static void main(String[] args) {
        String temp = "ddurabindra";
    /*         System.out.println(temp.length());
        if (StringUtils.isEmpty(temp) || !temp.substring(0, 2).equals("cd")) {
            throw new IllegalStateException();
        }*/
        if(temp.startsWith("c")){
            System.out.println("In");
        }else{
            System.out.println("Out");
        }
    }
}
