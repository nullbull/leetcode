package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/1/21 22:01
 * @desc
 */
public class A240搜索二维矩阵2 {

    public boolean searchMatrix(int[][] matrix, int target) {



        int m = matrix.length;
        int n = matrix[0].length;



        if (m > 1 && n > 1) {

            if (target < matrix[0][0]) {
                return false;
            }


            int targetM = -1;
            int targetN = -1;

            for (int i = 0; i < n; i++) {
                if (target < matrix[0][i]) {
                    targetN = i - 1;
                    break;
                }
            }
            if (targetN == -1) {
                targetN = n - 1;
            }



            int x = 0;
            int y = m - 1;
            while (x <= y) {
                int mid = (x + y) / 2;
                if (matrix[mid][targetN] == target) {
                    return true;
                } else if (matrix[mid][targetN] > target) {
                    y = mid - 1;
                } else {
                    x = mid + 1;
                }
            }



            for (int i = 0; i < m; i++) {
                if (target < matrix[i][0]) {
                    targetM = i - 1;
                    break;
                }
            }

            if (targetM == -1) {
                targetM = m - 1;
            }

            while (targetM >= 0) {
                x = 0;
                y = n - 1;
                while (x <= y) {
                    int mid = (x + y) / 2;
                    if (matrix[targetM][mid] == target) {
                        return true;
                    } else if (matrix[targetM][mid] > target) {
                        y = mid - 1;
                    } else {
                        x = mid + 1;
                    }
                }
                targetM--;
            }
        } else {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++ ) {
                    if (target == matrix[i][j]) {
                        return true;
                    }
                }
            }
        }

        return false;

    }

    public static void main(String[] args) {
//        int[][] mat = {new int[]{1,4,7,11,15},new int[]{2,5,8,12,19},new int[]{3,6,9,16,22},new int[]{10,13,14,17,24},new int[]{18,21,23,26,30}};
//        int[][] mat = {new int[]{1,2,3,4,5},new int[]{6,7,8,9,10},new int[]{11,12,13,14,15},new int[]{16,17,18,19,20},new int[]{21,22,23,24,25}};
        int[][] mat = {{1,3,5,7,9},{2,4,6,8,10},{11,13,15,17,19},{12,14,16,18,20},{21,22,23,24,25}};

//        boolean b = new A240搜索二维矩阵2().searchMatrix(mat, 20);


//        System.out.println( new A240搜索二维矩阵2().searchMatrix(new int[][]{{5}}, 20));
        System.out.println( new A240搜索二维矩阵2().searchMatrix(mat, 13));
    }



}
