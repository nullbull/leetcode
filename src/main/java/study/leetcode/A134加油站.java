package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/1/28 10:42
 * @desc ac
 */

public class A134加油站 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            if (gas[i] >= cost[i]) {
                if (isValid(i, gas, cost)) {
                    return i;
                }
            }
        }
        return -1;

    }

    public boolean isValid(int pos, int[] gas, int[] cost) {
        int n = gas.length;
        int sum = 0;
        for (int i = pos; i < n; i++) {
            sum += gas[i];
            sum -= cost[i];
            if (sum < 0) {
                return false;
            }
        }
        for (int i = 0; i < pos; i++) {
            sum += gas[i];
            sum -= cost[i];
            if (sum < 0) {
                return false;
            }
        }
        return sum >= 0;
    }

}
