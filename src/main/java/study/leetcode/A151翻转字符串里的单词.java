package study.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author niuzhenhao
 * @date 2021/2/14 18:00
 * @desc
 */
public class A151翻转字符串里的单词 {

    public String reverseWords(String s) {
        String[] s1 = s.split(" ");
        List<String> res = new ArrayList<>(s1.length);
        for (int i = s1.length - 1; i >= 0; i--) {
            if (!s1[i].equals("")) {
                res.add(s1[i]);
            }
        }
        return res.stream().collect(Collectors.joining(" "));
    }
}
