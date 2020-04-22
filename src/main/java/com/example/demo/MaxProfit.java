package com.example.demo;

public class MaxProfit {
    public static void main(String[] args) {
//        int [] arr = {7,1,5,3,6,4};
//        int [] arr = {1,2,3,4,5};
//        int [] arr = {7,6,4,3,1};
        int[] arr = {8, 6, 4, 3, 3, 2, 3, 5, 8, 3, 8, 2, 6};

        int profit = maxProfit(arr);
        System.out.println(profit);
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        Integer buyingPrice = null;
        for (int i = 0; i < prices.length; i++) {
            //Buying
            if (buyingPrice == null && i < prices.length - 1) {
                if (prices[i] >= prices[i + 1]) {
                    continue;
                } else {
                    buyingPrice = prices[i];
                }
            }

            //Selling
            if (buyingPrice != null && prices[i] > buyingPrice) {
                if (i < prices.length - 1) {
                    if (prices[i] < prices[i + 1]) {
                        continue;
                    } else {
                        profit += prices[i] - buyingPrice;
                        buyingPrice = null;
                    }
                } else {
                    profit += prices[i] - buyingPrice;
                    buyingPrice = null;
                }
            } else {
                continue;
            }
        }
        return profit;
    }
}
