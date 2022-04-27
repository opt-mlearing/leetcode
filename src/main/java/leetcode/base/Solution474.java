package leetcode.base;

/**
 * 474. 一和零
 * https://leetcode-cn.com/problems/ones-and-zeroes/
 */
public class Solution474 {

    public int findMaxForm(String[] strs, int m, int n) {
        // dp[i][j]：最多有i个0和j个1的strs的最大子集的元素数量.
        // dp[i][j]= max(dp[i][[j], dp[i- zeroNum][j- oneNum]+ 1).
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for (String str : strs) {
            int oneCount = 0;
            int zeroCount = 0;
            for (int i = 0; i < str.length(); ++i) {
                int index = str.charAt(i) - '0';
                if (index == 0) {
                    ++zeroCount;
                } else if (index == 1) {
                    ++oneCount;
                }
            }
            for (int i = m; i >= zeroCount; --i) {
                for (int j = n; j >= oneCount; --j) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroCount][j - oneCount] + 1);
                }
            }
        }
        return dp[m][n];
    }

}
