package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2020/12/28 10:36
 * @desc
 */

public class A74搜索二维矩阵 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int i = 0;
        for (;i < m; i++) {
            if (target == matrix[i][0]) {
                return true;
            }
            if (target < matrix[i][0]) {
                if (i == 0) {
                    return false;
                }
                break;
            }
        }
        i--;
        int k = 0;
        int j = n - 1;

        while (k < j) {
            int mid = (k + j) / 2;
            if (matrix[i][mid] == target) {
                return true;
            }
            if (matrix[i][mid] < target) {
                k = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[][] matrix = new int[][]{ {1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        int[][] matrix = new int[][]{ {1, 3}};
        System.out.println(new A74搜索二维矩阵().searchMatrix(matrix, 3));
    }
}
