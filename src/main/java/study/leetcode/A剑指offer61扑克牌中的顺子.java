package study.leetcode;

import java.util.*;

/**
 * @author niuzhenhao
 * @date 2021/2/14 15:40
 * @desc
 */
public class A剑指offer61扑克牌中的顺子 {

    public boolean isStraight(int[] nums) {

        Arrays.sort(nums);
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer count = map.get(nums[i]);
            if (count == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], count + 1);
            }
        }

        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            if (next.getKey() != 0 && next.getValue() > 1) {
                return false;
            }
        }
        if (map.get(0) == null) {
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] - nums[i-1] > 1) {
                    return false;
                }
            }
            return true;
        } else {
            Integer zeroSize = map.get(0);
            int zeroFull = zeroSize;
            for (int i = zeroSize; i < nums.length -1; i++) {
                if (nums[i+1] - nums[i] > 1) {
                    zeroFull -= (nums[i+1]-nums[i]-1);
                }
                if (zeroFull < 0) {
                    return false;
                }
            }
            return true;
        }

    }

    public static void main(String[] args) {
//        System.out.println(new A剑指offer61扑克牌中的顺子().isStraight(new int[]{1, 2, 2, 0, 5}));
        System.out.println(new A剑指offer61扑克牌中的顺子().isStraight(new int[]{4, 2, 3, 3, 4}));
    }
}
