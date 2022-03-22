package leetcode;

/**
 * 丑数
 * https://leetcode-cn.com/problems/ugly-number/
 */
public class Solution263 {

    public boolean isUgly(int n) {
        if (n < 1) {
            return false;
        }
        int[] nums = {2, 3, 5};
        for (int i = 0; i < nums.length; ++i) {
            while (n % nums[i] == 0) {
                n = n / nums[i];
            }
        }
        return n == 1;
    }

}
