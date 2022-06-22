package leetcode.base;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1713. 得到子序列的最少操作次数
 * https://leetcode.cn/problems/minimum-operations-to-make-a-subsequence/
 *
 * @author caogaoli
 * @date 2022/6/22 17:59
 */
public class Solution1713 {

    // 68ms/62.3mb
    public int minOperations(int[] target, int[] arr) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int m = target.length;
        // target中所有元素互不相等.
        for (int i = 0; i < m; ++i) {
            map.put(target[i], i);
        }
        int n = arr.length;
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i) {
            if (map.containsKey(arr[i])) {
                list.add(map.get(arr[i]));
            }
        }
        int subSize = lengthOfLIS(list);
        return m - subSize;
    }

    // 求索引最长上升子序列.
    public int lengthOfLIS1(int[] nums) {
        int size = nums.length;
        int[] dp = new int[size];
        int res = 0;
        for (int i = 0; i < size; ++i) {
            int pos = Arrays.binarySearch(dp, 0, res, nums[i]);
            if (pos < 0) {
                pos = -(pos + 1);
            }
            dp[pos] = nums[i];
            if (pos == res) {
                res++;
            }
        }
        return res;
    }

    // 求最长上升子序长度.
    private int lengthOfLIS(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return 0;
        }
        // list转成 array.
        // 执行速度会快一点.
        int size = list.size();
        int[] nums = new int[size];
        for (int i = 0; i < size; ++i) {
            nums[i] = list.get(i);
        }
        int res = 0;
        int[] dp = new int[size];
        for (int i = 0; i < size; ++i) {
            int pos = binarySearch(dp, res, nums[i]);
            dp[pos] = nums[i];
            if (res == pos) {
                res++;
            }
        }
        return res;
    }

    // 二分查找.
    private int binarySearch(int[] dp, int size, int target) {
        int left = 0;
        int right = size - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (dp[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }


    // 想太简单，会超出内存限制.
    // out of memory limit.
    public int minOperations_out_of_memory_limit(int[] target, int[] arr) {
        int size = target.length;
        int subSize = longerSub(target, arr);
        return Math.max(0, size - subSize);
    }

    private int longerSub(int[] target, int[] arr) {
        int m = target.length;
        int n = arr.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (target[i] == arr[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[m][n];
    }

}
