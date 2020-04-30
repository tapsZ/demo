package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class CountingElements {
    public static void main(String[] args) {
//        int [] arr={1,2,3};
//        int [] arr={1,3,2,3,5,0};
        int[] arr = {1, 1, 2};
        System.out.println(countElements(arr));
    }

    public static int countElements(int[] arr) {
        int totalMatches = 0;
        Arrays.sort(arr);
        List<Integer> unMatching = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (unMatching.contains(arr[i] - 1)) {
                int numberToRemove = arr[i] - 1;
                long matches = unMatching.stream().filter(a -> a == numberToRemove).count();
                unMatching.clear();
                totalMatches += matches;
            }
            unMatching.add(arr[i]);
        }
        return totalMatches;
    }
}
