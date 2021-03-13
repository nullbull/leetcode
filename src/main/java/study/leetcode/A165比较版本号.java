package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/3/13 19:36
 * @desc
 */
public class A165比较版本号 {


    public int compareVersion(String v1, String v2) {
        String[] c1 = v1.split("\\.");
        String[] c2 = v2.split("\\.");
        int n = Math.max(c1.length, c2.length);
        for (int i = 0; i < n; i++) {
            int a = i < c1.length  ? Integer.parseInt(c1[i] ) : 0;
            int b = i < c2.length  ? Integer.parseInt(c2[i] ) : 0;
            if (a != b) {
                return a > b ? 1 : -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        new A165比较版本号().compareVersion("0.1", "1.1");
    }
}
