package leetcode.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 40. 组合总和 II
 * https://leetcode-cn.com/problems/combination-sum-ii/
 */
public class Solution40 {

    private List<List<Integer>> res;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        res = new ArrayList<>();
        backTracking(candidates, target, 0, new LinkedList<Integer>(), 0);
        return res;
    }

    private void backTracking(int[] candidates, int target, int sum, Deque<Integer> path, int startIndex) {
        if (sum == target) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        // 减少一个搜索. 这个判断可加可不加，要加的话一定加在if(sum== target) 判断之后.
        // 注意，这种情况 candidates[candidates.length- 1]的最后一个元素正好等于target.
        if (startIndex == candidates.length) {
            return;
        }
        // 减枝1
        if (sum + candidates[startIndex] > target) {
            return;
        }
        for (int i = startIndex; i < candidates.length; ++i) {
            // 减枝2
            if (i > startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.offer(candidates[i]);
            // 直接使用的 sum+ candidates[i] 的形式，少写sum 加和减操作.
            backTracking(candidates, target, sum + candidates[i], path, i + 1);
            path.pollLast();
        }
    }

}
