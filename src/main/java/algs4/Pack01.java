package algs4;

/**
 * 经典01背包问题.
 * 给定n种物品，每种物品都有重量w(i)和价值v(i)，每种物品都只有一个。
 * 另外，背包容量为W，求解在不超过背包容量的情况下将哪些物品放入背包，
 * 才可以使背包中的物品价值之和最大.每种物品只有一个，要不不放入（0），
 * 要么放入（1），因此称为01背包.
 */
public class Pack01 {

    public void testFunction(String[] args) {
        int[] w = {2, 5, 4, 2, 3};
        int[] v = {6, 3, 5, 4, 6};
        int pack1 = this.pack1(w, v, 10, 5);
        int pack2 = this.pack2(w, v, 10, 5);
        assert pack1 == pack2;
    }

    // dp[i] 表示放入物品i的最大价值.
    public int pack2(int[] w, int[] v, int W, int n) {
        int[] dp = new int[W + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = W; j >= w[i - 1]; --j) {
                // j-> w[i- 1] 越忘0逼近，那么价值就越小.
                dp[j] = Math.max(dp[j], dp[j - w[i - 1]] + v[i - 1]);
            }
        }
        return dp[W];
    }

    /**
     * @param w 重量
     * @param v 价值
     * @param W 背包总容量
     * @param n n个物品
     * @return
     */
    public int pack1(int[] w, int[] v, int W, int n) {
        int[][] dp = new int[n + 1][W + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= W; ++j) {
                if (j < w[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i - 1]] + v[i - 1]);
                }
            }
        }
        return dp[n][W];
    }

    /**
     * 找到最有组合
     *
     * @param costs
     * @param n
     * @param W
     * @return
     */
    public int[] findBestPlan(int[][] costs, int[] w, int n, int W) {
        int[] trick = new int[n];
        int j = W;
        for (int i = n; i > 0; --i) {
            if (costs[i][j] > costs[i - 1][j]) {
                trick[n - 1] = 1;
                j = j - w[i - 1];
            } else {
                trick[n - 1] = 0;
            }
        }
        return trick;
    }

}
