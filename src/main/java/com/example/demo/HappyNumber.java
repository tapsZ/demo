package com.example.demo;

import ch.qos.logback.core.net.SyslogOutputStream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HappyNumber {

    public static void main(String [] args){
        int n = 19;
        System.out.println(isHappy(n));
    }

    private static boolean isHappy(int n) {
        List<Integer> operatedNumber= new ArrayList<>();
        boolean isHappy=false;
        if (n == 1) {
            isHappy = true;
        } else {
                isHappy = happy(n, operatedNumber);
        }
        return isHappy;
    }

    private static boolean happy(int n, List<Integer> operatedNumber) {
        boolean isHappy=false;
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
