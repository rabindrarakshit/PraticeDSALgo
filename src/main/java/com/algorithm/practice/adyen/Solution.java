package com.algorithm.practice.adyen;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        try (final Scanner scanner = new Scanner(System.in)) {
            List<Result.BinRange> binRanges = new ArrayList<>();

            String cardNumber = scanner.next();
            scanner.nextLine();

            scanner.useDelimiter("[,\n]");

            while (scanner.hasNext()) {
                String start = scanner.next();
                String end = scanner.next();
                String cardType = scanner.next();
                binRanges.add(new Result.BinRange(start, end, cardType));
                if (scanner.hasNextLine()) {
                    scanner.nextLine();
                }
            }

            Result.CardTypeCache cache = Result.buildCache(binRanges);
            if (cache != null) {
                bufferedWriter.write(String.valueOf(cache.get(cardNumber)));
            }
        }

        bufferedWriter.newLine();
        bufferedWriter.close();
    }
}
