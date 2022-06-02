package leetcode.offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer II 079. 所有子集
 * https://leetcode.cn/problems/TVdhkn/
 */
public class SolutionOffer_II_079 {

    private List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
        int size = nums.length;
        res = new ArrayList<>();
        backTracking(nums, 0, size, new LinkedList<Integer>());
        return res;
    }

    private void backTracking(int[] nums, int index, int size, Deque<Integer> path) {
        if (index == size) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        backTracking(nums, index + 1, size, path);
        path.offer(nums[index]);
        backTracking(nums, index + 1, size, path);
        path.pollLast();
    }

    private void backTracking_1(int[] nums, int index, int size, Deque<Integer> path) {
        if (index == size) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        res.add(new ArrayList<Integer>(path));
        for (int i = index; i < size; ++i) {
            path.offer(nums[i]);
            backTracking(nums, i + 1, size, path);
            path.pollLast();
        }
    }

}
