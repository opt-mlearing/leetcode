package leetcode.base;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 933. 最近的请求次数
 * https://leetcode-cn.com/problems/number-of-recent-calls/
 */
public class RecentCounter933 {

    private Deque<Integer> deque;

    public RecentCounter933() {
        deque = new LinkedList<Integer>();
    }

    public int ping(int t) {
        if (deque.isEmpty()) {
            deque.offer(t);
        } else {
            while (!deque.isEmpty() && (t - deque.peek() > 3000)) {
                deque.poll();
            }
            deque.offer(t);
        }
        return deque.size();
    }

}
