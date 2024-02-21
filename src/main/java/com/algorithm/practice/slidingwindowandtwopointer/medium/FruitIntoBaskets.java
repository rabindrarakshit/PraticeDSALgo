package com.algorithm.practice.slidingwindowandtwopointer.medium;

import java.util.HashMap;
import java.util.Map;

// Ref: https://leetcode.com/problems/fruit-into-baskets/description/
public class FruitIntoBaskets {

    static int maxFruits(int[] trees, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        for (; j < trees.length; j++) {
            map.put(trees[j], map.getOrDefault(trees[j], 0) + 1);
            if (map.size() > k) {
                map.put(trees[i], map.get(trees[i]) - 1);
                map.remove(trees[i++], 0);
            }
        }
        return j - i;
    }

    public static void main(String[] args) {
        System.out.println(maxFruits(new int[]{1, 1, 1, 2, 3}, 2));
    }
}
