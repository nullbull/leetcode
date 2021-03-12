package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/3/12 10:01
 * @desc
 */

public class A547省会数量 {
    public int findCircleNum(int[][] city) {
        int n = city.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (city[i][j] == 1) {
                    dfs(city, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int[][] city, int i, int j) {
        int n = city.length;
        for (int k = 0; k < n; k++) {
            if (city[i][k] == 1) {
                city[i][i] = 0;
                city[k][k] = 0;
                city[i][k] = 0;
                if (i != k) {
                    dfs(city, k, i);
                }
            }
        }
    }
}
