package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/2/27 14:13
 * @desc
 */
public class A48旋转图像复习 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++ ) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int j = 0; j < n / 2; j++) {
            for (int i = 0; i < n; i++) {
                int temp = matrix[i][n-1-j];
                matrix[i][n-1-j] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
     }



}
