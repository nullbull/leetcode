package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/3/10 21:55
 * @desc
 */
public class A1539第k个缺失的正整数 {


    public int findKthPositive(int[] arr, int k) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] - mid - 1 < k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return k + r + 1;
    }
}
