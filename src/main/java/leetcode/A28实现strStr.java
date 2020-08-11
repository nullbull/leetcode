package leetcode;

public class A28实现strStr {
    public int strStr(String s, String a) {

        if (s == null) {
            return -1;
        }

        if (a == null) {
            return -1;
        }

        if (s.isEmpty() && a.isEmpty()) {
            return 0;
        }
        if (a.isEmpty()) {
            return 0;
        }

        if (s.length() < a.length()) {
            return -1;
        }




        char[] t = s.toCharArray();
        char[] r = a.toCharArray();
        for (int i = 0; i < t.length;) {
            int start = i;
            int rs =  0;
            if (t[i] == r[rs]) {
                while (i < t.length && t[i++] == r[rs++]) {
                    if (rs == r.length) {
                        return start;
                    }
                }
                i = start + 1;
            } else {
                i++;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new A28实现strStr().strStr("mississippi", "issip"));
        System.out.println(new A28实现strStr().strStr("hello", "ll"));
    }

}
