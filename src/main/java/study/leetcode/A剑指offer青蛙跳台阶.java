package study.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author niuzhenhao
 * @date 2020/12/24 10:19
 * @desc
 */

public class A剑指offer青蛙跳台阶 {
    static int hhh = 1000000007;

    /**
     * 模拟递归
     * @param n
     * @return
     */
    public static int numWays3(int n) {
        int temp = n;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        int count = 0;
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            while (!queue.isEmpty()) {
                Integer poll = queue.poll();
                list.add(poll);
            }
            for (Integer a : list) {
                if (a > 2) {
                    queue.add(a-2);
                    queue.add(a-1);
                } else {
                    if (a == 2) {
                        count += a;
                    }
                    if (a == 1 || a == 0) {
                        count += 1;
                    }
                }
            }
        }
        return count % hhh;

    }

    /**
     * 递归解法
     * @param n
     * @return
     */
    public int dg(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (n == 2) {
            return n;
        }
        return dg(n -1) + dg(n-2);
    }


    /**
     *动态规划解法
     * @param n
     * @return
     */
    public static int numWays(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % hhh;
        }
        return dp[n] ;
    }


    public static void main(String[] args) {
        System.out.println(numWays(46));
    }
}
