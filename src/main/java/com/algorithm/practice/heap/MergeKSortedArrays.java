package com.algorithm.practice.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Ref: https://www.algoexpert.io/questions/merge-sorted-arrays
// Time: O(n*k) | Space: O(n+k)

public class MergeKSortedArrays {
    static List<Integer> mergeKSortedArray(List<List<Integer>> input) {
        List<Integer> sortedList = new ArrayList<>();
        List<Integer> indexes = new ArrayList<>(Collections.nCopies(input.size(), 0));
        while (true) {
            List<Item> items = new ArrayList<>();
            for (int i = 0; i < input.size(); i++) {
                List<Integer> currentList = input.get(i);
                int index = indexes.get(i);
                if (index == currentList.size()) {
                    continue;
                }
                Item item = new Item(i, currentList.get(index));
                items.add(item);
            }
            if (items.size() == 0) {
                break;
            }
            Item minItem = findMin(items);
            indexes.set(minItem.index, indexes.get(minItem.index) + 1);
            sortedList.add(minItem.value);
        }
        return sortedList;
    }

    static Item findMin(List<Item> items) {
        Integer min = Integer.MAX_VALUE;
        Item minItem = null;
        for (Item i : items) {
            if (i.value < min) {
                min = i.value;
                minItem = i;
            }
        }
        return minItem;
    }

    static class Item {
        Integer index;
        Integer value;

        public Item(Integer index, Integer value) {
            this.index = index;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        for (int i : mergeKSortedArray(List.of(List.of(1, 5, 9, 21), List.of(-1, 0), List.of(-124, 81, 121), List.of(3, 6, 12, 20, 150)))) {
            System.out.print(i + " ");
        }
    }
}
