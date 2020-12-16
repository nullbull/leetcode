package study.datastruct;

/**
 * @author niuzhenhao
 * @date 2020/12/15 16:27
 * @desc
 */

public class A递归相加 {


    public static int add(int a, int b) {
        if (a == 0) {
            return b;
        }
        return add(--a, ++b);
    }
    public static void main(String[] args) {
        System.out.println(add(5, 6));
    }
}
