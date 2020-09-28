package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2020/8/28 15:22
 * @desc
 */

public class A48旋转图像 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] temp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[j][n - i - 1] = temp[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        new A48旋转图像().rotate(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }

}
