package leetcode.base;

/**
 * 357. 统计各位数字都不同的数字个数
 * https://leetcode-cn.com/problems/count-numbers-with-unique-digits/
 */
public class Solution357 {

    private int[] arr = {9, 9, 8, 7, 6, 5, 4, 3, 2, 1};

    // 好像投机取巧了.
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 10;
        for (int i = 2; i <= n; ++i) {
            int tmp = 1;
            for (int j = 0; j < i; ++j) {
                tmp *= arr[j];
            }
            dp[i] = dp[i - 1] + tmp;
        }
        return dp[n];
    }

}
