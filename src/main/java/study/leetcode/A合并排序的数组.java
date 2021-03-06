package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/3/6 19:03
 * @desc
 */
public class A合并排序的数组 {

    public void merge(int[] A, int m, int[] B, int n) {
        int x = m + n - 1;
        m--;
        n--;
        while (m >= 0 && n >= 0) {
            if(A[m] > B[n]) {
                A[x--] = A[m--];
            } else {
                A[x--] =B[n--];
            }
        }
        while (n >= 0) {
            A[x--] = B[n--];
        }
     }
}
