package com.algorithm.practice.cache;

import java.util.TreeMap;

class Bin {
    String start;
    String end;
    String type;
    
    public Bin(String start, String end, String type) {
        this.start = start;
        this.end = end;
        this.type = type;
    }
}

public class Solution {
    
    TreeMap<String, Bin> binDb;
    int l = Integer.MAX_VALUE;
    
    public static void main(String[] args) {
        
        Solution sol = new Solution();
        
        String[][] bins = {
            {"4444 4444 11", "4444 4444 44", "Visa credit"},
            {"4500 0000 55", "4999 9999 00", "Visa debit"},
            {"4999 9999 99", "5555 0000 00", "Master credit"},
            {"6666 4444 11", "7777 0000 00", "Amex"}
        };
        
        sol.buildDb(bins);
        System.out.println(sol.matchCard("4733 6109 7901 2139") == "Visa debit");
        assert(sol.matchCard("6000 0000 0000 0000") == null);
        System.out.println("done");
    }
    
    public void buildDb(String[][] bins) {
        this.binDb = new TreeMap<String, Bin>((a,b) -> a.compareTo(b));
        for(String[] b : bins) {
            l = Math.min(l, b[0].length());
            Bin bin = new Bin(b[0], b[1], b[2]);
            binDb.put(b[0], bin);
        }
    }
    
    public String matchCard(String cardNo) {
        cardNo = cardNo.substring(0,0+l);
        String floorKey = binDb.floorKey(cardNo);
        String ceilKey = binDb.ceilingKey(cardNo);
        if (floorKey != null) {
            Bin bin = binDb.get(floorKey);
            if (isBinMatch(cardNo, bin)) {
                return bin.type;
            }
        }
        if (ceilKey != null) {
            Bin bin = binDb.get(ceilKey);
            if (isBinMatch(cardNo, bin)) {
                return bin.type;
            }
        }
        return null;
    }
    
    public boolean isBinMatch(String cardNo, Bin bin) {
        return cardNo.compareTo(bin.start) >= 0 && cardNo.compareTo(bin.end) <= 0;
    }
}