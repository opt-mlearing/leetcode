package leetcode.offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 * https://leetcode.cn/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 *
 * @author: caogl
 * @date: 2022/6/29, 0:32
 **/
public class SolutionOffer_09 {

    private Deque<Integer> stack1;
    private Deque<Integer> stack2;

    public SolutionOffer_09() {
        stack1 = new LinkedList<Integer>();
        stack2 = new LinkedList<Integer>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        stack2.clear();
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int res = stack2.isEmpty() ? -1 : stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return res;
    }

}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
