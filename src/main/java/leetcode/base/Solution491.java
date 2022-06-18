package leetcode.base;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;
import java.util.LinkedList;
import java.util.List;

/**
 * 491. 递增子序列
 * https://leetcode.cn/problems/increasing-subsequences/
 *
 * @author: caogl
 * @date: 2022/6/18, 21:56
 **/
public class Solution491 {

    private List<List<Integer>> res;

    public List<List<Integer>> findSubsequences(int[] nums) {
        res = new ArrayList<>();
        backTrack(nums, 0, new LinkedList<Integer>());
        return res;
    }

    private void backTrack(int[] nums, int index, Deque<Integer> path) {
        if (index == nums.length) {
            if (path.size() > 1) {
                res.add(new ArrayList<Integer>(path));
            }
            return;
        }
        if ((path.isEmpty() || path.peekLast() != nums[index])) {
            backTrack(nums, index + 1, path);
        }
        if ((path.isEmpty() || path.peekLast() <= nums[index])) {
            path.offer(nums[index]);
            backTrack(nums, index + 1, path);
            path.pollLast();
        }
    }

    public List<List<Integer>> findSubsequences_bt(int[] nums) {
        res = new ArrayList<>();
        backTracking(nums, 0, new LinkedList<Integer>());
        return res;
    }

    private void backTracking(int[] nums, int index, Deque<Integer> path) {
        if (path.size() > 1) {
            res.add(new ArrayList<Integer>(path));
        }
        if (index == nums.length) {
            return;
        }
        Set<Integer> set = new HashSet<Integer>();
        for (int i = index; i < nums.length; ++i) {
            // 同一个位置出现相同的数字，去重.
            if (set.contains(nums[i])) {
                continue;
            }
            if (path.isEmpty() || path.peekLast() <= nums[i]) {
                set.add(nums[i]);
                path.offer(nums[i]);
                backTracking(nums, i + 1, path);
                path.pollLast();
            }
        }
    }

}
