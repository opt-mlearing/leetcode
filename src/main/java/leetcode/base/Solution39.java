package leetcode.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 39. 组合总和
 * https://leetcode-cn.com/problems/combination-sum/
 */
public class Solution39 {

    private List<List<Integer>> res;

    // 未减枝，4ms/ 41.8MB
    // 减枝后，2ms/ 41.7MB
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        res = new ArrayList<>();
        backTracking(candidates, target, 0, 0, new LinkedList<Integer>());
        return res;
    }

    private void backTracking(int[] candidates, int target, int sum, int startIndex, Deque<Integer> path) {
        if (sum > target || startIndex == candidates.length) {
            return;
        }
        if (sum == target) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        // candidates已经做了升序排序，这里做一下减枝.
        if (sum + candidates[startIndex] > target) {
            return;
        }
        for (int i = startIndex; i < candidates.length; ++i) {
            int tmp = candidates[i];
            path.offer(tmp);
            sum += tmp;
            backTracking(candidates, target, sum, i, path);
            sum -= tmp;
            path.pollLast();
        }
    }

}
