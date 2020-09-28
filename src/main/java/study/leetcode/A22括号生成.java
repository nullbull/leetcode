package study.leetcode;

import java.util.ArrayList;
import java.util.List;

public class A22括号生成 {

    private static char[] k = new char[]{'(', ')'};

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        if (n == 0) {
            return result;
        }

        process(0, n * 2, "", result,0 ,0);

        return result;
    }

    private static void process(int p, int n, String s, List<String> ans, int m, int z) {
/*        if (p == n ) {
            Stack<Character> characterStack = new Stack<>();
            for (char ss : s.toCharArray()) {
                if (ss == k[0]) {
                    characterStack.push(ss);
                } else {
                    if (characterStack.empty()) {
                        characterStack.push(ss);
                        break;
                    } else {
                        characterStack.pop();
                    }
                }
            }
            if (characterStack.empty()) {
                ans.add(s);
            }
        } else {
            for (int i = 0; i < 2; i++) {
                process(p + 1, n, s + k[i], ans);
            }
        }*/

        if (s.length() == n) {
            ans.add(s);
        }
        if (m < n / 2) {
            process(p + 1, n, s + '(' , ans, m + 1, z);
        }
        if (z < m) {
            process(p + 1, n,s + ')', ans, m, z + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

}
