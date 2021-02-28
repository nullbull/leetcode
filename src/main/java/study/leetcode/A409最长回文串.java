package study.leetcode;

import java.util.*;

/**
 * @author niuzhenhao
 * @date 2021/2/28 15:07
 * @desc
 */
public class A409最长回文串 {

    public int longestPalindrome(String s) {
        char[] c = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char cc : c) {
            Integer orDefault = map.getOrDefault(cc, 0);
            map.put(cc, orDefault + 1);
        }
        ArrayList<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> {
            return -(a.getValue() - b.getValue());
        });
        int res = 0;
        boolean j = false;
        for (Map.Entry<Character, Integer> e : list) {
            if (e.getValue()  % 2 == 1) {
                if (!j) {
                    j = true;
                    res += e.getValue();
                } else {
                    res += e.getValue() - 1;
                }

            } else {
                res += e.getValue();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new A409最长回文串().longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
    }
}
