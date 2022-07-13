package leetcode.base;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 841. 钥匙和房间
 * https://leetcode.cn/problems/keys-and-rooms/submissions/
 *
 * @author caogaoli
 * @date 2022/7/13 16:39
 */
public class Solution841 {

    private int count;

    // 看起来深度搜索的效率高一些.
    // dfs
    // 0ms/ 41.2mb
    public boolean canVisitAllRooms_dfs(List<List<Integer>> rooms) {
        int size = rooms.size();
        boolean[] isVisit = new boolean[size];
        dfs(0, isVisit, rooms);
        return count == size;
    }

    private void dfs(int index, boolean[] isVisit, List<List<Integer>> rooms) {
        if (isVisit[index]) {
            return;
        }
        count++;
        isVisit[index] = true;
        for (int item : rooms.get(index)) {
            dfs(item, isVisit, rooms);
        }
    }

    // bfs
    // 2ms/ 41.6mb
    public boolean canVisitAllRooms_bfs(List<List<Integer>> rooms) {
        int size = rooms.size();
        boolean[] isVisit = new boolean[size];
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.offer(0);
        int count = 0;
        while (!stack.isEmpty()) {
            int top = stack.poll();
            if (!isVisit[top]) {
                count++;
                isVisit[top] = true;
                for (int item : rooms.get(top)) {
                    stack.offer(item);
                }
            }
        }
        return count == size;
    }

}
