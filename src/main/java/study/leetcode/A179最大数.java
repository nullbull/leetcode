package study.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author niuzhenhao
 * @date 2021/1/28 19:21
 * @desc
 */

public class A179最大数 {

    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>(nums.length);
        boolean onlyZero = true;
        for (int i : nums) {
            if (i != 0) {
                onlyZero = false;
            }
            list.add(i + "");
        }
        if (onlyZero) {
            return "0";
        }

        list.sort((a, b) -> (a + b).compareTo(b + a));
        Collections.reverse(list);
        String collect = list.stream().collect(Collectors.joining());
        return collect;
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("9", "99", "919", "999");

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo( o2 + o1);
            }
        };
        list.sort(comparator);
        System.out.println(list);

        System.out.println( new A179最大数().largestNumber(new int[]{3,30,34,5,9}));
    }
}
