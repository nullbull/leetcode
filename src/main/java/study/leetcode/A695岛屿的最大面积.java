package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/2/15 13:33
 * @desc
 */
public class A695岛屿的最大面积 {

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, dg(grid, i, j));
                }
            }
        }
        return max;
    }

    public int dg(int[][] grid, int i, int j) {
        if (i >= grid.length || j >= grid[0].length || i < 0 || j < 0 || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        return 1 + dg(grid, i + 1, j) + dg(grid, i - 1, j) + dg(grid, i, j + 1) + dg(grid, i, j-1);
    }

    public static void main(String[] args) {
        int i = new A695岛屿的最大面积().maxAreaOfIsland(new int[][]{{0, 1}});
        System.out.println(i);
    }
}
