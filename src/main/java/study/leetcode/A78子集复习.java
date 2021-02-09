package study.leetcode;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author niuzhenhao
 * @date 2021/2/7 22:28
 * @desc
 */
public class A78子集复习 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dg(nums, 0, new ArrayList<>());
        res.add(new ArrayList<>());
        return res;
    }


    public void dg(int[] nums, int begin, List<Integer> list) {
        for (int i = begin; i < nums.length; i++) {
//            res.add(Arrays.asList(nums[i]));
            list.add(nums[i]);
            res.add(new ArrayList<>(list));
            dg(nums, i + 1, list);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println( new A78子集复习().subsets(new int[]{1, 2, 3}));
    }
}
