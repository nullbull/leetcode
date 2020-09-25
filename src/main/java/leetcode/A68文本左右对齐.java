package leetcode;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author niuzhenhao
 * @date 2020/9/24 10:11
 * @desc
 */

//自己作对的
public class A68文本左右对齐 {


    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> res = new ArrayList<>();
        List<List<String>> list = new ArrayList<>();

        int count = 0;
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            count += words[i].length() + 1;
            if (count > maxWidth + 1) {
                count = 0;
                list.add(new ArrayList<>(temp));
                temp = new ArrayList<>();
                i--;
                continue;
            }
            temp.add(words[i]);
        }
        list.add(temp);


        int now = 0;
        for (List<String> row : list) {
            now++;

            if (now == list.size()) {
                String aaa = String.join(" ", row);
                int length = aaa.length();
                for (int i = 0; i < maxWidth - length; i++) {
                    aaa += " ";
                }
                res.add(aaa);
                break;
            }

            if (row.size() > 1) {
                Integer total = row.stream().map(String::length).reduce(Integer::sum).get();
                int cha = maxWidth - total;
                int kon = cha / (row.size() - 1);
                int yu = cha % (row.size() - 1);
                String one = "";

                String kongge = "";
                for (int i = 0; i < kon; i++) {
                    kongge += " ";
                }
                if (yu == 0) {
                    one = row.stream().collect(Collectors.joining(kongge));
                } else {
                    for (int i = 0; i < yu; i++) {
                        one += row.get(i) + kongge + " ";
                    }
                    for (int i = yu; i < row.size(); i++) {
                        if (i < row.size() - 1) {
                            one += row.get(i) + kongge;
                        } else {
                            one += row.get(i);
                        }
                    }
                }
                res.add(one);
            } else {
                String a = row.get(0);
                int length = a.length();
                for (int i = 0; i < maxWidth - length; i++) {
                    a += " ";
                }
                res.add(a);
            }
        }

        return res;
    }


    public static void main(String[] args) {
//        new A68文本左右对齐().fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16);
//        new A68文本左右对齐().fullJustify(new String[]{"What","must","be","acknowledgment","shall","be"}, 16);
        new A68文本左右对齐().fullJustify(new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"}, 20);
    }
}
