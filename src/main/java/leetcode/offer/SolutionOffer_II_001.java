package leetcode.offer;

/**
 * 剑指 Offer II 001. 整数除法
 * https://leetcode.cn/problems/xoh6Oh/
 */
public class SolutionOffer_II_001 {

    public int divide(int a, int b) {
        if (a == Integer.MIN_VALUE && b == -1) {
            return Integer.MAX_VALUE;
        }
        int single = -1;
        if ((a > 0 && b > 0) || (a < 0 && b < 0)) {
            single = 1;
        }
        a = -Math.abs(a);
        b = -Math.abs(b);
        int res = 0;
        while (a <= b) {
            int base = b;
            int count = 1;
            while (base >= a - base) {
                count += count;
                base += base;
            }
            a -= base;
            res += count;
        }
        return single == -1 ? -res : res;
    }

}
