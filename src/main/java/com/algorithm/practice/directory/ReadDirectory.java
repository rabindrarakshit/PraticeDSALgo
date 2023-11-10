package com.algorithm.practice.directory;

import java.io.File;

public class ReadDirectory {
    public static void main(String[] args) {
        File file = new File(".");
        for (String str : file.list()) {
            System.out.println(str);
        }
    }
}
