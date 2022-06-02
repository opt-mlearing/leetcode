package leetcode.offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer II 080. 含有 k 个元素的组合
 * https://leetcode.cn/problems/uUsW3B/
 */
public class SolutionOffer_II_80 {

    private List<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        backTracking(n, 1, k, new LinkedList<Integer>());
        return res;
    }

    private void backTracking(int n, int index, int size, Deque<Integer> path) {
        if (path.size() == size) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        // 这里需要减枝一下.
        for (int i = index; i <= n - (size - path.size()) + 1; i++) {
            path.offer(i);
            backTracking(n, i + 1, size, path);
            path.pollLast();
        }
    }

}
