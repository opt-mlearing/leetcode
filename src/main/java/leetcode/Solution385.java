package leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 385. 迷你语法分析器
 * https://leetcode-cn.com/problems/mini-parser/
 */
public class Solution385 {

    public NestedInteger deserialize(String s) {
        if (s == null && s.length() == 0) {
            return null;
        }
        char[] chars = s.toCharArray();
        if (chars[0] != '[') {
            return new NestedInteger(Integer.parseInt(s));
        }
        Deque<NestedInteger> stack = new LinkedList<NestedInteger>();
        NestedInteger node = null;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < chars.length; ++i) {
            if (chars[i] == '[') {
                stack.push(new NestedInteger());
            } else if (chars[i] == ']') {
                if (builder.length() > 0) {
                    stack.peek().add(new NestedInteger(Integer.parseInt(builder.toString())));
                    builder = new StringBuilder();
                }
                // ']' 向上返回一级
                if (stack.size() > 1) {
                    NestedInteger top = stack.pop();
                    stack.peek().add(top);
                }
            } else if (chars[i] == ',') {
                if (builder.length() > 0) {
                    stack.peek().add(new NestedInteger(Integer.parseInt(builder.toString())));
                    builder = new StringBuilder();
                }
            } else {
                builder.append(chars[i]);
            }
        }
        assert stack.size() == 1;
        return stack.peek();
    }


    /**
     * NestedInteger 不完整，只是为了逃避代码检查，不用在意这个.
     */
    private static class NestedInteger {
        // Constructor initializes an empty nested list.
        public NestedInteger() {
        }

        // Constructor initializes a single integer.
        public NestedInteger(int value) {
        }

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger() {
            return false;
        }

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger() {
            return null;
        }

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value) {

        }

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni) {

        }

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList() {
            return null;
        }
    }

}
