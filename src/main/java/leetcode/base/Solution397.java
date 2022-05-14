package leetcode.base;

/**
 * 397. 整数替换
 * https://leetcode-cn.com/problems/integer-replacement/
 */
public class Solution397 {

    public int integerReplacement(int n) {
        if (n == 1) {
            return 0;
        }
        if (n % 2 == 0) {
            return integerReplacement(n / 2) + 1;
        }
        return Math.min(integerReplacement(n / 2), integerReplacement(n / 2 + 1)) + 2;
    }

}
