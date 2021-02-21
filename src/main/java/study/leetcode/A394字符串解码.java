package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/2/17 11:53
 * @desc
 */
public class A394字符串解码 {

    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        while (s.contains("[")) {
            char[] chars = s.toCharArray();
            int left = 0;
            for (; left < chars.length; left++) {
                if (chars[left] == '[') {
                    break;
                }
            }
            int numberCount = 0;
            for (int i = left-1; i >= 0 ;i--) {
                if (chars[i] >= '0' && chars[i] <= '9') {
                    numberCount++;
                } else {
                    break;
                }
            }
            int tim = Integer.parseInt(s.substring(left-numberCount, left));



            int leftCount = 1;
            int right = left + 1;
            for (; right < chars.length; right++) {
                if (chars[right] == '[') {
                    leftCount++;
                }
                if (chars[right] == ']') {
                    leftCount--;
                }
                if (leftCount == 0) {
                    break;
                }
            }
            String temp = s.substring(left + 1, right);
            String xunhuan = "";
            for (int i = 0; i < tim; i++) {
                xunhuan += temp;
            }
            temp = xunhuan;
            String a = "";
            a += s.substring(0, left-numberCount);
            a += temp;
            a += s.substring(right + 1);
            s = a;
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(new A394字符串解码().decodeString("12[a]2[bc]"));
        System.out.println(new A394字符串解码().decodeString("2[abc]3[cd]ef"));
        System.out.println(new A394字符串解码().decodeString("100[lee]"));
    }

}
