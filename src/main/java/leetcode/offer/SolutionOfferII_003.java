package leetcode.offer;

/**
 * 剑指 Offer II 003. 前 n 个数字二进制中 1 的个数
 * https://leetcode-cn.com/problems/w3tCBm/
 */
public class SolutionOfferII_003 {

    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            dp[i] = dp[i >> 1] + (i % 2);
        }
        return dp;
    }

}
