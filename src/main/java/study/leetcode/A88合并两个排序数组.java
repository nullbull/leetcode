package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2020/10/9 18:37
 * @desc
 */

/**
 * ac
 */
public class A88合并两个排序数组 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int temp[] = new int[m + n];


        int count = 0;
        int mm = 0;
        int nn = 0;
        while (mm < m && nn < n) {
            if (nums1[mm] < nums2[nn] && mm < m) {
                while (mm < m && nums1[mm] < nums2[nn] ) {
                    temp[count++] = nums1[mm++];
                }
            } else {
                while (nn < n && nums1[mm] >= nums2[nn]) {
                    temp[count++] = nums2[nn++];
                }
            }


        }

        if(m > mm) {
            System.arraycopy(nums1, mm, temp, count, m - mm);
        }
        if(n > nn) {
            System.arraycopy(nums2, nn, temp, count, n - nn);
        }
        System.arraycopy(temp, 0, nums1, 0, m + n);
    }

    public static void main(String[] args) {
        new A88合并两个排序数组().merge(new int[]{1, 2,3 ,0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    }
}

