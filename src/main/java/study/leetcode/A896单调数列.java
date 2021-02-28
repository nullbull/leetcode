package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/2/28 11:49
 * @desc
 */
public class A896单调数列 {

    public boolean isMonotonic(int[] a) {
        int last = a[0];
        
        for (int i = 1; i < a.length - 1; i++) {
            if (a[i] == a[i+1]) {
                continue;
            }
            int p = i + 1;
            while (p < a.length && a[i] == a[p]) {
                p++;
            }
            
            if (last > a[i] && a[i] < a[p]) {
                return false;
            }
            if (last < a[i] && a[i] > a[p]) {
                return false;
            }
            last = a[i];
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new A896单调数列().isMonotonic(new int[]{11,11,9,4,3,3,3,1,-1,-1,3,3,3,5,5,5}));
        System.out.println(new A896单调数列().isMonotonic(new int[]{2,2,2,1,4,5}));
    }


}
