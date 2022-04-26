package leetcode.typical;

/**
 * 面试题 08.01. 三步问题
 * https://leetcode-cn.com/problems/three-steps-problem-lcci/
 */
public class Solution08_01 {

    public int waysToStep(int n) {
        int[] dp = new int[n + 1 > 4 ? n + 1 : 4];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= n; ++i) {
            dp[i] = ((dp[i - 1] + dp[i - 2]) % 1000000007 + dp[i - 3]) % 1000000007;
        }
        return dp[n];
    }

}
