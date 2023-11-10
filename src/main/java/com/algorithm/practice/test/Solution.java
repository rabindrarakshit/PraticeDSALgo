package com.algorithm.practice.test;

import com.algorithm.practice.concurrency.TestNotSynchronized;
import com.algorithm.practice.concurrency.TestSynchronized;
import org.apache.commons.lang3.StringUtils;

import java.math.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static com.google.common.collect.ImmutableMap.toImmutableMap;
import com.google.common.collect.Iterables;

public class Solution {
  //  private static final Scanner scanner = new Scanner(System.in);

    public static int maxSubArray(int[] A){
        int maxSoFar=A[0], maxEndingHere = A[0], s=0, e=0;
        for (int i=1; i<A.length; i++){
            if( maxSoFar<=0 && A[i] > maxSoFar){
                s=i;
                e=i;
            }
            if(maxSoFar + A[i]> maxSoFar){
                e=i;
            }
            maxEndingHere = Math.max(maxEndingHere + A[i], A[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        System.out.println("Starting Index: "+s+"Ending Index: "+e);
        return maxSoFar;
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n){
      int nums3[] = new int[m+n];
      int j=0, k=0;
        for (int i=0; i< m+n; i++){
          if(nums1[j]<=nums2[k] && j<m){
              nums3[i]=nums1[j];
              j++;
          }else{
              nums3[i]= nums2[k];
              k++;
          }
      }
        for (int i=0; i< m+n; i++){
            nums1[i] = nums3[i];
        }
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> nums1Map = new HashMap<>();
        Map<Integer, Integer> nums2Map = new HashMap<>();
        for (int i=0; i< nums1.length; i++){
            if(nums1Map.containsKey(nums1[i])){
                int val = nums1Map.get(Integer.valueOf(nums1[i]));
                val++;
                nums1Map.put(nums1[i],val);
            }else{
                nums1Map.put(nums1[i],1);
            }
        }
        for (int i=0; i< nums2.length; i++){
            if(nums2Map.containsKey(nums2[i])){
                int val = nums2Map.get(Integer.valueOf(nums2[i]));
                val++;
                nums2Map.put(nums2[i],val);
            }else{
                nums2Map.put(nums2[i],1);
            }
        }
        for (Integer val : nums1Map.keySet()){
            if(nums1Map.get(val)!=null && nums1Map.get(val)> 0 && nums2Map.get(val)!=null && nums2Map.get(val) >0){
                int diff = nums1Map.get(val) - nums2Map.get(val);
                if(diff==0){
                    for(int j=0; j<nums1Map.get(val); j++){
                        result.add(val);
                    }
                }else{
                int min = Math.min(nums1Map.get(val),nums2Map.get(val));
                for(int j=0; j<min; j++){
                    result.add(val);
                }}

            }
        }

        int[] array = new int[result.size()];
        for (int i=0; i< result.size(); i++){
            array[i] = result.get(i);
        }
        return array;
    }

    private static TestAnnotation testIt(){
        return (testString) -> {
            System.out.println("Print test string: "+testString);
        };
    }

    public static List<Account> getAccountsUtil(List<String> accountIds) {
        Account account = new Account();
        account.setId(Long.valueOf(1));
        account.setName("Rabindra");
        account.setAvailableBalance(Double.valueOf(100));
        account.setClosed(false);


        return List.of(account);
    }

    public static Map<Long, Account> getAccounts(List<String> accountIds) {
        Iterable<List<String>> partitions = Iterables.partition(accountIds, 12);
        return getAccountsUtil(accountIds).stream()
                .collect(toImmutableMap(Account::getId, Function.identity()));
    }

    public static void main(String[] args) {

        int A[] = new int[]{1,2,3,4};
        int res = 0;
        for(int j=0; j<100000;j++){
            boolean found = false;
            for(int i: A){
                if(j==i){
                    System.out.println(i+" "+j);
                    found = true;
                    break;
                }
            }
            if(found == false){
                res = j;
                break;
            }
        }
        System.out.println(res);



        getAccounts(List.of("123"));

        //
        // testIt().apply("Rabindra");

      //  System.out.println("Rabindra".substring(1));
       // int[] nums = new int[]{1,2,-3,4};

    /*    String temp = "dsd";
        switch(temp){
            case "abc" :
                System.out.println(temp);

        }

        Student s1 = new Student("Rabi");


        Student s2 = new Student(s1.getName());

        s1.setName("Aru");

        System.out.println(s2.getName());
        Student s3=  new Student(null);

        List<Student> studentList = List.of(s1, s2,s3, s1);

        List<Student> filteredList = studentList.stream()
                .filter(student-> StringUtils.isEmpty(student.getName()))
                .collect(Collectors.toList());

        studentList = studentList.stream()
                .filter(st -> st.getName()!=null)
                .sorted(Comparator.comparing((Student student) -> !student.getName().equals("Rabi")))
                .collect(Collectors.toList());

        studentList.addAll(filteredList);

        System.out.println(""); */
        /*   TestNotSynchronized test = new TestNotSynchronized();
        Thread t1 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 1000000; i++) {
                            test.increment();
                        }
                    }
                }
        );

        Thread t3 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 1000000; i++) {
                            test.increment();
                        }
                    }
                }
        );



        t1.start();
        t3.start();

        /*
        List<Integer> list = List.of(1,23);

        Function<Long,Long> sum = new SumFunction();

        Function<Long,Long> adder = (value) -> value+3;


        System.out.println(adder.apply((long)4));

        Predicate notNullPredicate = (value) -> value!=null;

        Supplier<Integer> integerSupplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return (int)(Math.random()* 1000D);
            }
        };

        Supplier<Integer> intSupplier = () -> (int) (Math.random()*1000D);

        System.out.println(intSupplier.get());

        Stream<String> nameStream = Stream.of("Rabi","Arushree",null);
        nameStream.filter(notNullPredicate).forEach(System.out::println);

        Consumer<Integer> consumer = (value) -> System.out.println(value);
        consumer.accept(5); */

       /* String result[] = solution(10,100);
        for(int i = 0; i< result.length; i ++){
            System.out.println(result[i]);
            System.out.println(result.length);
        }
        Stream.of
                */


        /*
       int A[] = {1,1,3,3,3,4,5,5,5,5};
       int y = 7;
       int result = 0;


       // sort the nails based on length
        Arrays.sort(A);

        // create a map with length as a key and values as their frequency
        Map<Integer, Integer> nailMap = new HashMap();
        for (int i = 0; i < A.length; i++) {
            if (nailMap.get(A[i]) == null) {
                nailMap.put(A[i], 1);
            } else {
                int count = nailMap.get(A[i]);
                count = count + 1;
                nailMap.put(A[i], count);
            }
        }


        // This array is sorted based on length of the nails
        Object[] frequencyObjectArray = (nailMap.values().toArray());
        Integer[] frequencyIntegerArray = new Integer[frequencyObjectArray.length];

        // copy elements from object array to integer array
        for (int i = 0; i < frequencyObjectArray.length; i++)
            frequencyIntegerArray[i] = (Integer) frequencyObjectArray[i];

        for (int i = frequencyIntegerArray.length - 1; i > 0; i--) {
            if (frequencyIntegerArray[i] > y) {

                // Find max frequency of the remaining nails
                int max  = 0;
                for (int k = 0; k < i ; k++ ){
                    if( frequencyIntegerArray[k] > max){
                        max = frequencyIntegerArray[k];
                    }
                }

                // Here we decide which length of nail to choose.
                int residue = frequencyIntegerArray[i] - y > max ? frequencyIntegerArray[i] - y : max;

                result = result + residue + y;
                break;
            }
            result = result + frequencyIntegerArray[i];
            y = y - frequencyIntegerArray[i];
        }

        System.out.println(result);

*/


       /*  int right_sum, left_sum, count =0;
       List<Integer> result = new ArrayList<>();

       Arrays.sort(arr);
       for(int i=arr.length-1; i>=0;i--){
           right_sum = sum (arr, i, arr.length-1);
           left_sum = sum (arr, 0, i-1);
           if(right_sum>left_sum){
               count = i;
               break;
           }
           result.add(arr[i]);
       }

       result.toArray();*/

        /*  String S = "kqep";
        String T = "pekeq";
        String copyOfT = T;

        StringBuffer temp = new StringBuffer();

        for (int i=0 ; i < S.length() ; i++){
            for (int j =0; j < T.length() ; j++){
                if (S.charAt(i) == T.charAt(j)){
                    temp = temp.append(T.charAt(j));
                }
            }
        }

        for (int i =0; i< S.length() ; i++){
            T = T.replaceAll(String.valueOf(S.charAt(i)), "");
        }

        System.out.println(T + temp.toString()); */

        /*   String constant = null;
        String DEVICE_FRIENDLY_NAME_REGEX = "^[a-zA-Z0-9\\s\\-]{3,14}$";
        Pattern PATTERN = Pattern.compile(DEVICE_FRIENDLY_NAME_REGEX);
        Matcher matcher = PATTERN.matcher(constant);
        if (matcher.find()){
            System.out.println("If");
        }else{
            System.out.println("Else");
        }*/

     /*   Stack s = new Stack();
        s.add("rabi");
        s.add("aru");
        System.out.println(s.size());

        Queue q = new LinkedList<Integer>();
        q.add(3);
        System.out.println(q.size()); */
   //     uniqueOccurrences(new int[]{1,2});

    }

    public static int sum(int[] arr, int i, int j){
        int sum = 0;
        for(int k=i; k<j; k++){
            sum = sum + arr[k];
        }
        return sum;
    }

    public static String removeCharAt(String s, int pos) {
        return s.substring(0, pos) + s.substring(pos + 1);
    }

    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> intMap = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            if(intMap.get(arr[i])!=null){
                int value = intMap.get(arr[i]);
                value = value+1;
                intMap.put(arr[i],value);
            }else{
                intMap.put(arr[i],1);
            }
        }
        int keySet[] = new int[intMap.values().size()];
        Object[] objectArray = intMap.values().toArray();
        for(int i=0; i<objectArray.length; i++){
            keySet[i] = (int)objectArray[i];
        }

        for(int i=0; i<keySet.length; i++){
            for(int j=i+1; j<keySet.length; j++){
                if(keySet[i]==keySet[j]){
                    return false;
                }
            }
        }
        return true;
    }
}
