package leetcode.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer II 081. 允许重复选择元素的组合
 * https://leetcode.cn/problems/Ygoe9J/
 */
public class SolutionOffer_II_081 {

    private List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        res = new ArrayList<>();
        backTracking(candidates, 0, target, new LinkedList<Integer>());
        return res;
    }

    private void backTracking(int[] candidates, int index, int target, Deque<Integer> path) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        if (index == candidates.length || candidates[index] > target) {
            return;
        }
        for (int i = index; i < candidates.length; ++i) {
            path.offer(candidates[i]);
            // 如题目中的示例2, 元素2可以重复取, 则index可以不显示+ 1.
            backTracking(candidates, i, target - candidates[i], path);
            path.pollLast();
        }
    }

}
