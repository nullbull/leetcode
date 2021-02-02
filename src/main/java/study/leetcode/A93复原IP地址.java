package study.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author niuzhenhao
 * @date 2021/2/2 18:53
 * @desc
 */

public class A93复原IP地址 {

    List<List<String>> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {

        dfs(s, 0, new LinkedList<>());
        List<String> collect1 = res.stream().flatMap(a ->
        {
            Collections.reverse(a);
            String collect = a.stream().collect(Collectors.joining("."));
            return Stream.of(collect);
        }).collect(Collectors.toList());

        return collect1;
    }


    public boolean isValid(String s) {
        if (s.length() > 1 && s.charAt(0) == '0') {
            return false;
        }
        return Integer.parseInt(s) < 256;
    }



    public void dfs(String s, int p, LinkedList<String> cur) {
        if (cur.size() == 4) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 1; i <= 3; i++) {
            int n = 4 - cur.size() - 1 ;
            int len = s.length();
            if ((len - p - i) > n * 3) {
                continue;
            }
            if (p + i > len) {
                return;
            }
            String sub = s.substring(p, p + i);
            if (isValid(sub)) {
                cur.push(sub);
            } else {
                continue;
            }
            dfs(s, p + i, cur);
            cur.pollFirst();
        }
    }

}
