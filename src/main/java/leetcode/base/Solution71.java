package leetcode.base;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 71. 简化路径
 * https://leetcode-cn.com/problems/simplify-path/
 */
public class Solution71 {

    public String simplifyPath(String path) {
        String[] items = path.split("/");
        Deque<String> stack = new LinkedList<String>();
        for (String str : items) {
            if (str.equals(".") || str.equals("")) {
                continue;
            } else if (str.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(str);
            }
        }
        StringBuffer buffer = new StringBuffer();
        while (!stack.isEmpty()) {
            buffer.append("/").append(stack.pollLast());
        }
        return buffer.length() == 0 ? "/" : buffer.toString();
    }

}
