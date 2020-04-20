package com.example.demo;

import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MoveZeroes {

    public static void main(String [] args){
        //int[] nums = {0,1,0,3,12};
        int[] nums = {0,1};
        int[] results= moveZeroes(nums);
        System.out.println(results);
    }

//    public static int[] moveZeroes(int[] nums) {
//        int arrLength= nums.length;
//        List<Integer> nonZeroList = Arrays.stream(nums).filter(a-> a>0).boxed().collect(Collectors.toList());
//        int nextPosition = arrLength - nonZeroList.size();
//        while (nextPosition>0){
//            nonZeroList.add(0);
//            nextPosition--;
//        }
//        return nonZeroList.stream().mapToInt(a->a).toArray();
//    }

    public static int[] moveZeroes(int[] nums) {
        int shiftsDone = 0;
        if(nums.length>1) {
            for (int i = 0; i < nums.length; ) {
                if (nums[i] == 0  && i < nums.length - shiftsDone) {
                    shiftRemainingElements(nums, i);
                    shiftsDone++;
                } else {
                    if(i < nums.length-1) {
                        i++;
                    }else {
                        break;
                    }
                }
            }
        }
        return nums;
    }

    private static void shiftRemainingElements(int[] nums, int x) {
       do{
            nums[x] = nums[x+1];
            x++;
        } while(x < nums.length-1);
        nums[nums.length-1]=0;
    }
}
