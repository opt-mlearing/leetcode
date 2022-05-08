package leetcode.base;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 565. 数组嵌套
 * https://leetcode-cn.com/problems/array-nesting/
 */
public class Solution565 {

    private int res;
    private boolean[] isVisit;

    public int arrayNesting(int[] nums) {
        int n = nums.length;
        isVisit = new boolean[n];
        int res = 0;
        Arrays.fill(isVisit, true);
        for (int i = 0; i < n; ++i) {
            if (isVisit[i]) {
                int index = nums[i];
                int count = 0;
                do {
                    index = nums[index];
                    count++;
                    isVisit[index] = false;
                } while (index != nums[i]);
                res = Math.max(res, count);
            }
        }
        return res;
    }

    // 依旧超时
    public int arrayNesting_2(int[] nums) {
        int n = nums.length;
        res = 0;
        isVisit = new boolean[n];
        Arrays.fill(isVisit, true);
        for (int i = 0; i < n; ++i) {
            dfs(nums, i, new HashSet<Integer>());
        }
        return res;
    }

    private void dfs(int[] nums, int index, Set<Integer> path) {
        if (!isVisit[index]) {
            return;
        }
        isVisit[index] = false;
        if (!path.add(nums[index])) {
            res = Math.max(res, path.size());
            return;
        }
        dfs1(nums, nums[index], path);
    }

    // 会超时
    public int arrayNesting_1(int[] nums) {
        int n = nums.length;
        res = 0;
        for (int i = 0; i < n; ++i) {
            dfs1(nums, i, new HashSet<Integer>());
        }
        return res;
    }

    private void dfs1(int[] nums, int index, Set<Integer> path) {
        if (!path.add(nums[index])) {
            res = Math.max(res, path.size());
            return;
        }
        dfs1(nums, nums[index], path);
    }

}
