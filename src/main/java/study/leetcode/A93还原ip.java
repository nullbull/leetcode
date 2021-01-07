package study.leetcode;

import java.util.ArrayList;
import java.util.List;

public class A93还原ip {


    public List<String> restoreIpAddresses(String s) {

        List<List<String>> res = new ArrayList<>();
         df(new ArrayList<>(), s.toCharArray(), 0, res, "");
         return null;
    }
    private void df(List<String> one, char[] chars, int p, List<List<String>> res, String now) {
        if (now.length() == 1) {
            one.add(now);
            now = "";
        } else if (now.length() > 1  && now.length() <= 3) {
            if (now.charAt(0) != 0) {
                one.add(now);
                now = "";
            }
        }

        if (p == chars.length) {
            if (one.size() == 4) {
                res.add(new ArrayList<>(one));
            }
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            now += chars[i];
            df(one, chars, p + 1, res, now);
            if (now.length() > 0) {
                now = now.substring(0, now.length() -1);
            }
            one.remove(one.size() - 1);
        }
    }


    public static void main(String[] args) {
       new A93还原ip().restoreIpAddresses("010010");
    }
}
