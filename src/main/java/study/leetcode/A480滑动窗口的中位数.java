package study.leetcode;

import java.util.PriorityQueue;

/**
 * @author niuzhenhao
 * @date 2021/3/4 21:11
 * @desc
 */
public class A480滑动窗口的中位数 {

    public double[] medianSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int cnt = n - k + 1;

        double[] ans = new double[cnt];

        PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        PriorityQueue<Integer> right = new PriorityQueue<>((a,b) -> Integer.compare(a,b));
        for (int i = 0; i < k; i++) {
            right.add(nums[i]);
        }
        for (int i = 0; i < k / 2; i++) {
            left.add(right.poll());
        }
        ans[0] = getMid(left, right);
        for (int i = k; i < n; i++) {
            int add = nums[i];
            int del = nums[i - k];
            if (add >= right.peek()) {
                right.add(add);
            } else {
                left.add(add);
            }
            if (del >= right.peek()) {
                right.remove(del);
            } else {
                left.remove(del);
            }
            adjust(left, right);
            ans[i - k + 1] = getMid(left, right);
        }
        return ans;

    }

    void adjust(PriorityQueue<Integer> left, PriorityQueue<Integer> right) {
        while (left.size() > right.size()) right.add(left.poll());
        while (right.size() - left.size() > 1) left.add(right.poll());
    }

    double getMid(PriorityQueue<Integer> left ,PriorityQueue<Integer> right) {
        if (left.size() == right.size()) {
            return (left.peek() / 2.0) + (right.peek() / 2.0);
        } else {
            return right.peek() * 1.0;
        }
    }
}
