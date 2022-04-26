package leetcode.offer;

/**
 * 剑指 Offer 49. 丑数
 * https://leetcode-cn.com/problems/chou-shu-lcof/
 */
public class SolutionOffer49 {

    // 只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）.
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int a = 1;
        int b = 1;
        int c = 1;
        for (int i = 2; i <= n; ++i) {
            int n1 = dp[a] * 2;
            int n2 = dp[b] * 3;
            int n3 = dp[c] * 5;
            int minVal = Math.min(n1, Math.min(n2, n3));
            if (minVal == n1) {
                a++;
            }
            if (minVal == n2) {
                b++;
            }
            if (minVal == n3) {
                c++;
            }
            dp[i] = minVal;
        }
        return dp[n];
    }

}
