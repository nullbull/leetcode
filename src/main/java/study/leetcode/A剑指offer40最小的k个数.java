package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/3/6 20:29
 * @desc
 */
public class A剑指offer40最小的k个数 {

    int[] res;
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k >= arr.length) return arr;
        res = new int[k];
        quickSort(arr, 0, arr.length - 1, k);
        return res;
    }

    public void quickSort(int[] arr, int l, int r, int k) {
        if (l > r) {
            return;
        }
        int i = l;
        int j = r;
        int cur = arr[l];
        while (i < j) {
            while (i < j && arr[j] >= cur) {
                j--;
            }
            while (i < j && arr[i] <= cur) {
                i++;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, l, i);
        if (i == k) {
            System.arraycopy(arr, 0, res, 0, k);
            return;
        } else if (i > k) {
            quickSort(arr, l, i - 1, k);
        } else {
            quickSort(arr, i + 1, r, k);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        new A剑指offer40最小的k个数().getLeastNumbers(new int[]{0,0,1,3,4,5,0,7,6,7}, 9);
    }


}
