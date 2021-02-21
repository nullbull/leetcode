package study.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author niuzhenhao
 * @date 2021/2/16 21:04
 * @desc
 */
public class A54螺旋矩阵 {

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int size = m * n;
        int count = 0;
        List<Integer> res = new ArrayList<>(m * n);
        int i = 0, j = 0;
        int left = 0,  right = 0;
        int top = m-1, bottom = n-1;

        while (count < size) {
            count++;
            if (i == left && j < bottom) {
                res.add(matrix[i][j]);
                j++;
            }
            else if (j == bottom && i < top) {
                res.add(matrix[i][j]);
                i++;
            }
            else if (i == top && j > right) {
                res.add(matrix[i][j]);
                j--;
            }
            else if (j == right && i > left) {
                res.add(matrix[i][j]);
                i--;
            } else {
                res.add(matrix[i][j]);
            }
            //当一圈转完了，调整变量倒下一圈
            if (i == left  && j == right) {
                left++;
                right++;
                top--;
                bottom--;
                i = left;
                j = right;
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(new A54螺旋矩阵().spiralOrder(new int[][]{{1,2,3,12},{4,5,6,13},{7,8,9,14}}));
        System.out.println(new A54螺旋矩阵().spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
        System.out.println(new A54螺旋矩阵().spiralOrder(new int[][]{{1}}));
        System.out.println(new A54螺旋矩阵().spiralOrder(new int[][]{{1},{2},{3}}));
    }

}
