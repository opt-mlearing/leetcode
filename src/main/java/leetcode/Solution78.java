package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution78 {

    private List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        dfs(nums, 0, new ArrayDeque<Integer>());
        return result;
    }

    private void dfs(int[] nums, int index, Deque<Integer> deque) {
        if (index == nums.length) {
            result.add(new ArrayList<Integer>(deque));
            return;
        }
        result.add(new ArrayList<Integer>(deque));
        // 注意这里下一个等待加入的元素.
        for (int i = index; i < nums.length; ++i) {
            deque.push(nums[i]);
            dfs(nums, i + 1, deque);
            deque.pop();
        }
    }

}
