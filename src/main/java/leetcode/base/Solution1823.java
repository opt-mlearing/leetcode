package leetcode.base;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1823. 找出游戏的获胜者
 * https://leetcode.cn/problems/find-the-winner-of-the-circular-game/
 */
public class Solution1823 {

    public int findTheWinner_1(int n, int k) {
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 1; i <= n; ++i) {
            deque.offer(i);
        }
        while (deque.size() > 1) {
            for (int i = 1; i < k; ++i) {
                deque.offer(deque.pop());
            }
            deque.pop();
        }
        return deque.peek();
    }

    public int findTheWinner_2(int n, int k) {
        int pos = 0;
        for (int i = 2; i <= n; ++i) {
            pos = (pos + k) % i;
        }
        return pos + 1;
    }

    public int findTheWinner_3(int n, int k) {
        if (n == 1) {
            return 1;
        }
        return (findTheWinner_3(n - 1, k) - 1 + k) % n + 1;
    }

}
