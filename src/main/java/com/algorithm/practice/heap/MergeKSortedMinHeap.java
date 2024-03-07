package com.algorithm.practice.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

// Ref: https://www.algoexpert.io/questions/merge-sorted-arrays
// Time: O(Nlog(k)+k) | Space: O(n+k)

public class MergeKSortedMinHeap {

    static List<Integer> mergeSortedArray(List<List<Integer>> arrays){
        List<Integer> sortedArray = new ArrayList<>();
        PriorityQueue<Item> minHeap = new PriorityQueue<>(Comparator.comparingInt(Item::getValue));
        for(int i=0;i<arrays.size();i++){
            minHeap.add(new Item(i, 0, arrays.get(i).get(0)));
        }
        while(!minHeap.isEmpty()){
            Item minItem = minHeap.remove();
            sortedArray.add(minItem.getValue());
            if(minItem.elementIndex==arrays.get(minItem.arrayIndex).size()-1){
                continue;
            }
            minHeap.add(new Item(minItem.arrayIndex, minItem.elementIndex+1, arrays.get(minItem.arrayIndex).get(minItem.elementIndex+1)));
        }
        return sortedArray;
    }

    static class Item {
        Integer elementIndex;
        Integer arrayIndex;
        Integer value;

        public Item(Integer arrayIndex, Integer elementIndex, Integer value) {
            this.elementIndex = elementIndex;
            this.arrayIndex = arrayIndex;
            this.value = value;
        }

        public Integer getElementIndex() {
            return elementIndex;
        }

        public Integer getArrayIndex() {
            return arrayIndex;
        }

        public Integer getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        for (int i : mergeSortedArray(List.of(List.of(1, 5, 9, 21), List.of(-1, 0), List.of(-124, 81, 121), List.of(3, 6, 12, 20, 150)))) {
            System.out.print(i + " ");
        }
    }
}
