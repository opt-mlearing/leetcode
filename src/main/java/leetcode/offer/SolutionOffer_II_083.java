package leetcode.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 剑指 Offer II 083. 没有重复元素集合的全排列
 * https://leetcode.cn/problems/VvJkup/
 */
public class SolutionOffer_II_083 {

    private List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        List<Integer> path = new ArrayList<Integer>();
        for (int num : nums) {
            path.add(num);
        }
        backTracking(nums.length, 0, path);
        return res;
    }

    private void backTracking(int size, int index, List<Integer> path) {
        if (index == size) {
            res.add(new ArrayList<Integer>(path));
        }
        for (int i = index; i < size; ++i) {
            Collections.swap(path, i, index);
            backTracking(size, index + 1, path);
            Collections.swap(path, index, i);
        }
    }

}
