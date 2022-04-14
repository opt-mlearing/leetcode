package leetcode;

/**
 * 29. 两数相除
 * https://leetcode-cn.com/problems/divide-two-integers/submissions/
 */
public class Solution29 {

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int single = -1;
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
            single = 1;
        }
        dividend = -Math.abs(dividend);
        divisor = -Math.abs(divisor);
        int res = 0;
        while (dividend <= divisor) {
            int base = divisor;
            int count = 1;
            while (base >= dividend - base) {
                base += base;
                count += count;
            }
            dividend = dividend - base;
            res += count;
        }
        return single * res;
    }

}
