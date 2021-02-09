package study.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author niuzhenhao
 * @date 2021/2/7 22:07
 * @desc
 */
public class A1380矩阵中的幸运数 {


    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int min = Integer.MAX_VALUE;
            int p = 0;
            for (int j = 0; j < n; j++) {
                if (min > matrix[i][j]) {
                    min = matrix[i][j];
                    p = j;
                }
            }
            boolean isSmall = true;
            for (int k = 0; k < m; k++) {
                if (matrix[k][p] > min) {
                    isSmall = false;
                    break;
                }
            }
            if (isSmall) {
                res.add(min);
            }
        }
        return res;
    }
}
