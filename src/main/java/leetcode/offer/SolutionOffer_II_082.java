package leetcode.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer II 082. 含有重复元素集合的组合
 * https://leetcode.cn/problems/4sjJUc/
 */
public class SolutionOffer_II_082 {

    private List<List<Integer>> res;
    private List<int[]> frequent;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 首先进行排序.
        Arrays.sort(candidates);
        frequent = new ArrayList<int[]>();
        res = new ArrayList<>();
        int size = candidates.length;
        for (int i = 0; i < size; ++i) {
            if (frequent.isEmpty() || frequent.get(frequent.size() - 1)[0] != candidates[i]) {
                frequent.add(new int[]{candidates[i], 1});
            } else {
                int lastIndex = frequent.size() - 1;
                frequent.get(lastIndex)[1]++;
            }
        }
        backTracking(0, target, new LinkedList<Integer>());
        return res;
    }

    private void backTracking(int index, int target, Deque<Integer> path) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        if (index == frequent.size() || frequent.get(index)[0] > target) {
            return;
        }
        backTracking(index + 1, target, path);
        int[] tmp = frequent.get(index);
        int count = Math.min(target / tmp[0], tmp[1]);
        for (int i = 1; i <= count; ++i) {
            path.offer(tmp[0]);
            backTracking(index + 1, target - i * tmp[0], path);
        }
        for (int i = 1; i <= count; ++i) {
            path.pollLast();
        }
    }

}
