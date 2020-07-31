package leetcode;

public class A29两数相除 {

//    public int divide(int a, int b) {
//
//        long dividend = a;
//        long divisor = b;
//
//
//        boolean theme = false;
//        if (dividend > 0 && divisor < 0) {
//            divisor = -divisor;
//            theme = true;
//        }
//
//        if (dividend < 0 && divisor > 0) {
//            dividend = - dividend;
//            theme = true;
//        }
//
//        if (dividend < 0 && divisor < 0) {
//            dividend = -dividend;
//            divisor = - divisor;
//        }
//
//        if (dividend < divisor) {
//            return 0;
//        }
//
//        int time = 0;
//        long temp = 0;
//        while (temp < dividend) {
//            temp = temp << 1;
//
//            if (temp > dividend) {
//                dividend = (dividend - temp / 2) ;
//                temp = 0;
//            }
//
//            if (time == Integer.MAX_VALUE) {
//                return Integer.MAX_VALUE;
//            }
//            time++;
//
//        }
//        if (temp > dividend) {
//            time--;
//        }
//        if (theme) {
//            return  -time;
//        }
//        return time;
//    }

    public int divide(int dividend, int divisor) {
        boolean sign = (dividend > 0) ^ (divisor > 0);
        int result = 0;
        if(dividend>0) {
            dividend = -dividend;
        }
        if(divisor>0) divisor = -divisor;
        while(dividend <= divisor) {
            int temp_result = -1;
            int temp_divisor = divisor;
            while(dividend <= (temp_divisor << 1)) {
                if(temp_divisor <= (Integer.MIN_VALUE >> 1))break;
                temp_result = temp_result << 1;
                temp_divisor = temp_divisor << 1;
            }
            dividend = dividend - temp_divisor;
            result += temp_result;
        }
        if(!sign) {
            if(result <= Integer.MIN_VALUE) return Integer.MAX_VALUE;
            result = - result;
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(new A29两数相除().divide(2147483647,1));
    }
}
