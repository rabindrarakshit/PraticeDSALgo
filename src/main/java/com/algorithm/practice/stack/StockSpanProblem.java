package com.algorithm.practice.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StockSpanProblem {
    List<Integer> stockValues = new ArrayList<>();
    Stack<int[]> stack = new Stack<>();

    public StockSpanProblem() {
    }

    // For every next call we would have a Worst Time Complexity of O(N) so if you consider N calls ypu can say O(N^2)
    public int next1(int price) {
        int count = 1;
        stockValues.add(price);
        for (int i = stockValues.size() - 2; i >= 0; i--) {
            if (stockValues.get(i) <= price) {
                count += 1;
            } else break;
        }
        return count;
    }

    // Time: Amortized(O(1)) Worst : O(N)
    // Space : O(N)
    public int next(int price) {
        int res = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price)
            res += stack.pop()[1];
        stack.push(new int[]{price, res});
        return res;
    }
}

class TestStock {
    public static void main(String[] args) {
        StockSpanProblem stockSpanner = new StockSpanProblem();
        System.out.println(stockSpanner.next(100));
        System.out.println(stockSpanner.next(80));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(70));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(75));
        System.out.println(stockSpanner.next(85));
    }
}
