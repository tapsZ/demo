package com.example.demo;

import java.util.ArrayList;
import java.util.List;

/**
 *Write an algorithm to determine if a number n is "happy".
 *
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 *
 * Return True if n is a happy number, and False if not.
 *
 * Example:
 *
 * Input: 19
 * Output: true
 * Explanation:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 */
public class HappyNumber {

    public static void main(String [] args){
        int n = 19;
        System.out.println(isHappy(n));
    }

    private static boolean isHappy(int n) {
        List<Integer> operatedNumber= new ArrayList<>();
        boolean isHappy;
        if (n == 1) {
            isHappy = true;
        } else {
                isHappy = happy(n, operatedNumber);
        }
        return isHappy;
    }

    private static boolean happy(int n, List<Integer> operatedNumber) {
        boolean isHappy;
        if (n == 1) {
            isHappy = true;
        } else if(operatedNumber.contains(n)){
                     isHappy = false;
        }else{
            operatedNumber.add(n);
            int sum = getSum(n);
            if (sum == 1) {
                isHappy = true;
            } else {
                isHappy = happy(sum, operatedNumber);
            }
        }
        return isHappy;
    }

    private static int getSum(int n) {
        int sum = 0;
        while (n != 0) {
            int lastDigit = n % 10;
            sum = sum + lastDigit * lastDigit;
            n /= 10;
        }
        return sum;
    }

//    public static boolean isHappy(int n) {
//       n = getSumNumber(n, 0);
//       if(n==1){
//           return true;
//       }else{
//           return false;
//       }
//    }
//
//    private static int getSumNumber(int n, int sum) {
//            int tobeOperated = n / 10;
//            int lastDigit = n % 10;
//            sum = sum + lastDigit * lastDigit;
//            if (tobeOperated == 0) {
//                if(sum != 1 ) {
//                    try {
//                        sum = getSumNumber(sum, 0);
//                    } catch (StackOverflowError e) {
//                        return sum;
//                    }
//                }else {
//                    return 1;
//                }
//            } else if (tobeOperated > 0) {
//                sum = getSumNumber(tobeOperated, sum);
//            }
//            return sum;
//    }



}
