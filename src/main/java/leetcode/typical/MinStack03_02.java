package leetcode.typical;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 面试题 03.02. 栈的最小值
 * https://leetcode-cn.com/problems/min-stack-lcci/
 */
public class MinStack03_02 {

    private Deque<Integer> stack;
    // 辅助最小栈
    private Deque<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public MinStack03_02() {
        stack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        stack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}
