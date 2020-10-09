package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2020/10/9 10:03
 * @desc
 */

public class A73矩阵置零 {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean[] c = new boolean[m];
        boolean[] r = new boolean[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    if (!c[i]) {
                        c[i] = true;
//                        for (int k = 0; k < m; k++) {
//                            matrix[k][j] = 0;
//                        }
                    }

                    if (!r[j]) {
                        r[j] = true;
//                        for (int k = 0; k < n; k++) {
//                            matrix[i][k] = 0;
//                        }
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            if (c[i]) {
                for (int k = 0; k < n; k++) {
                    matrix[i][k] = 0;
                }
            }
            for (int j = 0; j < n; j++) {
                if (r[j]) {
                    for (int k = 0; k < m; k++) {
                            matrix[k][j] = 0;
                        }
                }
            }
        }

    }

    public static void main(String[] args) {
//        int n[][] = new int[][]{{1, 1,1}, {1, 0, 1}, {1, 1, 1} };
        int n[][] = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5} };
        new A73矩阵置零().setZeroes(n);
    }
}
