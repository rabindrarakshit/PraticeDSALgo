package com.algorithm.practice.test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.ws.rs.BadRequestException;

public class Test {

    private static final String DEVICE_FRIENDLY_NAME_REGEX = "[^a-zA-Z0-9\\s\\-]";
    private static final Pattern PATTERN = Pattern.compile(DEVICE_FRIENDLY_NAME_REGEX);

    public static List<Integer> meanderingArray(List<Integer> unsorted) {
        List<Integer> sortedAsc = sortAsc(unsorted);
        List<Integer> sortedDesc = sortDesc(unsorted);
        Integer[] result = new Integer[unsorted.size()];


        Iterator<Integer> itrAsc = unsorted.iterator();
        int j = 0, k = 0;
        for (int i = 0; i < unsorted.size(); i++) {
            if (j < unsorted.size()) {
                result[j] = sortedDesc.get(j);
                j++;
            }
            if (i + 1 < unsorted.size() && k < unsorted.size()) {
                result[i + 1] = sortedAsc.get(k);
                k++;
            }
        }

        List<Integer> intList = new ArrayList<Integer>(result.length);
        for (int i : result) {
            intList.add(i);
        }
        return intList;
    }

    // I have implemented improved bubble sort here we could have used merge sort to reduce complexity.
    // Used this to keep simple and limited time
    public static List<Integer> sortAsc(List<Integer> unsorted) {
        Integer[] duplicate = new Integer[unsorted.size()];
        for (int i = 0; i < unsorted.size(); i++) {
            duplicate[i] = unsorted.get(i);
        }
        int endPosition = unsorted.size() - 1;
        int swapPosition;

        while (endPosition > 0) {
            swapPosition = 0;
            for (int i = 0; i < endPosition; i++) {
                if (duplicate[i] > duplicate[i + 1]) {
                    // Swap elements 'i' and 'i + 1':
                    int tmp = duplicate[i];
                    duplicate[i] = duplicate[i + 1];
                    duplicate[i + 1] = tmp;
                    swapPosition = i;
                } // end if
            }
            endPosition = swapPosition;
        }
        return List.of(duplicate);
    } // end bubbleSort

    public static List<Integer> sortDesc(List<Integer> unsorted) {
        Integer[] duplicate = new Integer[unsorted.size()];
        for (int i = 0; i < unsorted.size(); i++) {
            duplicate[i] = unsorted.get(i);
        }

        int endPosition = unsorted.size() - 1;
        int swapPosition;

        while (endPosition > 0) {
            swapPosition = 0;
            for (int i = 0; i < endPosition; i++) {
                if (duplicate[i] < duplicate[i + 1]) {
                    // Swap elements 'i' and 'i + 1':
                    int tmp = duplicate[i];
                    duplicate[i] = duplicate[i + 1];
                    duplicate[i + 1] = tmp;
                    swapPosition = i;
                } // end if
            }
            endPosition = swapPosition;
        }
        return List.of(duplicate);
    } // end bubbleSort


    public static void updateSoldProduct(SoldProduct sp) {
        //   sp.setCurrency("INR");
    }

    public static void testMaps() {
        Map<String, SimpleSoldProduct> map = new HashMap<>();

        SoldProduct sp1 = new SoldProduct();
        sp1.setName("sp1");
        sp1.setPrice("400");

        SoldProduct sp2 = new SoldProduct();
        sp2.setPrice("500");
        sp2.setName("sp2");

        SoldProduct sp3 = new SoldProduct();
        sp3.setName("sp3");
        sp3.setPrice("600");

        SoldProduct sp4 = new SoldProduct();
        sp4.setPrice("700");
        sp4.setName("sp4");

        SimpleSoldProduct ssp1 = new SimpleSoldProduct();
        ssp1.setType("ssp1");
        ssp1.setSoldProduct(List.of(sp1, sp2));

        SimpleSoldProduct ssp2 = new SimpleSoldProduct();
        ssp2.setType("ssp2");
        ssp2.setSoldProduct(List.of(sp3, sp4));


        map.put("ssp1", ssp1);
        map.put("ssp2", ssp2);

        List<String> list = map.values().stream()
                .flatMap(simpleSoldProduct -> simpleSoldProduct.getSoldProduct().stream())
                .map(soldProduct -> soldProduct.getName())
                .collect(Collectors.toList());


        Map<String, List<Integer>> map1 = new HashMap<>();
        map1.put("One", List.of(1, 3));

        map1.get("One").add(4);

        System.out.println(map1);
    }

