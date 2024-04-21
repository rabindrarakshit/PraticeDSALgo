package com.algorithm.practice.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class JavaInput {
    static void testInput() throws IOException {
        int x, y;
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        y = sc.nextInt();
        System.out.println("X=" + x + " Y=" + y);

        System.out.println("Enter a number:");
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader bf = new BufferedReader(in);

        int num = Integer.parseInt(bf.readLine());
        System.out.println("You entered: " + num);
    }

    public static void main(String[] args) throws IOException {
       // testInput();


        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(i==1 && j==2)
                    break;
                System.out.println("i= "+i+" j= "+j);
            }
        }
    }
}
