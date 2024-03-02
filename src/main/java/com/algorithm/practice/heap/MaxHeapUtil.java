package com.algorithm.practice.heap;

import java.util.ArrayList;
import java.util.List;

public class MaxHeapUtil {
    static class MaxHeap {

        List<Integer> heap = new ArrayList<>();

        public MaxHeap(List<Integer> arr) {
            heap = buildHeap(arr);
        }

        public List<Integer> buildHeap(List<Integer> arr) {
            int firstParentIdx = (arr.size() - 2) / 2;
            for (int currentIdx = firstParentIdx; currentIdx >= 0; currentIdx--) {
                shiftDown(currentIdx, arr);
            }
            return arr;
        }

        public Integer peek() {
            return heap.get(0);
        }

        public Integer remove(List<Integer> heap) {
            swap(0, heap.size() - 1, heap);
            int poppedElement = heap.get(heap.size() - 1);
            heap.remove(heap.size() - 1);
            shiftDown(0, heap);
            return poppedElement;
        }

        public void insert(Integer data, List<Integer> heap) {
            heap.add(data);
            shiftUp(heap.size() - 1, heap);
        }

        public void shiftUp(int currentIdx, List<Integer> heap) {
            int parentIdx = (currentIdx - 1) / 2;
            while (currentIdx > 0 && heap.get(currentIdx) > heap.get(parentIdx)) {
                swap(parentIdx, currentIdx, heap);
                currentIdx = parentIdx;
                parentIdx = (currentIdx - 1) / 2;
            }
        }

        public void shiftDown(int currentIdx, List<Integer> heap) {
            int leftChildIdx = currentIdx * 2 + 1;
            while (leftChildIdx < heap.size()) {
                int rightChildIdx = (currentIdx * 2 + 2) < heap.size() ? currentIdx * 2 + 2 : -1;
                int idxToBeSwapped;
                if (rightChildIdx != -1 && heap.get(rightChildIdx) > heap.get(leftChildIdx)) {
                    idxToBeSwapped = rightChildIdx;
                } else {
                    idxToBeSwapped = leftChildIdx;
                }
                if (heap.get(idxToBeSwapped) > heap.get(currentIdx)) {
                    swap(idxToBeSwapped, currentIdx, heap);
                    currentIdx = idxToBeSwapped;
                    leftChildIdx = currentIdx * 2 + 1;
                } else break;
            }
        }

        public void swap(int firstIdx, int secondIdx, List<Integer> heap) {
            int temp = heap.get(firstIdx);
            heap.set(firstIdx, heap.get(secondIdx));
            heap.set(secondIdx, temp);
        }
    }
    public static void main(String[] args) {
        Integer[] testData = new Integer[]{1,2,3,4,5};
        MaxHeap maxHeap = new MaxHeap(new ArrayList<>(List.of(testData)));

        List<Integer> heap = maxHeap.heap;
        for (Integer i : heap) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(maxHeap.peek());
        System.out.println(maxHeap.remove(heap));
        for (Integer i : heap) {
            System.out.print(i + " ");
        }
        System.out.println();
        maxHeap.insert(5, heap);
        for (Integer i : heap) {
            System.out.print(i + " ");
        }}
}
