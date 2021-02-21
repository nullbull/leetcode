package study.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author niuzhenhao
 * @date 2021/2/20 23:03
 * @desc
 */
public class A剑指Offer38字符串的排列 {

    List<String> res = new ArrayList<>();
    public String[] permutation(String s) {



        if (s == null || s.length() == 0) {
            return null;
        }
        char[] cs = s.toCharArray();
        Arrays.sort(cs);
        dg(cs, "" ,new boolean[s.length()]);
//        res.forEach(System.out::println);
        return res.toArray(new String[res.size()]);
    }


    public void dg(char[] cs, String cur, boolean[] used) {
        if (cur.length() == cs.length) {
            res.add(new String(cur));
            return;
        }
        for (int i = 0; i < cs.length; i++) {
            if (i > 0 && !used[i-1] && cs[i] == cs[i-1]) {
                continue;
            }
            if (!used[i]) {
                used[i] = true;
                cur += cs[i];
                dg(cs, cur, used);
                used[i] = false;
                cur = cur.substring(0, cur.length()-1);
            }

        }
    }


    public static void main(String[] args) {
        System.out.println(new A剑指Offer38字符串的排列().permutation("aab"));
    }
}
