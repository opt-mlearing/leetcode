package leetcode.base;

/**
 * 1025. 除数博弈
 * https://leetcode-cn.com/problems/divisor-game/
 */
public class Solution1025 {

    // https://leetcode-cn.com/problems/divisor-game/solution/ji-yi-hua-di-gui-dong-tai-gui-hua-shu-xue-fang-fa-/
    public boolean divisorGame(int n) {
        if (n == 1) {
            return false;
        }
        boolean[] dp = new boolean[n + 1];
        // dp[0] 没啥意义可或略
        dp[1] = false;
        dp[2] = true;
        for (int i = 3; i <= n; ++i) {
            for (int j = 1; j <= i / 2; ++j) {
                if ((i % j == 0) && !dp[i - j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

}
