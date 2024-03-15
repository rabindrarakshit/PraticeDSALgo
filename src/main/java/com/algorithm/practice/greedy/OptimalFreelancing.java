package com.algorithm.practice.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Ref: https://www.algoexpert.io/questions/optimal-freelancing

public class OptimalFreelancing {
    static int maxIncome(Map<String, Integer>[] jobs) {

        int total = 0;
        final int LENGTH_OF_WEEK = 7;
        Arrays.sort(jobs, (m1, m2) -> Integer.compare(m2.get("payment"), m1.get("payment")));
        boolean[] week = new boolean[LENGTH_OF_WEEK];
        for (Map<String, Integer> job : jobs) {
            int maxTime = Math.min(job.get("deadline"), LENGTH_OF_WEEK);
            for (int i = maxTime - 1; i >= 0; i--) {
                if (week[i] == false) {
                    total += job.get("payment");
                    week[i] = true;
                    break;
                }
            }
        }
        return total;
    }

    // Initial Wrong solution where I didnot consider if the dealine is 2 then it can also be considered for day 1.
    public int optimalFreelancing(Map<String, Integer>[] jobs) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < jobs.length; i++) {
            Map<String, Integer> currentJob = jobs[i];
            int curDeadline = currentJob.get("deadline");
            int curPayment = currentJob.get("payment");
            if (map.containsKey(curDeadline)) {
                int payment = map.get(curDeadline);
                if (payment < curPayment) {
                    map.put(curDeadline, curPayment);
                }
            } else {
                map.put(curDeadline, curPayment);
            }
        }
        int total = 0;
        for (Integer i : map.values()) {
            total += i;
        }
        return total;
    }


}
