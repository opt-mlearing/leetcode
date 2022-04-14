package leetcode.typical;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 面试题 03.01. 三合一
 * https://leetcode-cn.com/problems/three-in-one-lcci/
 */
public class TripleInOne03_01 {

    private Map<Integer, Deque<Integer>> mapping;
    private int stackSize;

    // 郁闷，刚开始硬是没看懂题目要干啥.
    public TripleInOne03_01(int stackSize) {
        this.stackSize = stackSize;
        this.mapping = new HashMap<Integer, Deque<Integer>>();
    }

    public void push(int stackNum, int value) {
        Deque<Integer> stack = mapping.getOrDefault(stackNum, new LinkedList<Integer>());
        if (stack.size() < stackSize) {
            stack.push(value);
        }
        mapping.put(stackNum, stack);
    }

    public int pop(int stackNum) {
        Deque<Integer> stack = mapping.getOrDefault(stackNum, new LinkedList<Integer>());
        return stack.isEmpty() ? -1 : stack.pop();
    }

    public int peek(int stackNum) {
        Deque<Integer> stack = mapping.getOrDefault(stackNum, new LinkedList<Integer>());
        return stack.isEmpty() ? -1 : stack.peek();
    }

    public boolean isEmpty(int stackNum) {
        Deque<Integer> stack = mapping.getOrDefault(stackNum, new LinkedList<Integer>());
        return stack.isEmpty();
    }

}
