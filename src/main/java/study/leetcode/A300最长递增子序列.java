package study.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author niuzhenhao
 * @date 2021/1/14 21:25
 * @desc
 */
public class A300最长递增子序列 {


    public int lengthOfLIS(int[] nums) {

        int n = nums.length;
        int max = -1;
        int dp[] = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i]= 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
               max =  Math.max(dp[i], max);
            }
        }

//        SortedSet<Integer> set = new TreeSet<Integer>();
//        for (int i = 0; i < n; i++) {
//            int count = 1;
//            set.add(nums[i]);
//            for (int j = i + 1; j < n; j++) {
//                int first = set.first();
//                int cur = nums[j];
//                if ( cur > first) {
//
//                    if (cur > set.last()) {
//                        set.add(cur);
//                        count++;
//                    } else if (cur < set.last()) {
//                        max = Math.max(count, max);
//                        while (cur <= set.last()) {
//                            set.remove(set.last());
//                            count--;
//                        }
//                        set.add(cur);
//                        count++;
//                    }
//                }
//            }
//            max = Math.max(count, max);
//            set.clear();
//
//        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(        new A300最长递增子序列().lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(        new A300最长递增子序列().lengthOfLIS(new int[]{0,1,0,3,2,3}));
        System.out.println(        new A300最长递增子序列().lengthOfLIS(new int[]{7,7,7,7,7,7}));
        System.out.println(        new A300最长递增子序列().lengthOfLIS(new int[]{3,5,6,2,5,4,19,5,6,7,12}));
        System.out.println(        new A300最长递增子序列().lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));







    }
}
