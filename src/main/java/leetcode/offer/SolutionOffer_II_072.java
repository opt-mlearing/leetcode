package leetcode.offer;

/**
 * 剑指 Offer II 072. 求平方根
 * https://leetcode.cn/problems/jJ0w9p/
 */
public class SolutionOffer_II_072 {

    public int mySqrt_1(int x) {
        int left = 0;
        int right = x;
        int res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid <= x) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        int left = 0;
        int right = x;
        int res = -1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid <= x) {
                res = mid;
                left = mid;
            } else {
                right = mid;
            }
        }
        return res;
    }

}
