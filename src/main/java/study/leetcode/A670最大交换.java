package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/1/19 21:48
 * @desc
 */
public class A670最大交换 {

    public int maximumSwap(int num) {
        String s = num + "";
        char[] c = s.toCharArray();
        int cur = 0;
        boolean find = false;
        while (cur < c.length && !find) {
            char now = c[cur];
            char max = now;
            int pos = cur;
            for (int i = cur + 1; i < c.length; i++ ) {
                if (c[i] >= max) {
                    max = c[i];
                    find = true;
                    pos = i;
                }
            }
            if (find ) {
                if (max > c[cur]) {
                    char temp = c[pos];
                    c[pos] = now;
                    c[cur] = temp;
                } else {
                    find = false;
                }
            }
            cur++;
        }
        return Integer.parseInt(new String(c));
    }


    public static void main(String[] args) {
        System.out.println(new A670最大交换().maximumSwap(1993));
        System.out.println(new A670最大交换().maximumSwap(2736));
        System.out.println(new A670最大交换().maximumSwap(9973));
        System.out.println(new A670最大交换().maximumSwap(0));
    }
}
