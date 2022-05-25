package leetcode.base;

/**
 * 1043. 分隔数组以得到最大和
 * https://leetcode.cn/problems/partition-array-for-maximum-sum/
 */
public class Solution1043 {

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int size = arr.length;
        int[] dp = new int[size + 1];
        dp[0] = 0;
        // 分组的tail.
        for (int i = 1; i <= size; ++i) {
            int val = Integer.MIN_VALUE;
            // 遍历分组的head.
            for (int j = i - 1; j >= Math.max(0, i - k); --j) {
                val = Math.max(val, arr[j]);
                dp[i] = Math.max(dp[i], dp[j] + (i - j) * val);
            }
        }
        return dp[size];
    }

}
