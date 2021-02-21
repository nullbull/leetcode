package study.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author niuzhenhao
 * @date 2021/2/21 13:26
 * @desc
 */
public class A剑指offer56数组中只出现一次的数字 {
    public int[] singleNumbers(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int pos = Math.abs(nums[i]) % n ;
            if (pos != i) {
                if (nums[pos] == nums[i]|| nums[pos] == -nums[i]) {
                    nums[pos] =  -nums[pos] ;
                } else {
                    int temp = nums[pos];
                    nums[pos] = -nums[i];
                    nums[i] = temp;
                }

            } else {
                nums[i] = - nums[i];
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++ ) {
            if (nums[i] < 0) {
                res.add(nums[i]);
            }
        }
        int[] realRes = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            realRes[i] = -res.get(i);
        }
        return realRes;
    }

    public static void main(String[] args) {
        new A剑指offer56数组中只出现一次的数字().singleNumbers(new int[] {3, 2, 1, 3});
    }
}
