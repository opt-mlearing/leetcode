package leetcode.base;

/**
 * 1413. 逐步求和得到正数的最小值
 * https://leetcode.cn/problems/minimum-value-to-get-positive-step-by-step-sum/
 */
public class Solution1413 {

    public int minStartValue(int[] nums) {
        int sum = 0;
        int res = Integer.MAX_VALUE;
        for (int num : nums) {
            sum += num;
            res = Math.min(res, sum);
        }
        return Math.max(1, 1 - res);
    }

}
