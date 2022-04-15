package leetcode.base;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. 用队列实现栈
 * https://leetcode-cn.com/problems/implement-stack-using-queues/
 */
public class MyStack225 {

    // 对列：先进先出.
    // 栈：先进后出.
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public MyStack225() {
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
    }

    public void push(int x) {
        // queue2为空，最后进来的放头部，利用queue先进先出.
        queue2.offer(x);
        // 然后把先进入queue1的元素，压入queue2，那么先进的就变成后进的了.
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        // 交换就行，不要重新new出来.
        Queue<Integer> tmp = queue1;
        queue1 = queue2;
        queue2 = tmp;
    }

    public int pop() {
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }

}
