package study.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author niuzhenhao
 * @date 2021/1/30 18:14
 * @desc
 */
public class A386字典序排数 {
/*    public List<Integer> lexicalOrder(int n) {
        List<String> list = new ArrayList<>(n);
        for (int i = 1 ; i <= n ;i++) {
            list.add(i + "");
        }
        list.sort(String::compareTo);
        List<Integer> res = list.stream().mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        return res;
    }*/

    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 10; i++){
            dfs(n, i, list);
        }
        return list;
    }
    private void dfs(int n,int i,List<Integer>list){
        if(i>n){
            return ;
        }
        list.add(i);
        for(int j=0;j<=9;j++){
            dfs(n,i*10+j,list);
        }
    }
}
