package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/2/9 20:38
 * @desc
 */
public class A121复习 {
    public int maxProfit(int[] nums) {
        int n = nums.length;
        int minPrice = Integer.MAX_VALUE;
        int maxPrice = 0;
        for (int i = 0; i < n; i++) {
            if (minPrice > nums[i]) {
                minPrice = nums[i] ;
            } else {
                maxPrice = Math.max(maxPrice, nums[i] - minPrice);
            }
        }
        return maxPrice;
    }

}
