package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 组合
 * https://leetcode-cn.com/problems/combinations/
 */
public class Solution77 {

    private List<List<Integer>> result;

    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        dfs(nums, 0, k, new ArrayDeque<Integer>());
        return result;
    }

    /* nums&& index 共同表示选择列表, container 表示路径 */
    private void dfs(int[] nums, int index, int limit, Deque<Integer> container) {
        if (index == nums.length && container.size() != limit) {
            return;
        }
        if (container.size() == limit) {
            result.add(new ArrayList<Integer>(container));
            return;
        }
        for (int i = index; i < nums.length; ++i) {
            container.push(nums[i]);
            dfs(nums, i + 1, limit, container);
            container.pop();
        }
    }

}
