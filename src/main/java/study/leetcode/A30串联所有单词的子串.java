package study.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A30串联所有单词的子串 {
    public List<Integer> findSubstring(String s, String[] words) {

        if (s == null || words == null || s.length() == 0 || words.length == 0 ) {
            return new ArrayList<>();
        }

        int size = words.length;
        Map<String, Integer> wordMap = new HashMap<>(words.length);


        for (String word : words) {
            Integer orDefault = wordMap.getOrDefault(word, 0);
            wordMap.put(word, orDefault + 1);
        }

        List<Integer> result = new ArrayList<>();

        int wordLength = words[0].length();
        if (size * wordLength > s.length()) return result;
        for (int i = 0; i < wordLength; i++) {
            int left = i, right = i, count = 0;
            HashMap<String, Integer> tempMap = new HashMap<>();
            while (right + wordLength <= s.length()) {
                String w = s.substring(right, right + wordLength);
                tempMap.put(w, tempMap.getOrDefault(w, 0) + 1);
                right += wordLength;
                count++;
                while (tempMap.getOrDefault(w, 0) >  wordMap.getOrDefault(w, 0)) {
                    String tempWord = s.substring(left, left + wordLength);
                    count--;
                    tempMap.put(tempWord, tempMap.getOrDefault(tempWord, 0) - 1);
                    left += wordLength;
                }
                if (count == size) {
                    result.add(left);
                }
            }
        }


        return result;
    }


}
