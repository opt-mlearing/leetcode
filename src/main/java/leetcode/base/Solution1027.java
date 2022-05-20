package leetcode.base;

/**
 * 1027. 最长等差数列
 * https://leetcode.cn/problems/longest-arithmetic-subsequence/
 */
public class Solution1027 {

    // dp[i][d]= max(dp[i][d], dp[j][d]+ 1);
    // dp[i][d]表示以第nums[i]个数结尾，共差为d的最大长度.
    public int longestArithSeqLength(int[] nums) {
        int size = nums.length;
        int[][] dp = new int[size][1001];
        int res = 0;
        for (int i = 1; i < size; ++i) {
            for (int j = 0; j < i; ++j) {
                int diff = nums[i] - nums[j] + 500;
                dp[i][diff] = Math.max(dp[i][diff], dp[j][diff] + 1);
                res = Math.max(res, dp[i][diff]);
            }
        }
        return res > 0 ? res + 1 : 0;
    }

}
