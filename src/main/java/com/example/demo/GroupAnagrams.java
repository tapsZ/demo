package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] arr = {"cab", "tin", "pew", "duh", "may", "ill", "buy", "bar", "max", "doc"};
        List<List<String>> answer = groupAnagrams(arr);
        System.out.println(answer);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> groupedAnagrams = new HashMap<>();
        //group
        for (int i = 0; i < strs.length; i++) {
            char[] stringArray = strs[i].toCharArray();
            String key;
            if (stringArray.length > 0) {
                Arrays.sort(stringArray);
                key = String.valueOf(stringArray);
            } else {
                key = "";
            }
            if (groupedAnagrams.containsKey(key)) {
                groupedAnagrams.get(key).add(strs[i]);
            } else {
                setNewArray(groupedAnagrams, strs[i], key);
            }
        }
        return groupedAnagrams.values().stream().collect(Collectors.toList());
    }

    private static void setNewArray(HashMap<String, List<String>> groupedAnagrams, String stringArray, String key) {
        List<String> listOfStrings = new ArrayList<>();
        listOfStrings.add(stringArray);
        groupedAnagrams.put(key, listOfStrings);
    }

}
