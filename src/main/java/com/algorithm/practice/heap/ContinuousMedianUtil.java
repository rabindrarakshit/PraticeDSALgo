package com.algorithm.practice.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

// Ref: https://www.algoexpert.io/questions/continuous-median

public class ContinuousMedianUtil {

    static class ContinuousMedian {
        Heap minHeap = new Heap(Heap::MIN_HEAP_FUNC, new ArrayList<>());
        Heap maxHeap = new Heap(Heap::MAX_HEAP_FUNC, new ArrayList<>());

        Double median;

        public Double getMedian() {
            return median;
        }

        public void insert(Integer data) {
            if (maxHeap.length == 0 || data < maxHeap.peek()) {
                maxHeap.insert(data);
            } else {
                minHeap.insert(data);
            }
            reBalanceHeap();
            updateMedian();
        }

        public void reBalanceHeap() {
            if (minHeap.length - maxHeap.length == 2) {
                maxHeap.insert(minHeap.remove());
            } else if (maxHeap.length - minHeap.length == 2) {
                minHeap.insert(maxHeap.remove());
            }
        }

        public void updateMedian() {
            if (maxHeap.length == minHeap.length) {
                median = ((double) maxHeap.peek() + (double) minHeap.peek()) / 2;
            } else if (maxHeap.length > minHeap.length) {
                median = (double) maxHeap.peek();
            } else {
                median = (double) minHeap.peek();
            }
        }
    }

    static class Heap {
        List<Integer> heap;
        BiFunction<Integer, Integer, Boolean> comparisionFunc;

        Integer length;

        Heap(BiFunction<Integer, Integer, Boolean> func, List<Integer> array) {
            this.comparisionFunc = func;
            heap = buildHeap(array);
            this.length = array.size();
        }

        public List<Integer> buildHeap(List<Integer> array) {
            int firstParent = (array.size() - 2) / 2;
            for (int currentIdx = firstParent; currentIdx >= 0; currentIdx--) {
                shiftDown(currentIdx, array);
            }
            return array;
        }

        public Integer peek() {
            return heap.get(0);
        }

        private void shiftUp(int currentIdx, List<Integer> heap) {
            int parentIdx = (currentIdx - 1) / 2;
            while (currentIdx > 0) {
                if (comparisionFunc.apply(heap.get(currentIdx), heap.get(parentIdx))) {
                    swap(parentIdx, currentIdx);
                    currentIdx = parentIdx;
                    parentIdx = (currentIdx - 1) / 2;
                } else {
                    return;
                }
            }
        }

        private void shiftDown(int currentIdx, List<Integer> heap) {
            int leftChildIdx = currentIdx * 2 + 1;
            while (leftChildIdx < heap.size()) {
                int rightChildIdx = (currentIdx * 2 + 2) < heap.size() ? (currentIdx * 2 + 2) : -1;
                int idxToBeReplaced = 0;
                if (rightChildIdx != -1) {
                    if (comparisionFunc.apply(heap.get(leftChildIdx), heap.get(rightChildIdx))) {
                        idxToBeReplaced = leftChildIdx;
                    } else {
                        idxToBeReplaced = rightChildIdx;
                    }
                } else {
                    idxToBeReplaced = leftChildIdx;
                }
                if (comparisionFunc.apply(heap.get(idxToBeReplaced), heap.get(currentIdx))) {
                    swap(currentIdx, idxToBeReplaced);
                    currentIdx = idxToBeReplaced;
                    leftChildIdx = currentIdx * 2 + 1;
                } else {
                    return;
                }
            }
        }

        public void insert(Integer data) {
            heap.add(data);
            shiftUp(heap.size() - 1, heap);
            length++;
        }

        public Integer remove() {
            swap(0, heap.size() - 1);
            Integer elementToBeRemoved = heap.get(heap.size() - 1);
            heap.remove(heap.size() - 1);
            shiftDown(0, heap);
            length--;
            return elementToBeRemoved;
        }

        private void swap(int firstIdx, int secondIdx) {
            int temp = heap.get(firstIdx);
            heap.set(firstIdx, heap.get(secondIdx));
            heap.set(secondIdx, temp);
        }

        public static Boolean MAX_HEAP_FUNC(Integer a, Integer b) {
            return a > b;
        }

        public static Boolean MIN_HEAP_FUNC(Integer a, Integer b) {
            return b > a;
        }
    }

    public static void main(String[] args) {
        ContinuousMedian continuousMedian = new ContinuousMedian();
        continuousMedian.insert(1);
        System.out.println(continuousMedian.getMedian());
        continuousMedian.insert(2);
        System.out.println(continuousMedian.getMedian());
        continuousMedian.insert(3);
        System.out.println(continuousMedian.getMedian());
        continuousMedian.insert(4);
        System.out.println(continuousMedian.getMedian());
        continuousMedian.insert(5);
        System.out.println(continuousMedian.getMedian());
        continuousMedian.insert(6);
        System.out.println(continuousMedian.getMedian());
    }
}
