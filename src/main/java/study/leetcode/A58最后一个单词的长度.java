package study.leetcode;

public class A58最后一个单词的长度 {

    public int lengthOfLastWord(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int len = s.length();
        while (len - 1 >= 0 && chars[len - 1] == ' ') {
            len--;
        }
        int count = 0;
        for (int i = len - 1; i >= 0; --i) {
            if (chars[i] != ' ') {
                ++count;
            } else {
                return count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new A58最后一个单词的长度().lengthOfLastWord("a "));
    }
}
