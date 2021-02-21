package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/2/21 11:06
 * @desc
 */
public class 剑指offer65不用加减乘除做加法 {



    public int add(int a, int b) {
        while (b != 0) {
            int c = (a & b) << 1;
            System.out.println(c);
            a = a ^ b;
            System.out.println(a);
            b = c;
        }
        return a;

    }

    public static void main(String[] args) {
        System.out.println(new 剑指offer65不用加减乘除做加法().add(9, 13));
    }
}
