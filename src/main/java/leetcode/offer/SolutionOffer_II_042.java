package leetcode.offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer II 042. 最近请求次数
 * https://leetcode.cn/problems/H8086Q/submissions/
 */
public class SolutionOffer_II_042 {

    private Deque<Integer> stack;

    public SolutionOffer_II_042() {
        stack = new LinkedList<Integer>();
    }

    public int ping(int t) {
        while (!stack.isEmpty() && t - stack.peek() > 3000) {
            stack.poll();
        }
        stack.offer(t);
        return stack.size();
    }

}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
