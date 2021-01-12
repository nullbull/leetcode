package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/1/10 22:47
 * @desc
 */
public class A42接雨水复习 {


    public int trap(int[] height) {

        if (height == null || height.length < 2) {
            return 0;
        }

        int leftMax = height[0];
        int rightMax = height[height.length-1];

//        int i = 0;
//        int j = height.length - 1;
        int count = 0;
//        while (i <= j) {
//            if (height[j] > rightMax) {
//                rightMax = height[j];
//            }
//            if (leftMax > rightMax) {
//                leftMax = rightMax;
//            }
//            if (height[i] > leftMax) {
//                leftMax = height[i];
//            }
//            count += (leftMax - height[i]) ;
//
//
//            i++;
//            if (leftMax > rightMax ) {
//                int k = j;
//                while (k > i) {
//                    if (height[k--] > rightMax) {
//                        j = k;
//                        break;
//                    }
//                }
//            }
//        }

        for (int i = 0; i < height.length; i++) {
            if (leftMax < height[i]) {
                leftMax = height[i];
            }
            int maxRight = -1;
            for (int j = height.length -1; j > i; j--) {
                maxRight = Math.max(maxRight, height[j]);
            }
            int min = Math.min(leftMax, maxRight);
            if (min > height[i]) {
                count += min - height[i];
            }
        }


        return count;

    }

    public static void main(String[] args) {
        new A42接雨水复习().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
        new A42接雨水复习().trap(new int[]{4, 2, 0 ,3 ,2 ,5});
        new A42接雨水复习().trap(new int[]{7, 6, 4, 3, 2, 1});
        new A42接雨水复习().trap(new int[]{5, 4, 1 , 2});
    }
}
