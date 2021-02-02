package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/1/28 15:55
 * @desc
 */

public class A剑指offer58修改单词顺序 {

    public String reverseWords(String s) {
        if(s == null || s.equals("")) {
            return s;
        }

        String[] split = s.split(" ");
        String res = "";


        boolean first = true;
        for (int i = split.length -1; i >=0 ;i--) {
            if (split[i] .equals("")) {
                continue;
            } else {
                if (first) {
                    first = false;
                    res += split[i];
                } else {
                    res += " " + split[i];
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        new A剑指offer58修改单词顺序().reverseWords("  hello world!  ");
    }

}
