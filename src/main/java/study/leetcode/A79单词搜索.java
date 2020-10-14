package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2020/10/14 18:32
 * @desc
 */

public class A79单词搜索 {

    public boolean exist(char[][] board, String word) {
        char[] c = word.toCharArray();

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (dfs(board, i, j, c, 0, m, n)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, int row, int col, char[]c, int index, int m, int n) {
        if (row < 0 || row >= m || col < 0 || col >= n) {
            return false;
        }
        if (index == c.length-1 && board[row][col] == c[index]) {
             return true;
        }

        if (board[row][col] != c[index]) {
            return false;
        }
        board[row][col] = '-';

        boolean res = dfs(board, row, col - 1, c, index+1, m, n) || dfs(board, row, col + 1, c, index+1, m, n) || dfs(board, row - 1, col, c, index+1, m, n) ||
                dfs(board, row + 1, col, c, index+1, m, n);

        board[row][col] = c[index];
        return res;
    }

    public static void main(String[] args) {
        char[][] a = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(new A79单词搜索().exist(a, "ABCESEEEFS"));
    }



/**
 * 最近做 ac了 71/89
 */

/*    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        int m = board.length;
        int n = board[0].length;
//        int i = 0;
//        int j = 0;
        int count = 0;

        boolean used[][] = new boolean[m][n];

        for (int i = 0; i < m;) {
            for (int j = 0; j < n;) {
//                if (count == word.length()) {
//                    return true;
//                }
                if (!used[i][j] && board[i][j] == words[count]) {

                    if (count + 1 == word.length()) {
                        return true;
                    }

                    if ( j + 1 < n && !used[i][j + 1] && board[i][j + 1] == words[count + 1]) {
                        used[i][j] = true;
                        j++;
                        count++;
                        continue;
                    }
                    if (i + 1 < m && !used[i+1][j] && board[i+1][j] == words[count + 1]) {
                        used[i][j] = true;
                        i++;
                        count++;
                        continue;
                    }
                    if (j - 1 >= 0 && !used[i][j - 1] && board[i][j-1] == words[count + 1]) {
                        used[i][j] = true;
                        j--;
                        count++;
                        continue;

                    }
                    if (i - 1 >= 0 && !used[i-1][j] && board[i-1][j] == words[count + 1]) {
                        used[i][j] = true;
                        i--;
                        count++;
                        continue;

                    }
                    j++;
                } else {
                    j++;
                }
            }
            i++;
        }



        return false;

    }*/

}
