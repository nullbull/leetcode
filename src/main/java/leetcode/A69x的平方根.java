package leetcode;

public class A69x的平方根 {


    public int mySqrt(int x) {

        if (x < 4 && x >= 1) {
            return 1;
        }

        for (long i = 1 ;i  <= (x / i) ; i++) {
            if (i * i <= x && (i + 1) * (i + 1) > x) {
                return (int) i;
            }
        }


        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new A69x的平方根().mySqrt(2147395600));
    }
}
