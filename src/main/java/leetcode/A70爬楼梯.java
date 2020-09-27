package leetcode;

public class A70爬楼梯 {

/*    public int climbStairs(int n) {

        return dg(n);
    }

    private int dg(int i) {
        if (i == 1) {
            return 1;
        }
        if (i == 2) {
            return 2;
        }

        if (i == 0) {
            return 0;
        }
        return dg(i - 1) + dg(i - 2);
    }*/

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n ];
    }






    public static void main(String[] args) {


        System.out.println(new A70爬楼梯().climbStairs(45));
    }
}
