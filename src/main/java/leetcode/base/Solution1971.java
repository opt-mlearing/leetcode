package leetcode.base;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 1971. 寻找图中是否存在路径
 * https://leetcode-cn.com/problems/find-if-path-exists-in-graph/
 */
public class Solution1971 {

    // 这个实现效率真的低，哭了
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) {
            return true;
        }
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            list.add(new ArrayList<Integer>());
        }
        for (int[] item : edges) {
            list.get(item[0]).add(item[1]);
            list.get(item[1]).add(item[0]);
        }
        Deque<Integer> deque = new LinkedList<Integer>();
        deque.offer(source);
        // 标记数组
        boolean[] isVisit = new boolean[n];
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; ++i) {
                int tmp = deque.poll();
                if (isVisit[tmp]) {
                    continue;
                }
                isVisit[tmp] = true;
                List<Integer> subList = list.get(tmp);
                for (Integer element : subList) {
                    // 避免存在环，无限循环
                    if (isVisit[element]) {
                        continue;
                    }
                    if (element == destination) {
                        return true;
                    } else {
                        deque.offer(element);
                    }
                }
            }
        }
        return false;
    }

}
