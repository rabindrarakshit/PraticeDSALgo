package com.algorithm.practice.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinHeapUtil {

    static class MinHeap {
        List<Integer> heap;
        public MinHeap(List<Integer> array){
            heap = buildHeap(array);
        }
        public List<Integer> buildHeap(List<Integer> arr) {
            int parentIdx = (arr.size() - 2) / 2;
            for (int currentIdx = parentIdx; currentIdx >= 0; currentIdx--) {
                shiftDown(currentIdx, arr);
            }
            return arr;
        }

        public void shiftUp(int currentIndex, List<Integer> heap) {
            int parentIdx = (heap.size() - 2) / 2;
            while (currentIndex > 0 && heap.get(currentIndex) < heap.get(parentIdx)) {
                swap(currentIndex, parentIdx, heap);
                currentIndex = parentIdx;
                parentIdx = (currentIndex - 1) / 2;
            }
        }

        public void shiftDown(int currentIndex, List<Integer> heap) {
            int leftChild = 2 * currentIndex + 1;
            while (leftChild < heap.size()) {
                int rightChild = (2 * currentIndex + 2) < heap.size() ? 2 * currentIndex + 2 : -1;
                int idxToBeReplaced;
                if (rightChild != -1) {
                    idxToBeReplaced = heap.get(leftChild) < heap.get(rightChild) ? leftChild : rightChild;
                } else {
                    idxToBeReplaced = leftChild;
                }
                if (heap.get(currentIndex) > heap.get(idxToBeReplaced)) {
                    swap(currentIndex, idxToBeReplaced, heap);
                    currentIndex = idxToBeReplaced;
                    leftChild = 2 * currentIndex + 1;
                } else return;
            }
        }

        public Integer minElement(List<Integer> heap) {
            return heap.get(0);
        }

        public void insert(Integer data, List<Integer> heap) {
            heap.add(data);
            shiftUp(heap.size() - 1, heap);
        }

        public Integer remove(List<Integer> heap) {
            swap(0, heap.size() - 1, heap);
            Integer itemToBeRemoved = heap.get(heap.size() - 1);
            heap.remove(heap.size() - 1);
            shiftDown(0, heap);
            return itemToBeRemoved;
        }

        public void swap(int firstIdx, int secondIdx, List<Integer> heap) {
            int temp = heap.get(firstIdx);
            heap.set(firstIdx, heap.get(secondIdx));
            heap.set(secondIdx, temp);
        }
    }

    public static void main(String[] args) {
        Integer[] testData = new Integer[]{5, 4, 3, 2, 1};
        MinHeap minHeap = new MinHeap(new ArrayList<>(List.of(testData)));

        List<Integer> heap = minHeap.heap;
        for (Integer i : heap) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(minHeap.minElement(heap));
        System.out.println(minHeap.remove(heap));
        for (Integer i : heap) {
            System.out.print(i + " ");
        }
        System.out.println();
        minHeap.insert(1, heap);
        for (Integer i : heap) {
            System.out.print(i + " ");
        }

    }

}
