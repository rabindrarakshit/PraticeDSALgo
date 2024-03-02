package com.algorithm.practice.heap;

import java.util.Collections;
import java.util.PriorityQueue;

// Ref: https://www.algoexpert.io/questions/continuous-median

public class ContinuousMedianPriorityQueue {

    static class ContinuousMedian {
        PriorityQueue<Integer> lower = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> upper = new PriorityQueue<>();
        double median = 0;

        void insert(Integer data) {
            if (lower.size() == 0 || data < lower.peek()) {
                lower.add(data);
            } else {
                upper.add(data);
            }
            rebalance();
            updateMedian();
        }

        void rebalance() {
            if (lower.size() - upper.size() == 2) {
                upper.add(lower.poll());
            } else if (upper.size() - lower.size() == 2) {
                lower.add(upper.poll());
            }
        }

        void updateMedian() {
            if (lower.size() == upper.size()) {
                median = ((double) lower.peek() + (double) upper.peek()) / 2;
            } else if (lower.size() > upper.size()) {
                median = lower.peek();
            } else {
                median = upper.peek();
            }
        }

        double getMedian() {
            return median;
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
