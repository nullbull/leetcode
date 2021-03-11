package study.leetcode;

/**
 * @author niuzhenhao
 * @date 2021/3/10 21:29
 * @desc
 */
public class A1518换酒问题 {


    public int numWaterBottles(int numBottles, int numExchange) {
        int sum = 0;
        int left = 0;
        while ((numBottles + left) >= numExchange) {
            sum += numBottles;
            int beforeLeft = left;
            left = (numBottles + left) % numExchange;
            numBottles = (numBottles + beforeLeft) / numExchange;
        }
        return sum + numBottles;
    }

    public static void main(String[] args) {
        new A1518换酒问题().numWaterBottles(15, 4);
    }
}
