package com.example.demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class SingleNumber {

    public static void main(String [] args){
        int[] arr1={4,1,2,1,2};
        int[] arr2={2,2,1};
        System.out.println(singleNumber(arr1));
//        System.out.println(singleNumber(arr2));
    }
//    public static int singleNumber(int[] numbers) {
//        int singleNumber= 0;
//        if(numbers.length==1){
//            singleNumber= numbers[0];
//        }
//       List<Integer> sortedList =  Arrays.stream(numbers).sorted().boxed().collect(Collectors.toList());
//        for (int i = 1; i < sortedList.size()-1; i++) {
//            if(!sortedList.get(0).equals(sortedList.get(1))) {
//                singleNumber = sortedList.get(0);
//                break;
//            }
//
//            if(!sortedList.get(i).equals(sortedList.get(i + 1)) && !sortedList.get(i).equals(sortedList.get(i - 1))) {
//                singleNumber = sortedList.get(i);
//                break;
//            }
//
//            if(i == sortedList.size()-2){
//                singleNumber = sortedList.get(i+1);
//            }
//        }
//        return singleNumber;
//    }

//    public static int singleNumber(int[] numbers) {
//        int a = 0;
//        for (int i : numbers) {
//            a ^= i;
//        }
//        return a;
//    }

    public static int singleNumber(int[] nums) {
        HashMap<Integer, Integer> hash_table = new HashMap<>();

        for (int i : nums) {
            hash_table.put(i, hash_table.getOrDefault(i, 0) + 1);
        }
        for (int i : nums) {
            if (hash_table.get(i) == 1) {
                return i;
            }
        }
        return 0;
    }
}
