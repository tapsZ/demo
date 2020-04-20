package com.example.demo;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class MaximumSubarray {

    public static void main(String [] args){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
//        int[] nums = {-2,1};
        System.out.println(maxSubArray( nums));

        System.out.println(StringUtils.capitalize("mywork"));
    }

    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int maxsofar = nums[0];
        for(int i=1;i<nums.length;i++){
            maxsofar = Math.max(maxsofar + nums[i], nums[i]);
            max = Math.max(max, maxsofar);
        }
        return max;
    }

//    public static int maxSubArray(int[] nums) {
//    int maxValue = nums[0];
//        for (int i = 0; i < nums.length; i++) {
//            int sum=0;
//            for (int j = i; j < nums.length; j++) {
//                if(i==j){
//                    sum= nums[i];
//                }else if(j>i) {
//                    sum += nums[j];
//                }
//
//                if (sum > maxValue) {
//                    maxValue = sum;
//                }
//            }
//        }
//    return maxValue;
//    }

}
