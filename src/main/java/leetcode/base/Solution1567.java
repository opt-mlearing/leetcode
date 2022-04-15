package leetcode.base;

/**
 * 乘积为正数的最长子数组长度
 * https://leetcode-cn.com/problems/maximum-length-of-subarray-with-positive-product/
 */
public class Solution1567 {

    public int getMaxLen(int[] nums) {
        // 需要定义两个数组
        int[] positive = new int[nums.length];
        int[] negative = new int[nums.length];
        if (nums[0] > 0) {
            positive[0] = 1;
        } else if (nums[0] < 0) {
            negative[0] = 1;
        }
        int len = positive[0];
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > 0) {
                // 当nums[i] 大于0，正负性不改变
                positive[i] = positive[i - 1] + 1;
                // 负数一直没有增加，一直为0.
                negative[i] = negative[i - 1] > 0 ? negative[i - 1] + 1 : 0;
            } else if (nums[i] < 0) {
                // 当nums[i]
                positive[i] = negative[i - 1] > 0 ? negative[i - 1] + 1 : 0;
                negative[i] = positive[i - 1] + 1;
            } else {
                positive[i] = 0;
                negative[i] = 0;
            }
            len = Math.max(len, positive[i]);
        }
        return len;
    }

}
