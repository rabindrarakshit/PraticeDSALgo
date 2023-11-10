package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Pair{
    String website;
    int time;
    Pair(String website, int time){
        this.website = website;
        this.time = time;
    }
}

public class AnalyzeUser {
    public static List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<Pair>> map = new HashMap<>();
        for (int i = 0; i < username.length; i++) {
            map.putIfAbsent(username[i], new ArrayList<>());
            Pair p = new Pair(website[i], timestamp[i]);
            map.get(username[i]).add(p);
        }
        Map<String, Integer> count = new HashMap<>();
        String res = "";
        for (String key : map.keySet()) {
            Set<String> set = new HashSet<>();
            List<Pair> list = map.get(key);
            Collections.sort(list, (a, b) -> (a.time - b.time));
            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    for (int k = j + 1; k < list.size(); k++) {
                        String str = list.get(i).website + " " + list.get(j).website + " " + list.get(k).website;
                        if (!set.contains(str)) {
                            count.put(str, count.getOrDefault(str, 0) + 1);
                            set.add(str);
                        }
                        if (res.equals("") || count.get(res) < count.get(str) || (count.get(res) == count.get(str) && res.compareTo(str) > 0)) {
                            res = str;
                        }
                    }
                }
            }
        }
        return Arrays.asList(res.split(" "));
    }

    public static void main(String[] args) {
        System.out.println(mostVisitedPattern(new String[]{"dowg","dowg","dowg"},new int[]{158931262,562600350,148438945},new String[]{"y","loedo","y"}));

    }
}
