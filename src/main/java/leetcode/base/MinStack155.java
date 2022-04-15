package leetcode.base;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 最小栈
 * https://leetcode-cn.com/problems/min-stack/
 */
public class MinStack155 {

    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    public MinStack155() {
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
