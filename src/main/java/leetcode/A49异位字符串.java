package leetcode;

import java.util.*;

/**
 * @author niuzhenhao
 * @date 2020/8/31 10:24
 * @desc
 */

public class A49异位字符串 {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();

        if (strs == null || strs.length == 0) {
            return res;
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            String key = new String(temp);

            if (map.containsKey(key)) {
                map.get(key).add(s);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(s);
                map.put(key, list);
            }
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String abc = "cbd";

        char[] chars = abc.toCharArray();

        Arrays.sort(chars);
        System.out.println(new String(chars));

    }

}
