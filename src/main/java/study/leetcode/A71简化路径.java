package study.leetcode;

import java.util.*;

/**
 * @author niuzhenhao
 * @date 2021/1/26 21:12
 * @desc ac
 */
public class A71简化路径 {

    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        String[] split = path.split("/");
        for (String d : split) {
            if ("/".equals(d) || ".".equals(d) || "".equals(d)) {
                continue;
            } else if ("..".equals(d)){
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(d);
            }
        };
        String res = "";



        while (!stack.isEmpty()) {
            res += "/";
            res += stack.pollLast();
        }


        if (res.equals("")) {
            res = "/";
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new A71简化路径().simplifyPath("/a//b////c/d//././/.."));
        System.out.println(new A71简化路径().simplifyPath("/a/../../b/../c//.//"));
        System.out.println(new A71简化路径().simplifyPath("/a/./b/../../c/"));
        System.out.println(new A71简化路径().simplifyPath("/home//foo/"));
        System.out.println(new A71简化路径().simplifyPath("/../"));
        System.out.println(new A71简化路径().simplifyPath("/home/"));
    }
}