    public static String escapeMetaCharacters(String inputString) {
        final String[] metaCharacters = {":", "~", ".", ",", "-", "_", "\\", "/", "^", "$", "{", "}", "[", "]", "(", ")", "*", "+", "?", "|", "<", ">", "&", "%"};
        for (int i = 0; i < metaCharacters.length; i++) {
            if (inputString.contains(metaCharacters[i])) {
                inputString = inputString.replace(metaCharacters[i], "\\" + metaCharacters[i]);
            }
        }
        return inputString;
    }

    public static int missingK(int[] vec, int n, int k) {
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int missing = vec[mid] - (mid + 1);
            if (missing < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return k + high + 1;
    }

    public static List<Integer> moveElementToEnd(
            List<Integer> array, int toMove
    ) {
        int begin = 0;
        int end = array.size()-1;
        if(array==null || array.size()<=0){
            return new ArrayList<>();
        }
        while(end>0 && array.get(end)==toMove){
            end--;
        }
        while(begin<end){
            if(array.get(end)==toMove){
                end--;
                continue;
            }
            if(array.get(begin)==toMove){
                int temp = array.get(end);
                array.set(end, array.get(begin));
                array.set(begin, temp);
                end--;begin++;
            }
            begin++;
        }
        return array;
    }
    public static void main(String[] args) throws InterruptedException {
        FizzBuzz fb = new FizzBuzz(50);

        Runnable printFizz = new Runnable() {
            @Override
            public void run() {
                System.out.println("fizz");
            }
        };
        Runnable printBuzz = new Runnable() {
            @Override
            public void run() {
                System.out.println("buzz");
            }
        };
        Runnable printFizzBuzz = new Runnable() {
            @Override
            public void run() {
                System.out.println("fizzbuzz");
            }
        };
        IntConsumer printNumber = new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.println(value);
            }
        };
        Thread t1 = new Thread(()-> {
            try {
                fb.fizz(printFizz);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread(()-> {
            try {
                fb.buzz(printBuzz);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t3 = new Thread(()-> {
            try {
                fb.fizzbuzz(printFizzBuzz);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t4 = new Thread(()-> {
            try {
                fb.number(printNumber);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

    static class FizzBuzz {
        private int n;
        private AtomicInteger curr=new AtomicInteger(1);

        public FizzBuzz(int n) {
            this.n = n;
        }

        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {
            while (curr.get() <= n) {
                if(curr.get()%3==0 && curr.get()%5!=0){
                    if(curr.get() > n) return;
                    //System.out.println("In Fizz: " + curr);
                    printFizz.run();
                    curr.getAndIncrement();
                }
            }
        }

        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
            while (curr.get() <= n) {
                System.out.println("In Buzz 1: " + curr);
                if(curr.get()%5==0 && curr.get()%3!=0){
                    if(curr.get() > n) return;
                    System.out.println("In Buzz 2: " + curr);
                    printBuzz.run();
                    curr.getAndIncrement();
                }
            }
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            while (curr.get() <= n) {
                if(curr.get()%3==0 && curr.get()%5==0){
                    if(curr.get() > n) return;
                  //  System.out.println("In FizzBuzz: " + curr);
                    printFizzBuzz.run();
                    curr.getAndIncrement();
                }
            }
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            while (curr.get() <= n) {
                if(curr.get()%3!=0 && curr.get()%5!=0){
                    if(curr.get() > n) return;
                    printNumber.accept(curr.get());
                    curr.getAndIncrement();
                }
            }
        }
    }

}
