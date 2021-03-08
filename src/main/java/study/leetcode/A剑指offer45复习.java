package study.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author niuzhenhao
 * @date 2021/3/7 12:10
 * @desc
 */
public class A剑指offer45复习 {
    public String minNumber(int[] nums) {
        List<String> res = Arrays.stream(nums).boxed().map(String::valueOf).collect(Collectors.toList());
        res.sort((a, b) -> {
          return Long.valueOf(a + b) > Long.valueOf(b + a) ? 1 : -1;
        });
        return res.stream().collect(Collectors.joining());
    }

}
