package com.algorithm.practice.directory;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class SimplifyPathI {

    private static final String CURRENT_DIRECTORY = ".";

    private static final String PREVIOUS_DIRECTORY = "..";

    private static final String SEPARATOR = "/";


    public static void main(String[] args) {

        SimplifyPathI s = new SimplifyPathI();

        String current1 = "/facebook";
        String change1 = "/ ";
        String temp = s.changeDirectory(current1, change1);
        System.out.println(temp); //ans: /facebook

   /*     String current2 = "/facebook/anin";
        String change2 = "../abc/def";
        System.out.println(s.changeDirectory(current2, change2)); //ans: /facebook/abc/def

        String current3 = "/facebook/instagram";
        String change3 = "../../../../.";
        System.out.println(s.changeDirectory(current3, change3)); //ans: /*/
    }

    public String changeDirectory(String current, String change) {
        if(change.equals("/")){
            return "/";
        }
        if (change == null || change.trim().isEmpty()) {
            return current;
        }

        Deque<String> stack = new ArrayDeque<>();
        String[] currentComponents = current.split(SEPARATOR);
        for (String directory : currentComponents) {
            if (!directory.isEmpty()) {
                stack.push(directory);
            }
        }

        String[] changeComponents = change.split("/");
        for (String directory : changeComponents) {
            if (directory.isEmpty() || directory.equals(CURRENT_DIRECTORY)) {
                continue;
            }
            if (directory.equals(PREVIOUS_DIRECTORY)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(directory);
            }
        }

        StringBuilder path = new StringBuilder();
        Iterator<String> itr = stack.descendingIterator();
        while (itr.hasNext()) {
            path.append(SEPARATOR);
            path.append(itr.next());
        }
        return path.length() > 0 ? path.toString() : SEPARATOR;
    }
}