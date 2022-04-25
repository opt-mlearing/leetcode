package leetcode.base;

/**
 * 1646. 获取生成数组中的最大值
 * https://leetcode-cn.com/problems/get-maximum-in-generated-array/
 */
public class Solution1646 {

    public int getMaximumGenerated(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        if (n == 0) {
            return 0;
        }
        dp[1] = 1;
        int res = 1;
        for (int i = 2; i <= n; ++i) {
            if (i % 2 == 0) {
                dp[i] = dp[i / 2];
            } else {
                dp[i] = dp[i / 2] + dp[i / 2 + 1];
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}
