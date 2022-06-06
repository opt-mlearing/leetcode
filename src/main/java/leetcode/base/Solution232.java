package leetcode.base;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 232. 用栈实现队列
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/
 */
public class Solution232 {

    private Deque<Integer> innerStack;
    private Deque<Integer> outerStack;

    public Solution232() {
        innerStack = new LinkedList<Integer>();
        outerStack = new LinkedList<Integer>();
    }

    public void push(int x) {
        innerStack.push(x);
    }

    public int pop() {
        if (outerStack.isEmpty()) {
            innerToOuter();
        }
        return outerStack.pop();
    }

    public int peek() {
        if (outerStack.isEmpty()) {
            innerToOuter();
        }
        return outerStack.peek();
    }

    public boolean empty() {
        return innerStack.isEmpty() && outerStack.isEmpty();
    }

    private void innerToOuter() {
        if (outerStack.isEmpty()) {
            while (!innerStack.isEmpty()) {
                outerStack.push(innerStack.pop());
            }
        }
    }

}
