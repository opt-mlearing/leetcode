package leetcode.base;

/**
 * 485. 最大连续 1 的个数
 * https://leetcode.cn/problems/max-consecutive-ones/
 *
 * @author: caogl
 * @date: 2022/7/24, 15:41
 **/
public class Solution485 {

    public int findMaxConsecutiveOnes(int[] nums) {
        int size = nums.length;
        int res = 0;
        int tmp = 0;
        for (int i = 0; i < size; ++i) {
            if (nums[i] == 1) {
                tmp++;
                res = Math.max(res, tmp);
            } else {
                tmp = 0;
            }
        }
        return res;
    }

}
