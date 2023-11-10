package com.algorithm.practice.test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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


        Iterator<Integer> itrAsc= unsorted.iterator();
        int j = 0, k= 0;
        for(int i=0; i<unsorted.size();i++){
            if(j< unsorted.size()){
                result[j] = sortedDesc.get(j);
                j++;}
            if(i+1<unsorted.size() && k < unsorted.size()){
                result[i+1] = sortedAsc.get(k);
                k++;}
        }

        List<Integer> intList = new ArrayList<Integer>(result.length);
        for (int i : result)
        {
            intList.add(i);
        }
        return intList;
    }

    // I have implemented improved bubble sort here we could have used merge sort to reduce complexity.
    // Used this to keep simple and limited time
    public static List<Integer> sortAsc(List<Integer> unsorted){
        Integer[] duplicate = new Integer[unsorted.size()];
        for(int i =0; i< unsorted.size();i++){
            duplicate[i] = unsorted.get(i);
        }
        int endPosition = unsorted.size() -1;
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

    public static List<Integer> sortDesc(List<Integer> unsorted){
        Integer[] duplicate = new Integer[unsorted.size()];
        for(int i =0; i< unsorted.size();i++){
            duplicate[i] = unsorted.get(i);
        }

        int endPosition = unsorted.size() -1;
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


    public static void updateSoldProduct(SoldProduct sp){
     //   sp.setCurrency("INR");
    }

    public static void testMaps(){
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
        ssp1.setSoldProduct(List.of(sp1,sp2));

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
        map1.put("One", List.of(1,3));

        map1.get("One").add(4);

        System.out.println(map1);
    }

    public static String escapeMetaCharacters(String inputString){
        final String[] metaCharacters = {":","~",".",",","-","_","\\","/","^","$","{","}","[","]","(",")","*","+","?","|","<",">","&","%"};
        for (int i = 0 ; i < metaCharacters.length ; i++){
            if(inputString.contains(metaCharacters[i])){
                inputString = inputString.replace(metaCharacters[i],"\\"+metaCharacters[i]);
            }
        }
        return inputString;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
 /*       String myString = "9v2JSOGfD*Tq9r8k";
        System.out.println(myString.getBytes("UTF-16").length);

        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        String base64Key = Encoders.BASE64.encode(key.getEncoded());
        System.out.println(base64Key); */

        try{
            throw new IOException("io issue..");

        }catch(IOException e){
            throw new BadRequestException("Bad request");
        }


    //    SoldProduct sp1 = new SoldProduct("Lux", "1", "23");
    //    sp1.asRawMaterial();

       // System.out.println(new Timestamp(DateTime.now().getMillis()));

    //    System.out.println(new Timestamp(DateTime.now().getMillis()));
   //     System.out.println(LocalDateTime.now());

    //    List<Boolean> testBooleanStream = List.of(true,false);
    //    Boolean result = testBooleanStream.stream().allMatch(b->b);
    //    System.out.println(result);



   /*     String mydata = "E0B7B1-DAWNSTB-AT000419373540";
        Pattern pattern = Pattern.compile("-(.*?)-");
   //     Pattern pattern = Pattern.compile("/-([^-]+)-/");
        Matcher matcher = pattern.matcher(mydata);
        if (matcher.find())
        {
            System.out.println(matcher.group(1));
        }*/

      //  testMaps();

    /*    SoldProduct sp = new SoldProduct();
        sp.setCurrency("EUR");
        sp.setName("sp1");
        sp.setPrice(BigDecimal.TEN);

        updateSoldProduct(sp);
        System.out.println(sp.getCurrency());*/

    /*    Map <Integer, Integer> temp = new HashMap<>();
        var values =  temp.values();

        values.stream().sorted().collect(Collectors.toList());
        int sum = 0;
        Integer[] arr = new Integer[]{1, 2, 3, 4};

        List<String> temp1 = new ArrayList<>();

        List<Integer> integerList = List.of(arr);

        meanderingArray(integerList);
*/
       /* List<List<Integer>> sequenceList = new ArrayList();
        sequenceList.add(new ArrayList<Integer>());
        sequenceList.add(new ArrayList<Integer>());
        List<Integer> result = new ArrayList<>();

        sequenceList.get(1).add(1);
        sequenceList = sequenceList.stream().map(s -> s.stream().map(e -> {
            return e + 3;
        }).collect(Collectors.toList())).collect(Collectors.toList());
        sequenceList.forEach(s -> s.forEach(e -> System.out.println(e)));*/

/*
        Map<Integer, Integer> testMap = new HashMap<>();
        for (int i : arr) {
            if (testMap.get(i) != null) {
                testMap.put(i, testMap.get(i) + 1);
            } else {
                testMap.put(i, 1);
            }
        }
        System.out.println(testMap.values().stream().map(v -> v / 2).mapToInt(Integer::intValue).sum());
        Optional<Integer> testOpt = Optional.empty();
        testOpt = Optional.of(6);
        Integer marks = testOpt.orElse(null);*/

        //     arr = Juggle.rotate(arr, 2);
        //   ArrayRotation.rightRotateByReverse(arr, 2);

        //   System.out.println("Result: "+ BinarySearch.search(arr, 8));

        //   int[] arr1= SelectionSort.sort(arr);
        //   MergeSortWithoutSentinel.sort(arr,0, arr.length-1);

        //   for(int i = 0; i < arr.length; i++){
        //        System.out.print(arr[i]+" ");
        //    }

    /*    System.out.println(LCM.gcd_approach(21, 28));
        System.out.println(LCM.bruteforce(21, 28));
        System.out.println(HCF.recursive(21,28));
        System.out.println(HCF.iterative(21, 28)); */

      /*  for(int j= 0; j<arr.length;j++){
            for(int i = 0; i < arr.length-1; i++){
                int temp = arr[i];
                if(arr[i]>arr[i+1]){
                    arr[i]=arr[i+1];
                    arr[i+1]=temp;
                }
            }
        }
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
        */

      /*  Scanner sc = new Scanner(System.in);
        String s  = sc.nextLine();
        Map<String, Integer> charMap = new HashMap<>();
        for (int i = 0; i < s.length() ; i++){
            if(charMap.get(String.valueOf(s.charAt(i))) == null ){
                charMap.put(String.valueOf(s.charAt(i)), 1);
            }else{
                int value = charMap.get(String.valueOf(s.charAt(i)));
                value++;
                charMap.put(String.valueOf(s.charAt(i)), value);
            }
        }
        charMap.forEach((k,v)-> System.out.println(k+" "+v));
        Collection<Integer> values = charMap.values();
        Object[] valuesArray = values.toArray();


        boolean result = true;
        List<Integer> index = new ArrayList<>();
        for(int j= 0 ; j<valuesArray.length; j++) {
            int temp = (int)valuesArray[j];
            int flag = 0;
            for (int i = 0; i < valuesArray.length; i++) {
                if (temp != (int) valuesArray[i]) {
                    index.add((int) valuesArray[i]);
                    flag++;
                    if (Math.abs(temp - (int) valuesArray[i]) > 1) {
                        result = false;
                    }
                }
            }
            if (flag > 1) {
                result = false;
            }
            if (flag == 1 && index.get(j) == 1) {
                result = true;
            }
            if (flag == valuesArray.length - 1 && (int) valuesArray[j] == 1) {
                result = true;
            }
            if(j>=1){
            if (flag == valuesArray.length - 1 && ((int) valuesArray[j]-(int)valuesArray[j-1]) == 1) {
                result = true;
            }}
            if(result == false)
                break;
        } */

        //  System.out.println(result);
        //   int i = testReturn();
        //  System.out.println(i);


        /* List<Integer> integerList = Arrays.asList(1,3);
        integerList.size();
        long i = 4;
        long j = 5;
        BigInteger result = BigInteger.valueOf(i + j);
        System.out.println(result); */
       /* DecimalFormat df = new DecimalFormat("#.####");
        int i =2;
        int j = 6;
        double d = Double.valueOf(i)/Double.valueOf(j);

        System.out.println(d);
        System.out.println(String.format("%.5g%n", 0.912300));
        */


        /*
        InsertionSort.sort(a);
        Arrays.stream(a).forEach(f->System.out.print(f));
        */

        /*
        final Matcher matcher = PATTERN.matcher("dsvhhv -");
        if (matcher.find()){
            System.out.println("Valid");
        }else{
            System.out.println("Invalid");
        }
        */
        /*
        Scanner input = new Scanner(System.in);
        while(true){
            int number = input.nextInt();
            if(number == 42 || number<-99 || number>99){ break;}
            System.out.println(number);
        }*/

    }


}
