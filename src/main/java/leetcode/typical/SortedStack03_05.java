package leetcode.typical;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 面试题 03.05. 栈排序
 * https://leetcode-cn.com/problems/sort-of-stacks-lcci/
 */
public class SortedStack03_05 {

    private Deque<Integer> stack;
    private Deque<Integer> tmp;

    public SortedStack03_05() {
        stack = new LinkedList<Integer>();
        tmp = new LinkedList<Integer>();
    }

    public void push(int val) {
        if (stack.isEmpty() || val < stack.peek()) {
            stack.push(val);
        } else {
            // 最小的元素在栈顶
            while (!stack.isEmpty() && val > stack.peek()) {
                tmp.push(stack.pop());
            }
            stack.push(val);
            while (!tmp.isEmpty()) {
                stack.push(tmp.pop());
            }
        }
    }

    // 注意栈为空的处理.
    public void pop() {
        if (isEmpty()) {
            return;
        }
        stack.pop();
    }

    // 注意栈为空的处理.
    public int peek() {
        return isEmpty() ? -1 : stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

}
