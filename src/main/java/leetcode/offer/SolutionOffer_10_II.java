package leetcode.offer;

/**
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 * https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 */
public class SolutionOffer_10_II {

    public int numWays(int n) {
        int[] dp = new int[n + 1 > 3 ? n + 1 : 3];
        // 其实dp[0]没啥意义，这里赋值0或1均可，看答案case dp[0]= 1.
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        // dp[i]= dp[i- 1]+ dp[i- 2].
        for (int i = 3; i <= n; ++i) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }

}
