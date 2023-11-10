package com.algorithm.practice.afinance;

import java.util.List;
import java.util.TreeMap;

public class Result {
    static int l = Integer.MAX_VALUE;

    /**
     * An entity to hold bin range details. A bin range is a pair of 12 digit numbers that
     * mark the boundaries of the range which is maped to other bin range properties such
     * as a card type. The range boundaries are inclusive.
     */
    static final class BinRange {
        final String start;
        final String end;
        final String cardType;

        BinRange(String start, String end, String cardType) {
            this.start = start;
            this.end = end;
            this.cardType = cardType;
        }
    }


    interface CardTypeCache {
        /**
         * @param cardNumber 12 to 23 digit card number.
         *
         * @return the card type for this cardNumber or null if the card number does not
         *      fall into any valid bin ranges.
         */
        String get(String cardNumber);
    }

    /**
     * @param binRanges the list of card bin ranges to build a cache from.
     *
     * @return an implementation of CardTypeCache.
     */
    public static CardTypeCache buildCache(List<BinRange> binRanges) {
        TreeMap<String, BinRange> binCache = new TreeMap<String, BinRange>((br1, br2) -> br1.compareTo(br2));;
        for (BinRange b : binRanges) {
            l = Math.min(l, b.start.length());
            BinRange bin = new BinRange(b.start, b.end, b.cardType);
            binCache.put(b.start, bin);
        }
        CardTypeCache cache= new CardTypeCacheImpl(binCache);
        return cache;
    }

    static class CardTypeCacheImpl implements CardTypeCache{

        TreeMap<String, BinRange> binCache;

        CardTypeCacheImpl(TreeMap<String, BinRange> binCache){
            this.binCache = binCache;
        }

        @Override
        public String get(String cardNumber) {
            cardNumber = cardNumber.substring(0, 0 + l);
            String categoryKey = binCache.floorKey(cardNumber);
            if (categoryKey != null) {
                BinRange bin = binCache.get(categoryKey);
                if (checkBinCategory(cardNumber, bin)) {
                    return bin.cardType;
                }
            }
            categoryKey = binCache.ceilingKey(cardNumber);
            if (categoryKey != null) {
                BinRange bin = binCache.get(categoryKey);
                if (checkBinCategory(cardNumber, bin)) {
                    return bin.cardType;
                }
            }
            return null;
        }

        private static boolean checkBinCategory(String cardNumber, BinRange bin) {
            return cardNumber.compareTo(bin.start) >= 0 && cardNumber.compareTo(bin.end) <= 0;
        }
    }
}
