package study.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author niuzhenhao
 * @date 2021/1/13 21:48
 * @desc
 */
public class A415字符串相加 {


    public String addStrings(String num1, String num2) {
        if (num1.length() < num2.length()) {
            String temp = num2;
            num2 = num1;
            num1 = temp;
        }
        char[] a = num1.toCharArray();
        char[] b = num2.toCharArray();
        int len = b.length;
        int  aLen = a.length;
        int left = 0;
        String res = "";
        int i = len -1;
        int j = aLen - 1;
        for (;i >= 0&&j >=0; i--, j--) {
            int n = b[i] - '0';
            int m = a[j] - '0';
            int cur = m + n + left;
            res +=  "" + cur % 10;
            left = cur / 10;
        }
        while (j>=0) {
            int cur = left + a[j--] - '0';
            res +=  "" + cur % 10;
            left = cur / 10;
        }
        if (left > 0) {
            res += left;
        }
        char[] chars = res.toCharArray();
        String finalRes = "";
        for (int k = chars.length - 1; k >= 0; k--) {
            finalRes += chars[k];
        }
        return finalRes;
    }

    public static void main(String[] args) {
        String s = new A415字符串相加().addStrings("1", "9");
        System.out.println(s);
    }
}
