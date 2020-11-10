package com.bj58.mism.api.meishih5.mudu.controllers;

/**
 * @author niuzhenhao
 * @date 2020/11/10 19:36
 * @desc ac
 */

public class A121买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {

        int max = 0;
        int len = prices.length;
        for (int i = 0; i < len; i++) {
            int now = prices[i];
            for (int j = i + 1; j < len; j++) {
                max = Math.max(max,  prices[j] - now);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        new A121买卖股票的最佳时机().maxProfit(new int[]{7, 1, 5, 3, 6, 4});
    }

}
