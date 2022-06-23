package leetcode.base;

/**
 * 553. 最优除法
 * https://leetcode.cn/problems/optimal-division/
 *
 * @author: caogl
 * @date: 2022/6/24, 0:55
 **/
public class Solution553 {

    // 9ms/41.4mb
    public String optimalDivision(int[] nums) {
        int size = nums.length;
        Node[][] dp = new Node[size][size];
        for (int i = 0; i < size; ++i) {
            for (int j = i; j < size; ++j) {
                dp[i][j] = new Node();
            }
        }
        for (int i = 0; i < size; ++i) {
            dp[i][i] = new Node(nums[i], nums[i], String.valueOf(nums[i]), String.valueOf(nums[i]));
        }
        for (int len = 1; len < size; ++len) {
            for (int i = 0; i < size - len; ++i) {
                int j = i + len;
                for (int k = i; k < j; ++k) {
                    double tmpMax = dp[i][k].maxVal / dp[k + 1][j].minVal;
                    double tmpMIn = dp[i][k].minVal / dp[k + 1][j].maxVal;
                    if (dp[i][j].maxVal < tmpMax) {
                        dp[i][j].maxVal = tmpMax;
                        if (k + 1 == j) {
                            dp[i][j].maxStr = dp[i][k].maxStr + "/" + dp[k + 1][j].minStr;
                        } else {
                            dp[i][j].maxStr = dp[i][k].maxStr + "/(" + dp[k + 1][j].minStr + ")";
                        }
                    }
                    if (dp[i][j].minVal > tmpMIn) {
                        dp[i][j].minVal = tmpMIn;
                        if (k + 1 == j) {
                            dp[i][j].minStr = dp[i][k].minStr + "/" + dp[k + 1][j].maxStr;
                        } else {
                            dp[i][j].minStr = dp[i][k].minStr + "/(" + dp[k + 1][j].maxStr + ")";
                        }
                    }
                }
            }
        }
        return dp[0][size - 1].maxStr;
    }

    private static class Node {
        private double minVal;
        private double maxVal;
        private String minStr;
        private String maxStr;

        public Node() {
            this.minVal = 10000.0;
            this.maxVal = 0.0;
            this.minStr = "";
            this.maxStr = "";
        }

        public Node(double minVal, double maxVal, String minStr, String maxStr) {
            this.minVal = minVal;
            this.maxVal = maxVal;
            this.minStr = minStr;
            this.maxStr = maxStr;
        }
    }

}
