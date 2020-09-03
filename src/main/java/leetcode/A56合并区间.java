package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author niuzhenhao
 * @date 2020/9/2 18:43
 * @desc
 */

public class A56合并区间 {

 /*   public int[][] merge(int[][] nums) {


        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        };
        Arrays.sort(nums, comparator);
        int[][] ans = temp(nums);
        if (ans.length > 1) {
            ans = temp(ans);
        }
        return ans;
    }

    private int[][] temp(int[][]nums) {
        boolean[] invalid = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int left = nums[i][0];
            int right = nums[i][1];
            if (invalid[i]) {
                continue;
            }
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
//                if (invalid[j]) {
//                    continue;
//                }
                if (i < j) {
                    if (right >= nums[j][0]) {
                        if (nums[i][1] <= nums[j][1]) {
                            nums[i][1] = nums[j][1];
                        }
                        invalid[j] = true;
                    }
                } else {
                    if (nums[j][1] >= left) {
                        if (nums[i][0] >= nums[j][0]) {
                            nums[i][0] = nums[j][0];
                        }
                        invalid[j] = true;
                    }
                }

            }
        }
        int[][] ans = new int[nums.length][];
        int count = 0;
        for (int i = 0; i < invalid.length; i++) {
            if (!invalid[i]) {
                ans[count++] = nums[i];
            }
        }
        int[][] nee = new int[count][];
        System.arraycopy(ans, 0, nee, 0, count);
        return nee;
    }*/


    public int[][] merge(int[][] intervals) {
        List<int[]> inter = Arrays.asList(intervals);
        List<int[]> newInter = new ArrayList<>(inter);
        newInter.sort((o1, o2) -> o1[0] - o2[0]);

        List<int[]> res = new ArrayList<>();
        for(int i = 0; i < newInter.size(); )
        {
            int t = newInter.get(i)[1];
            int j = i + 1;
            while(j < newInter.size() && newInter.get(j)[0] <= t)
            {
                t = Math.max(t, newInter.get(j)[1]);
                j++;
            }
            res.add(new int[]{newInter.get(i)[0], t});
            i = j;
        }

        int[][] ans = new int[res.size()][2];
        for(int i = 0; i < res.size(); i++)
        {
            ans[i][0] = res.get(i)[0];
            ans[i][1] = res.get(i)[1];
        }
        return ans;
    }
    public static void main(String[] args) {
//        int[][] ans = new int[4][];
//        ans[1] = new int[]{1, 4};
//        ans[0] = new int[]{0, 2};
//        ans[2] = new int[]{3, 5};
//        ans[3] = new int[]{15, 18};

        int[][] ans = new int[12][];
        ans[0] = new int[]{0, 0};
        ans[1] = new int[]{1, 2};
        ans[2] = new int[]{5,5};
        ans[3] = new int[]{2,4};
        ans[4] = new int[]{3,3};
        ans[5] = new int[]{5,6};
        ans[6] = new int[]{5,6};
        ans[7] = new int[]{4,6};
        ans[8] = new int[]{0,0};
        ans[9] = new int[]{1, 2};
        ans[10] = new int[]{0,2};
        ans[11] = new int[]{4,5};


         new A56合并区间().merge(ans);
    }
}
