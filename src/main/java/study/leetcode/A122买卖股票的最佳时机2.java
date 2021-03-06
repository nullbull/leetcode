package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/2/17 13:49
 * @desc
 */
public class A122买卖股票的最佳时机2 {

    public int maxProfit2(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1 ;i ++) {
            if (prices[i] > prices[i+1]) {
                continue;
            }
            int temp = 0;
            int p = i + 1;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i]) {
                    if (temp < prices[j]-prices[i]) {
                        temp = prices[j]-prices[i];
                        p = j;
                        break;
                    }
                }
            }
            i = p;
            max += temp;
        }
        return max;
    }

    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                res += prices[i] - prices[i-1];
            }
        }
        return res;
    }



    public static void main(String[] args) {
        System.out.println(new A122买卖股票的最佳时机2().maxProfit(new int[]{7,1,5,3,6,4}));
    }

}
