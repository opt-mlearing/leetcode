package leetcode.base;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 77. 组合
 * https://leetcode-cn.com/problems/combinations/
 */
public class Solution77 {

    private List<List<Integer>> res;
    private Deque<Integer> path;

    // 无减枝操作时 18 ms- 25.08%/ 42.4 MB-69.00&
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        backTracking(n, k, 1, new LinkedList<Integer>());
        return res;
    }

    private void backTracking(int n, int k, int startIndex, Deque<Integer> path) {
        // path的长度是不可以超过k的.
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 加减枝后，1ms- 100.0%/ 42.5MB- 52.77%
        for (int i = startIndex; i <= n - (k - path.size()) + 1; ++i) {
            path.offer(i);
            backTracking(n, k, i + 1, path);
            path.pollLast();
        }
    }

}
