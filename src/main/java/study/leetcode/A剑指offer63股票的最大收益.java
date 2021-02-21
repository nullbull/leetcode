package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/2/21 17:01
 * @desc
 */
public class A剑指offer63股票的最大收益 {


    public int maxProfit2(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length ;i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] < prices[j]) {
                    max = Math.max(prices[j] - prices[i], max);
                }
            }
        }
        return max;
    }
    public int maxProfit(int[] prices) {
        int max = 0;
        int min = 0;
        for (int i = 0; i < prices.length ;i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }

}
