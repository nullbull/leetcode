package study.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 * @author niuzhenhao
 * @date 2020/11/16 20:01
 * @desc
 */

public class A215数组中第k大元素 {

    public int findKthLargest(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        list.sort(Integer::compareTo);
        Collections.reverse(list);
        return list.get(k -1 );
    }

    public static void main(String[] args) {
        new A215数组中第k大元素().findKthLargest(new int[]{3,2,3,1,2,4,5,5,6, 4}, 4);
    }
}
