package leetcode.base;

/**
 * x 的平方根
 * https://leetcode-cn.com/problems/sqrtx/
 */
public class Solution69 {

    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if ((long) mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

}
