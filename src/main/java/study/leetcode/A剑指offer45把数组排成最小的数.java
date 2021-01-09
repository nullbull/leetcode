package study.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author niuzhenhao
 * @date 2021/1/9 9:49
 * @desc 自己做的差一个ac
 */

public class A剑指offer45把数组排成最小的数 {

    public String minNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int i : nums) {
            list.add(i+"");
        }
        list.sort((a, b) -> {
            return (a+b).compareTo(b+a);
        });

        String res = "";
        for (int i = 0; i < list.size(); i++) {
            res += list.get(i);
        }
        return res;
    }


    public String minNumber1(int[] nums) {

        List<String> list = new ArrayList<>();
        int length = 0;

        int zeroCount = 0;

        for (int i : nums) {
            if (i > 0) {
                String s = Integer.valueOf(i).toString();
                list.add(s);
            } else {
                zeroCount++;
            }
        }

        String res = "";
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                boolean startWith = false;
                String sub = "";
                String little = "";
                boolean isO1 = true;
                if (o1.length() !=  o2.length()) {
                    if (o1.length() > o2.length()) {
                        if (o1.startsWith(o2)) {
                            startWith = true;
                            sub = o1.substring(o2.length());
                            while (sub.contains(o2) && sub.length() > o2.length()) {
                                sub = sub.substring(o2.length());
                            }
                            little = o2;
                        }
                    } else {
                        if (o2.startsWith(o1)) {
                            startWith = true;
                            sub = o2.substring(o1.length());
                            while (sub.contains(o1) &&sub.length() > o1.length()) {
                                sub = sub.substring(o1.length());
                            }
                            little = o1;
                            isO1 = false;
                        }
                    }
                    if (startWith) {
                        int compareTo = sub.compareTo(little);
                        if (isO1) {
                            return compareTo;
                        } else {
                            return -compareTo;
                        }
                    }
                }
                return o1.compareTo(o2);
            }
        });


        for (int i = 0; i < zeroCount; i++) {
            res += "0";
        }

        for (int i = 0; i < list.size(); i++) {
            res += list.get(i);
        }

        return res;
    }
//
//    public String currentMin(Map<Integer, Integer> map) {
//        for (int i = 1; i < 10; i++) {
//            if (map.get(i) != null) {
//                Integer count = map.get(i);
//                count = count - 1;
//                if (count == 0) {
//                    map.remove(i);
//                } else {
//                    map.put(i, count);
//                }
//                return i + "";
//            }
//        }
//        return "";
//    }

    public static void main(String[] args) {
//        String s = new FFF().minNumber(new int[]{34, 3, 30, 5, 9});
//        System.out.println(s);
//
//        System.out.println(new FFF().minNumber(new int[]{121, 12}));
//        System.out.println(new FFF().minNumber(new int[]{12, 1212}));
        System.out.println(new A剑指offer45把数组排成最小的数().minNumber(new int[]{830, 8, 8308}));

        List<String> list = Arrays.asList("30", "3", "34", "5", "9");
        list.sort(String::compareTo);
        System.out.println(list);
    }
}
