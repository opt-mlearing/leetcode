package leetcode.offer;

/**
 * 剑指 Offer 10- I. 斐波那契数列
 * https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 */
public class SolutionOffer10_I {

    public int fib(int n) {
        int size = n + 1 >= 2 ? n + 1 : 2;
        int[] dp = new int[size];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; ++i) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }

}
