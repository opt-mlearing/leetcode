package leetcode.base;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 264. 丑数 II
 * https://leetcode-cn.com/problems/ugly-number-ii/
 *
 * @author: caogl
 * @date: 2022/7/6, 0:09
 **/
public class Solution264 {

    private int[] factors = {2, 3, 5};

    public int nthUglyNumber(int n) {
        if (n < 1) {
            return -1;
        }
        int[] dp = new int[n + 1];
        int num2 = 1;
        int num3 = 1;
        int num5 = 1;
        dp[0] = 0;
        // 实例2, n= 1, 1通常视为丑数.
        dp[1] = 1;
        for (int i = 2; i <= n; ++i) {
            int a = 2 * dp[num2];
            int b = 3 * dp[num3];
            int c = 5 * dp[num5];
            dp[i] = Math.min(Math.min(a, b), c);
            // 不要if else if 这种，可能存在num2== num3== num5 的情况，都要++.
            if (dp[i] == a) {
                ++num2;
            }
            if (dp[i] == b) {
                ++num3;
            }
            if (dp[i] == c) {
                ++num5;
            }
        }
        return dp[n];
    }

    // 优先队列
    public int nthUglyNumber_priority_queue(int n) {
        if (n < 1) {
            return -1;
        }
        // 注意，如果是Integer类型的话可能越界.
        Queue<Long> deque = new PriorityQueue<Long>();
        deque.add(1l);
        int count = 0;
        while (!deque.isEmpty()) {
            long tmp = deque.poll();
            if (n == ++count) {
                return (int) tmp;
            }
            Arrays.asList();
            for (int i = 0; i < factors.length; ++i) {
                while (!deque.contains(factors[i] * tmp)) {
                    deque.add(factors[i] * tmp);
                }
            }
        }
        return -1;
    }

}
