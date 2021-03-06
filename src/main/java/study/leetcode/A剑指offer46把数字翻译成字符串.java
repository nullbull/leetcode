package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/3/6 18:20
 * @desc
 */
public class A剑指offer46把数字翻译成字符串 {

    public int translateNum(int num) {
        String s = num + "";
        int dp[] = new int[s.length() + 1];
        char[] c = s.toCharArray();
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1 ;i < c.length; i++) {
            String t = c[i-1] + "" +  c[i] + "";
            Integer value = Integer.valueOf(t);
            if (value >= 10 && value < 26) {
                dp[i+1] = dp[i] + dp[i-1] ;
            } else {
                dp[i+1] = dp[i];
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        new A剑指offer46把数字翻译成字符串().translateNum(25);
    }
}
