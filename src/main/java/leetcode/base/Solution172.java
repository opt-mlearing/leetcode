package leetcode.base;

/**
 * 172. 阶乘后的零
 * https://leetcode-cn.com/problems/factorial-trailing-zeroes/
 */
public class Solution172 {

    // 迭代
    public int trailingZeroes(int n) {
        int res = 0;
        for (int i = 5; i <= n; i += 5) {
            for (int j = i; j % 5 == 0; j /= 5) {
                res++;
            }
        }
        return res;
    }

    // 递归
    public int trailingZeroes_1(int n) {
        return n / 5 == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }

}
