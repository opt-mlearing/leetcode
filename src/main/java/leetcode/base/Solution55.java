package leetcode.base;

/**
 * 跳跃游戏
 * https://leetcode-cn.com/problems/jump-game/
 */
public class Solution55 {

    public boolean canJump(int[] nums) {
        int maxRight = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i <= maxRight) {
                maxRight = Math.max(maxRight, i + nums[i]);
                // 注意，只要大于等于就阔以啦.
                if (maxRight >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }

}
