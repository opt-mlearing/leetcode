package leetcode.base;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 216. 组合总和 III
 * https://leetcode-cn.com/problems/combination-sum-iii/
 */
public class Solution216 {

    private List<List<Integer>> res;

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.res = new ArrayList<>();
        // 只能使用1到9, start==1.
        backTrack(1, new ArrayDeque<Integer>(), k, n);
        return res;
    }

    private void backTrack(int index, Deque<Integer> deque, int sizeLimit, int target) {
        if (target < 0 || deque.size() > sizeLimit) {
            return;
        }
        if (target == 0 && deque.size() == sizeLimit) {
            res.add(new ArrayList<Integer>(deque));
            return;
        }
        // 只能使用1到9, end==9.
        for (int i = index; i <= 9; ++i) {
            deque.offer(i);
            backTrack(i + 1, deque, sizeLimit, target - i);
            deque.pollLast();
        }
    }

}
