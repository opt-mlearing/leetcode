package leetcode;

/**
 * 跳跃游戏 II
 * https://leetcode-cn.com/problems/jump-game-ii/
 */
public class Solution45 {

    // 从后往前找
    public int jump(int[] nums) {
        int count = 0;
        int right = nums.length - 1;
        while (right > 0) {
            for (int i = 0; i < right; ++i) {
                if (nums[i] + i >= right) {
                    right = i;
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    // 从前往后找
    // 前提是，一定存在可以走到最后一个点的组合，若否则错.
    public int jump_pre(int[] nums) {
        if (!canJump(nums)) {
            return -1;
        }
        // 上一步可走的最大距离
        int singleStep = 0;
        int right = 0;
        int count = 0;
        for (int i = 0; i < nums.length - 1; ++i) {
            right = Math.max(right, nums[i] + i);
            if (singleStep == i) {
                count++;
                singleStep = right;
            }
        }
        return count;
    }

    // 是否存在可到达的组合
    private boolean canJump(int[] nums) {
        int right = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (right >= i) {
                right = Math.max(right, nums[i] + i);
                if (right >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }

}
