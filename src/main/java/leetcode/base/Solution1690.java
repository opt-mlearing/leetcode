package leetcode.base;

/**
 * 1690. 石子游戏 VII
 * https://leetcode.cn/problems/stone-game-vii/
 *
 * @author: caogl
 * @date: 2022/6/23, 0:50
 **/
public class Solution1690 {

    public int stoneGameVII(int[] stones) {
        int size = stones.length;
        int[][] sum = new int[size][size];
        for (int i = 0; i < size; ++i) {
            sum[i][i] = stones[i];
            for (int j = i + 1; j < size; ++j) {
                sum[i][j] = sum[i][j - 1] + stones[j];
            }
        }
        int[][] dp = new int[size][size];
        for (int i = size - 1; i >= 0; --i) {
            for (int j = i + 1; j < size; ++j) {
                dp[i][j] = Math.max(sum[i + 1][j] - dp[i + 1][j], sum[i][j - 1] - dp[i][j - 1]);
            }
        }
        return dp[0][size - 1];
    }

}
