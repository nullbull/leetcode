package leetcode;

/**
 * @author niuzhenhao
 * @date 2020/8/25 9:48
 * @desc
 */

public class A43字符串相乘 {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int sum = 0;
                sum += (res[i + j + 1] +  (num1.charAt(i) - '0') * (num2.charAt(j) - '0'));
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (res[i] == 0 && i == 0) {
                 continue;
            }
            sb.append(res[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        new A43字符串相乘().multiply("99", "99");
    }

}
