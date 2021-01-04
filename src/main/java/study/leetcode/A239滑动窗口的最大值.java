package study.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author niuzhenhao
 * @date 2021/1/4 19:39
 * @desc
 */

public class A239滑动窗口的最大值 {

    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        LinkedList<Integer> list = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        boolean firstT = true;
        for (int i = 0; i < n; i++) {
            list.add(nums[i]);
            max = Math.max(max, nums[i]);
            if (list.size() >= k) {
                if (!firstT) {
                    Integer first = list.removeFirst();
                    if (first == max) {
                        max = list.stream().max(Integer::compareTo).get();
                    }

                }
                firstT = false;
                res.add(max);
            }
        }
        int[] ints = res.stream().mapToInt(a -> a).toArray();
        return ints;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums == null || nums.length == 0) {
            return nums;
        }

        int n = nums.length;
        LinkedList<Integer> list = new LinkedList<>();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < k && i < n; i++) {
            if (i == 0) {
                list.add(nums[i]);
                continue;
            }
            while (!list.isEmpty() && nums[i] > list.getLast()) {
                list.pollLast();
            }
            list.add(nums[i]);
        }
        res.add(list.getFirst());

        for (int i = k; i < n; i++) {
            if (!list.isEmpty() && nums[i-k] == list.getFirst()) {
                list.pollFirst();
            }
            while (!list.isEmpty() && nums[i] > list.getLast()) {
                list.pollLast();
            }
            list.add(nums[i]);
            res.add(list.getFirst());
        }
        int[] ints = res.stream().mapToInt(a -> a).toArray();
        return ints;
    }

    public static void main(String[] args) {
//        int nums[] = new int[] {1, 3, -1, -3, 5, 3, 6, 7};
//        int nums[] = new int[] {-7,-8,7,5,7,1,6,0};
//        int nums[] = new int[] {9,10,9,-7,-4,-8,2,-6};
//        int nums[] = new int[] {7, 2, 4};
//        int nums[] = new int[] {1, -1};
        int nums[] = new int[] {1,3,1,2,0,5};
        int[] ints = new A239滑动窗口的最大值().maxSlidingWindow(nums, 3);
    }
}
