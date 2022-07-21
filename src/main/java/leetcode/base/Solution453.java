package leetcode.base;

/**
 * 453. 最小操作次数使数组元素相等
 * https://leetcode.cn/problems/minimum-moves-to-equal-array-elements/
 *
 * @author: caogl
 * @date: 2022/7/22, 0:42
 **/
public class Solution453 {

    public int minMoves(int[] nums) {
        int size = nums.length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < size; ++i) {
            min = Math.min(min, nums[i]);
        }
        int res = 0;
        for (int i = 0; i < size; ++i) {
            res += nums[i] - min;
        }
        return res;
    }

}
