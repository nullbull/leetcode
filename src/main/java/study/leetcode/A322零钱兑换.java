package study.leetcode;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author niuzhenhao
 * @date 2021/1/12 22:01
 * @desc
 */
public class A322零钱兑换 {

    Integer min = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {

        Arrays.sort(coins);
        int n = coins.length - 1;
        int count = 0;
        if (amount == 0) {
            return 0;
        }
        if (coins[0] > amount) {
            return -1;
        }
//        int[] coinTime = new int[n+1];
//        int cur = n;
//        while (amount > 0) {
//            while (amount >= 0 && cur >= 0) {
//                int now = amount / coins[cur];
//                coinTime[cur] = coinTime[cur] + now;
//                int left = amount % coins[cur];
//                amount = left;
//                count += now;
//                cur--;
//            }
//            if (amount > 0) {
//                while (coins[n] > 0) {
//                    amount += coins[n];
//                    coinTime[n] = coinTime[n] - 1;
//                    cur = n;
//                }
//
//            }
//        }
        dfs(coins, amount, 0, n);
//        mincoin(coins, amount, n, 0);
        return min == Integer.MAX_VALUE ? -1 : min;
    }




    public void dfs(int[] coins, int amount, int time, int p) {
        if (amount == 0) {
            min = Math.min(time, min);
            return;
        }
        if (p < 0) {
            return;
        }

        for (int i = amount / coins[p]; i >= 0 && i + time < min; i--) {
            dfs(coins, amount - i * coins[p], time + i, p - 1);
        }
    }

    private void mincoin(int[] coins,int amount, int index, int count) {
        if(amount==0){
            min = Math.min(min,count);
            return;
        }
        if(index<0){
            return;
        }
        for(int i = amount/coins[index];i>=0 && i+count<min; i--){
            mincoin(coins,amount - (i*coins[index]), index-1, count+i);
        }
    }


    public static void main(String[] args) {

//        System.out.println(        new A322零钱兑换().coinChange(new int[]{186, 419, 83, 408}, 6249));
        System.out.println(        new A322零钱兑换().coinChange(new int[]{1, 2, 5}, 11));
//        System.out.println(        new A322零钱兑换().coinChange(new int[]{ 2}, 3));
//        System.out.println(        new A322零钱兑换().coinChange(new int[]{ 1}, 0));
//        System.out.println(        new A322零钱兑换().coinChange(new int[]{ 1}, 2));

    }
}
