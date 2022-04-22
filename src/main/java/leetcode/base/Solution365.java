package leetcode.base;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 365. 水壶问题
 * https://leetcode-cn.com/problems/water-and-jug-problem/
 */
public class Solution365 {

    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        // 自行维护堆栈，避免栈溢出.
        Deque<int[]> deque = new LinkedList<int[]>();
        deque.push(new int[]{0, 0});
        // 增加记忆，避免超时.
        Set<Long> set = new HashSet<Long>();
        while (!deque.isEmpty()) {
            long code = getHash(deque.peek());
            if (set.contains(code)) {
                // 如果包含，表示已经搜索过，可以不用再检索.
                // 记住不要忘记出栈.
                deque.poll();
                continue;
            }
            set.add(code);
            int[] tmp = deque.poll();
            // x 对应jug1Capacity & y 对应jug2Capacity
            int x = tmp[0];
            int y = tmp[1];
            if ((x == targetCapacity) || (y == targetCapacity) || (x + y == targetCapacity)) {
                return true;
            }
            // x装满
            deque.push(new int[]{jug1Capacity, y});
            // x倒空
            deque.push(new int[]{0, y});
            // y装满
            deque.push(new int[]{x, jug2Capacity});
            // y倒空
            deque.push(new int[]{x, 0});
            // x向y倒水，直到装满或倒空
            deque.push(new int[]{x - Math.min(jug2Capacity - y, x), y + Math.min(jug2Capacity - y, x)});
            // y向x倒水，直到装满或倒空
            deque.push(new int[]{x + Math.min(jug1Capacity - x, y), y - Math.min(jug1Capacity - x, y)});
        }
        return false;
    }

    // 计算hash
    private long getHash(int[] item) {
        // 这个hash的计算方式有点瞧不明白.
        return (long) item[0] * 10000001 + item[1];
    }

}
