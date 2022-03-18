package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 全排列
 * https://leetcode-cn.com/problems/permutations/
 */
public class Solution46 {

    private List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        List<Integer> container = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; ++i) {
            container.add(nums[i]);
        }
        dfs(nums, 0, container);
        return res;
    }

    private void dfs(int[] nums, int index, List<Integer> container) {
        if (index == nums.length) {
            res.add(new ArrayList<Integer>(container));
            return;
        }
        for (int i = index; i < nums.length; ++i) {
            Collections.swap(container, i, index);
            dfs(nums, index + 1, container);
            Collections.swap(container, i, index);
        }
    }

}
