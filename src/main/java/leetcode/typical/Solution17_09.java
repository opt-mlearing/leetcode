package leetcode.typical;

/**
 * 面试题 17.09. 第 k 个数
 * https://leetcode-cn.com/problems/get-kth-magic-number-lcci/
 */
public class Solution17_09 {

    public int getKthMagicNumber(int k) {
        int[] dp = new int[k + 1];
        dp[1] = 1;
        int a = 1;
        int b = 1;
        int c = 1;
        for (int i = 2; i <= k; ++i) {
            int a1 = 3 * dp[a];
            int b1 = 5 * dp[b];
            int c1 = 7 * dp[c];
            int tmp = Math.min(a1, Math.min(b1, c1));
            dp[i] = tmp;
            if (tmp == a1) {
                a++;
            }
            if (tmp == b1) {
                b++;
            }
            if (tmp == c1) {
                c++;
            }
        }
        return dp[k];
    }

}
