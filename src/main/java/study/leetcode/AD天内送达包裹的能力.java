package study.leetcode;

import java.util.Arrays;

public class AD天内送达包裹的能力 {

    public   static  int shipWithinDays(int[] weights, int D) {
        int sum = Arrays.stream(weights).sum();
        int max = Arrays.stream(weights).max().getAsInt();
        int begin = Math.max(sum / D, max);
        for (int i = begin; i < 10000000; i++) {
            int days = 0;
            for (int j = 0; j < weights.length;) {
                int total = 0;
                while (j < weights.length) {
                    total += weights[j++];
                    if (total > i) {
                        j--;
                        break;
                    }
                }
                days++;
            }
            if (days <= D) {
                return i;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10}, 5));
    }
}
