package com.algorithm.practice.stack.monotonic;

// Ref: https://leetcode.com/problems/asteroid-collision/

import java.util.Arrays;
import java.util.LinkedList;

public class AsteroidCollision {

    // Not a stack implementation, Did not go through
    // Leetcode Time: 1ms
    public int[] asteroidCollision(int[] asteroids) {
        int index = -1;
        for (int currentAsteroid : asteroids) {
            boolean currentAsteroidUndestroyed = true;
            while (currentAsteroidUndestroyed && index >= 0 && asteroids[index] > 0 && currentAsteroid < 0) {
                currentAsteroidUndestroyed = currentAsteroid + asteroids[index] < 0;
                if (currentAsteroid + asteroids[index] <= 0) {
                    --index;
                }
            }
            if (currentAsteroidUndestroyed) {
                asteroids[++index] = currentAsteroid;
            }
        }
        return Arrays.copyOfRange(asteroids, 0, index + 1);
    }

    // Monotonic Stack implementation
    // Time: O(2N)
    // Space: O(N)
    static int[] getRemaining(int[] arr) {
        // This is same as stack, we have used LinkedList here, or else we would have to reverse the array at last.
        LinkedList<Integer> list = new LinkedList<>();
        for (int i : arr) {
            while (!list.isEmpty() && list.getLast() > 0 && list.getLast() < -i) {
                list.pollLast();
            }
            if (list.isEmpty() || i > 0 || list.getLast() < 0) {
                list.add(i);
            } else if (i < 0 && list.getLast() == -i) {
                list.pollLast();
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        for (int i : getRemaining(new int[]{8, 2, -5})) {
            System.out.print(i + " ");
        }
    }
}
