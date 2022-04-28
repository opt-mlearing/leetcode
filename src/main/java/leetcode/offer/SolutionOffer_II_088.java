package leetcode.offer;

/**
 * 剑指 Offer II 088. 爬楼梯的最少成本
 * https://leetcode-cn.com/problems/GzCJIP/
 */
public class SolutionOffer_II_088 {

    public int minCostClimbingStairs(int[] cost) {
        int size = cost.length;
        int[] dp = new int[size + 1 <= 2 ? 2 : size + 1];
        // 可以从第0或1阶梯.
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= size; ++i) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[size];
    }

}
