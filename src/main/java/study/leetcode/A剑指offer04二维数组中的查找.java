package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/3/6 15:46
 * @desc
 */
public class A剑指offer04二维数组中的查找 {

    public boolean findNumberIn2DArray2(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }


        int m = matrix.length;
        int n = matrix.length;


        int pn = n - 1;
        int pm = m - 1;
        for (int i = 1; i < n; i++) {
            if (target < matrix[0][i]) {
                pn = i - 1;
                break;
            } else if (target == matrix[0][i]) {
                return true;
            }
        }

        int l = 0;
        int r = m - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (matrix[mid][pn] < target) {
                l = mid + 1;
            } else if (matrix[mid][pn] > target) {
                r = mid - 1;
            } else {
                return true;
            }
        }

        for (int i = 1; i < m; i++) {
            if (target <= matrix[i][0]) {
                pm = i - 1;
                break;
            } else if (target == matrix[i][0]) {
                return true;
            }

        }

        l = 0;
        r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (matrix[pm][mid] < target) {
                l = mid + 1;
            } else if (matrix[pm][mid] > target) {
                r = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }


    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }


        int m = matrix.length;
        int n = matrix[0].length;
        int i = m - 1;
        int j = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] > target) {
                i--;
            } else if (matrix[i][j] < target) {
                j--;
            } else {
                return true;
            }
        }
        return false;

    }
}
