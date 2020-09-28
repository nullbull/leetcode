package study.leetcode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author niuzhenhao
 * @date 2020/9/7 10:13
 * @desc
 */

public class A66加一 {

    public int[] plusOne(int[] digits) {

        if (digits == null || digits.length == 0) {
            return new int[]{1};
        }

        if (digits.length == 1) {
            if (digits[0] < 9) {
                digits[0] += 1;
                return digits;
            } else {
                int[] temp = new int[2];
                temp[0] = 1;
                temp[1] = 0;
                return temp;
            }
        }


        int p = 0;
        ArrayList<Integer> result = new ArrayList<>(digits.length + 1);
        int digit = digits[digits.length - 1] + 1;
        p = digit / 10;
        result.add(digit % 10);
        for (int i = digits.length - 2; i >= 0; i--) {
           int sum = digits[i] + p;
           result.add(sum % 10);
           p = sum / 10;
        }
        if (p != 0) {
            result.add(p);
        }
        Collections.reverse(result);

        int[] res = result.stream().mapToInt(Integer::valueOf).toArray();

        return res;
    }

    public int[] plusOne2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        new A66加一().plusOne(new int[]{9, 9, 9});
    }
}
