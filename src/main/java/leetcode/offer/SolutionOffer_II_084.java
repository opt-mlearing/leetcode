package leetcode.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer II 084. 含有重复元素集合的全排列
 * https://leetcode.cn/problems/7p8L0Z/
 */
public class SolutionOffer_II_084 {

    private List<List<Integer>> res;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        int size = nums.length;
        res = new ArrayList<>();
        boolean[] isVisit = new boolean[size];
        backTracking(nums, isVisit, 0, new LinkedList<Integer>());
        return res;
    }

    private void backTracking(int[] nums, boolean[] isVisit, int index, Deque<Integer> path) {
        if (index == nums.length) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if ((isVisit[i]) || ((i > 0) && (nums[i] == nums[i - 1]) && (!isVisit[i - 1]))) {
                continue;
            }
            path.offer(nums[i]);
            isVisit[i] = true;
            backTracking(nums, isVisit, index + 1, path);
            isVisit[i] = false;
            path.pollLast();
        }
    }

}
