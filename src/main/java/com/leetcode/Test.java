package com.leetcode;

import java.math.BigInteger;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Test {
    ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
    Map<TreeNode, Integer> map = new HashMap<>();
    int[] nums;
    static String phoneDigits = null;
    static List<String> combinations = new ArrayList<>();
    static Map<Character, List<Character>> hmap = new HashMap<>();

    public static void main(String[] args) {
     /*   Device device1 = new Device("device1", "RabiDevice");
        Device device2 = new Device("device2", "ArushreeDevice");

        List<Device> devices = List.of(device1, device2);
        Customer c = new Customer(devices);
        var testDevices = c.devices;
        for (Device device : testDevices) {
            device.deviceName = "updatedDevice";
        }
        c = new Customer(testDevices);
        devices.forEach(device -> System.out.println(device.deviceName));*/
        List.of(1);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        List<Integer> subList = list.subList(3,6);
        Collections.reverse(subList);
        list.forEach(System.out::println);
    }

    public static long nCr(int n, int r) {
        long res = 1;

        // calculating nCr:
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return res;
    }

    public static int[][] setMatrixZeroes(int[][] arr) {
        boolean rowHasZero = false;
        boolean columnHasZero = false;
        for (int row = 0; row < arr.length; row++) {
            if(arr[row][0]==0){
                columnHasZero = true;
            }
        }
        for(int col=0; col<arr[0].length;col++){
            if(arr[0][col]==0){
                rowHasZero = true;
            }
        }
        for(int row = 1;row<arr.length;row++){
            for(int col=1; col<arr[0].length; col++){
                if(arr[row][col]==0){
                    arr[row][0] = 0;
                    arr[0][col] = 0;
                }
            }
        }
        for(int row=0;row<arr.length;row++){
            if(arr[row][0]==0){
                for(int i=1;i<arr[row].length;i++){
                    arr[row][i] = 0;
                }
            }
        }
        for(int col=0; col<arr[0].length;col++){
            if(arr[0][col]==0){
                for(int i=1;i<arr.length;i++){
                    arr[i][col] = 0;
                }
            }
        }
        if(rowHasZero){
            for(int i=0;i<arr[0].length;i++){
                arr[0][i]=0;
            }
        }
        if(columnHasZero){
            for(int i=0;i<arr.length;i++){
                arr[i][0]=0;
            }
        }
        return arr;
    }

    static class Customer {
        List<Device> devices;

        public Customer(List<Device> devices) {
            this.devices = devices;
        }


    }

    static class Device {

        String deviceId;
        String deviceName;

        public Device(String deviceId, String deviceName) {
            this.deviceId = deviceId;
            this.deviceName = deviceName;
        }
    }

    public static int findPivot(int[] arr) {
        int i = 0, j = arr.length - 1;
        int leftSum = Integer.MIN_VALUE, rightSum = Integer.MIN_VALUE;
        while (i + 1 <= j) {
            if (rightSum <= leftSum) {
                rightSum += arr[j];
                j--;
            } else {
                leftSum += arr[i];
                i++;
            }
        }
        if (leftSum == rightSum) {
            return i;
        } else {
            return -1;
        }
    }


    public static void sortInPlace(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                int tmp = nums[i];
                nums[i] = nums[tmp - 1];
                nums[tmp - 1] = tmp;
            }
        }
    }

    public static int removeDuplicates1(int[] arr) {
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] != arr[i]) {
                arr[count++] = arr[i];
            }
        }
        return count;
    }

    public static void duplicateZeros(int[] arr) {
        int possibleDups = 0;
        int length_ = arr.length - 1;

        // Find the number of zeros to be duplicated
        // Stopping when left points beyond the last element in the original array
        // which would be part of the modified array
        for (int left = 0; left <= length_ - possibleDups; left++) {

            // Count the zeros
            if (arr[left] == 0) {

                // Edge case: This zero can't be duplicated. We have no more space,
                // as left is pointing to the last element which could be included
                if (left == length_ - possibleDups) {
                    // For this zero we just copy it without duplication.
                    arr[length_] = 0;
                    length_ -= 1;
                    break;
                }
                possibleDups++;
            }
        }

        // Start backwards from the last element which would be part of new array.
        int last = length_ - possibleDups;

        // Copy zero twice, and non zero once.
        for (int i = last; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[i + possibleDups] = 0;
                possibleDups--;
                arr[i + possibleDups] = 0;
            } else {
                arr[i + possibleDups] = arr[i];
            }
        }
    }

    public static String reverseWords3(String s) {
        char[] temp = s.toCharArray();
        int i = 0, j = 0;
        while (i < temp.length && j < temp.length) {
            if (temp[j] == ' ' || j == temp.length) {
                reverse3(i, j - 1, temp);
                i = ++j;
            } else {
                j++;
            }
        }

        return String.valueOf(temp);
    }

    public static void reverse3(int i, int j, char[] temp) {
        while (i < j) {
            char temp1 = temp[i];
            temp[i] = temp[j];
            temp[j] = temp1;
            i++;
            j--;
        }
    }

    public static List<String> reverseWords1(String s) {
        List<String> result = List.of(s.trim().split(" "));
        Collections.reverse(result);
        return result;
    }

    public static String reverseWords(String s) {
        if (s == null) return null;

        char[] a = s.toCharArray();
        int n = a.length;

        // step 1. reverse the whole string
        reverse(a, 0, n - 1);
        // step 2. reverse each word
        reverseWords(a, n);
        // step 3. clean up spaces
        return cleanSpaces(a, n);
    }

    static void reverseWords(char[] a, int n) {
        int i = 0, j = 0;

        while (i < n) {
            while (i < j || i < n && a[i] == ' ') i++; // skip spaces
            while (j < i || j < n && a[j] != ' ') j++; // skip non spaces
            reverse(a, i, j - 1);                      // reverse the word
        }
    }

    // trim leading, trailing and multiple spaces
    static String cleanSpaces(char[] a, int n) {
        int i = 0, j = 0;

        while (j < n) {
            while (j < n && a[j] == ' ') j++;             // skip spaces
            while (j < n && a[j] != ' ') a[i++] = a[j++]; // keep non spaces
            while (j < n && a[j] == ' ') j++;             // skip spaces
            if (j < n) a[i++] = ' ';                      // keep only one space
        }

        return new String(a).substring(0, i);
    }

    // reverse a[] from a[i] to a[j]
    private static void reverse(char[] a, int i, int j) {
        while (i < j) {
            char t = a[i];
            a[i++] = a[j];
            a[j--] = t;
        }
    }

    public static List<Integer> getRow(int k) {
        Integer[] arr = new Integer[k + 1];
        Arrays.fill(arr, 0);
        arr[0] = 1;

        for (int i = 1; i <= k; i++)
            for (int j = i; j > 0; j--)
                arr[j] = arr[j] + arr[j - 1];

        return Arrays.asList(arr);
    }

    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k);
        reverse(nums, k + 1, nums.length - 1);
    }

    public static void reverse(int[] nums, int begin, int end) {
        while (begin < end) {
            int temp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = temp;
            begin++;
            end--;
        }
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int sum = target;
        int result = nums.length + 1;
        for (int i = 0, j = 0; i < nums.length; i++) {
            sum = sum - nums[i];
            while (sum <= 0) {
                result = Math.min(i - j + 1, result);
                sum = sum + nums[j];
                j++;
            }
        }
        return result % (nums.length + 1);
    }

    public static int strStr(String haystack, String needle) {
        if (haystack.length() == needle.length()) {
            return haystack.equals(needle) ? 0 : -1;
        }

        int i = 0;
        int needleLength = needle.length();
        while (i < haystack.length() - needleLength + 1) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < needleLength; j++) {
                sb.append(haystack.charAt(i + j));
            }
            if (sb.toString().equals(needle)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        while (start < end) {
            char temp;
            temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }

    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String firstStr = strs[0];
        String lastStr = strs[strs.length - 1];
        int i = 0;
        for (; i < firstStr.length() && i < lastStr.length(); i++) {
            if (firstStr.charAt(i) != lastStr.charAt(i)) {
                break;
            }
        }
        return firstStr.substring(0, i);
    }

    public int strStr1(String haystack, String needle) {
        if (haystack == null || needle == null || needle.length() > haystack.length() || needle.length() == 0)
            return -1;

        int result = -1;
        int needleL = needle.length();
        int haystackL = haystack.length();
        char[] haystackAr = haystack.toCharArray();
        char[] needleAr = needle.toCharArray();

        for (int i = 0; i < haystackL; i++) {

            if (needleAr[0] == haystackAr[i]) {
                if (needleL == 1) return i;

                for (int j = 1; j < needleL; j++) {
                    if ((i + j < haystackL) && needleAr[j] == haystackAr[i + j]) {
                        result = i;
                    } else {
                        result = -1;
                        break;
                    }
                }
                if (result != -1) return result;
            }

        }
        return result;
    }

    public static String addBinary(String a, String b) {
        char[] str1 = a.toCharArray();
        char[] str2 = b.toCharArray();
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int sum;
        for (int i = str1.length - 1, j = str2.length - 1; i >= 0 || j >= 0; i--, j--) {
            sum = 0;
            if (i >= 0) {
                if (carry == 0) {
                    if (str1[i] == 0) {
                        sum = 0;
                    } else {
                        sum = 1;
                    }
                } else {
                    if (str1[i] == 0) {
                        sum = 1;
                        carry = 0;
                    } else {
                        sum = 0;
                    }
                }
            }
            if (j >= 0) {
                if (sum == 0) {
                    if (str2[j] == 0) {
                        sum = 0;
                    } else {
                        sum = 1;
                    }
                } else {
                    if (str2[j] == 0) {
                        sum = 1;
                    } else {
                        sum = 0;
                        carry = 1;
                    }
                }
            }
            sb.insert(0, Integer.toString(sum));
        }
        if (carry == 1) {
            sb.insert(0, Integer.toString(carry));
        }
        return sb.toString();
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> allrows = new ArrayList<List<Integer>>();
        ArrayList<Integer> row = new ArrayList<Integer>();
        for (int i = 0; i < numRows; i++) {
            row.add(0, 1);
            for (int j = 1; j < row.size() - 1; j++)
                row.set(j, row.get(j) + row.get(j + 1));
            allrows.add(new ArrayList<Integer>(row));
        }
        return allrows;

    }

    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;
        return newNumber;
    }


    public static int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int sq = 0;
        int result[] = new int[nums.length + 1];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                sq = nums[right];
                right--;
            } else {
                sq = nums[left];
                left++;
            }
            result[i] = sq * sq;
        }
        return result;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(i)) {
                list.add(i);
            }
        }
        return list;
    }

    public static int thirdMax(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        if (set.size() > 3) {
            int i = 0;
            for (int element : set.descendingSet()) {
                if (i == 2) {
                    return element;
                }
                i++;
            }
        }
        return set.pollLast();

    }

    public static int heightChecker(int[] heights) {
        int duplicate[] = heights.clone();
        int count = 0;
        Arrays.sort(heights);
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != duplicate[i]) {
                count++;
            }
        }
        return count;
    }

    public static void moveZeroes(int[] nums) {
        int countOfOdd = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                countOfOdd++;
            }
        }
        for (int i = 0, count = 0; i < nums.length && count <= countOfOdd; ) {
            if (nums[i] % 2 == 1) {
                int temp = nums[i];
                count++;
                int j = i;
                for (; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[j] = temp;
            }
            if (nums[i] % 2 == 0) {
                i++;
            }
        }
        System.out.println();
    }

    public static int[] replaceElements(int[] arr) {
        int i = 0;
        int maxIndex = -1;
        for (; i < arr.length; i++) {
            int max = 0;
            if (maxIndex != i) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] > max) {
                        max = arr[j];
                        maxIndex = j;
                    }
                }
            }
            arr[i] = max;
        }
        arr[i - 1] = -1;
        return arr;
    }

    public static void removeDuplicates(int[] nums) {
        int j = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[j] = nums[i + 1];
                j++;
            }
        }
        System.out.println(j);
    }

    public static void backTrack(StringBuilder path, int index) {

        if (path.length() == phoneDigits.length()) {
            combinations.add(path.toString());
            return;
        }
        for (Character c : hmap.get(phoneDigits.charAt(index))) {
            path.append(c);
            backTrack(path, index + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }


    public int maxProfit(int k, int[] prices) {
        int[] profit = new int[k + 1];
        int[] cost = new int[k + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        profit[0] = 0;
        for (int price : prices) {
            for (int i = 0; i < k; i++) {
                cost[i + 1] = Math.min(cost[i + 1], price - profit[i]);
                profit[i + 1] = Math.max(profit[i + 1], price - cost[i + 1]);
            }
        }
        return profit[k];
    }

    public int maxProfit(int[] prices) {
        int t1Profit = 0;
        int t2Profit = 0;
        int t1Cost = Integer.MAX_VALUE;
        int t2Cost = Integer.MAX_VALUE;
        for (int price : prices) {
            t1Cost = Math.min(t1Cost, price);
            t1Profit = Math.max(t1Profit, price - t1Cost);
            t2Cost = Math.min(t2Cost, price - t1Profit);
            t2Profit = Math.max(t2Profit, price - t2Cost);
        }
        return t2Profit;
    }


}