package leetcode.base;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 435. 无重叠区间
 * https://leetcode-cn.com/problems/non-overlapping-intervals/
 */
public class Solution435 {

    // 贪心.
    public int eraseOverlapIntervals(int[][] intervals) {
        int size = intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[1]));
        int right = intervals[0][1];
        int len = 1;
        for (int i = 1; i < size; ++i) {
            if (intervals[i][0] >= right) {
                len++;
                right = intervals[i][1];
            }
        }
        return size - len;
    }

    // 回超时，需要优化.
    public int eraseOverlapIntervals_time_out(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        int size = intervals.length;
        int[] dp = new int[size];
        Arrays.fill(dp, 1);
        int maxSize = 1;
        for (int i = 1; i < size; ++i) {
            for (int j = 0; j < i; ++j) {
                if (intervals[j][1] <= intervals[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxSize = Math.max(maxSize, dp[i]);
        }
        return size - maxSize;
    }

}
