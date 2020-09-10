package leetcode;

import java.util.ArrayList;

public class A60第k个排列 {


    public String getPermutation(int n, int k) {
        int f[] = new int[n];
        f[0] = 1;
        for (int i = 1 ;i < n; i++) {
            f[i] = f[i - 1] * i;
        }
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        String sb = "";
        k--;
        for (int i = 0; i < n; i++) {
            int p = k / f[n - i - 1];
            Integer temp = list.get(p);
            sb += temp;
            k = k % f[n - i - 1];
            list.remove(p);
        }


        return sb;
    }

    public static void main(String[] args) {
        System.out.println(new A60第k个排列().getPermutation(3, 1));
    }
}
