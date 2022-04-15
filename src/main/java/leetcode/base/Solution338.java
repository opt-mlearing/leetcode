package leetcode.base;

/**
 * 比特位计数
 * https://leetcode-cn.com/problems/counting-bits/
 */
public class Solution338 {

    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        int highBit = 0;
        for (int i = 1; i <= n; ++i) {
            // 如果正整数 y 是 2 的整数次幂，则 y 的二进制表示中只有最高位是 1，其余都是 0，
            // 因此 (y& (y-1)) = 0 故，正整数 y 是 2 的整数次幂，
            if ((i & (i - 1)) == 0) {
                highBit = i;
            }
            dp[i] = dp[i - highBit] + 1;
        }
        return dp;
    }

}
