package leetcode.base;

/**
 * 486. 预测赢家
 * https://leetcode-cn.com/problems/predict-the-winner/
 *
 * @author: caogl
 * @date: 2022/6/21, 21:36
 **/
public class Solution486 {

    public boolean PredictTheWinner(int[] nums) {
        int size = nums.length;
        int[] dp = new int[size];
        for (int i = size - 1; i >= 0; --i) {
            dp[i] = nums[i];
            for (int j = i + 1; j < size; ++j) {
                dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
            }
        }
        return dp[size - 1] >= 0;
    }

    public boolean PredictTheWinner_4(int[] nums) {
        int size = nums.length;
        int[][] dp = new int[size][size];
        for (int i = size - 1; i >= 0; --i) {
            dp[i][i] = nums[i];
            for (int j = i + 1; j < size; ++j) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][size - 1] >= 0;
    }

    public boolean PredictTheWinner_3(int[] nums) {
        int size = nums.length;
        int[][] dp = new int[size][size];
        for (int i = 0; i < size; ++i) {
            dp[i][i] = nums[i];
        }
        for (int len = 1; len < size; ++len) {
            for (int i = 0; i < size - len; ++i) {
                int j = i + len;
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][size - 1] >= 0;
    }

    // 递归+ 记忆化搜索.
    public boolean PredictTheWinner_recursion(int[] nums) {
        int size = nums.length;
        Integer[][] memo = new Integer[size][size];
        return dfs(memo, 0, size - 1, nums) >= 0;
    }

    private int dfs(Integer[][] memo, int i, int j, int[] nums) {
        if (i > j) {
            return 0;
        }
        if (null != memo[i][j]) {
            return memo[i][j];
        }
        int tmp = Math.max(nums[i] - dfs(memo, i + 1, j, nums), nums[j] - dfs(memo, i, j - 1, nums));
        memo[i][j] = tmp;
        return tmp;
    }

    // 二维dp
    public boolean PredictTheWinner_2(int[] nums) {
        int size = nums.length;
        int[][] dp = new int[size][size];
        for (int i = 0; i < size; ++i) {
            dp[i][i] = nums[i];
        }
        // i<= j
        for (int i = size - 2; i >= 0; --i) {
            for (int j = i + 1; j < size; ++j) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][size - 1] >= 0;
    }

    // 一维dp
    public boolean PredictTheWinner_1(int[] nums) {
        int size = nums.length;
        int[] dp = new int[size];
        for (int i = 0; i < size; ++i) {
            dp[i] = nums[i];
        }
        for (int i = size - 2; i >= 0; --i) {
            for (int j = i + 1; j < size; ++j) {
                dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
            }
        }
        return dp[size - 1] >= 0;
    }

}
