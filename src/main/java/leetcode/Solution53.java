package leetcode;

public class Solution53 {

    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int globalMax = nums[0];
        int pre = 0;
        for (int i = 0; i < nums.length; ++i) {
            pre = Math.max(pre + nums[i], nums[i]);
            globalMax = Math.max(globalMax, pre);
        }
        return globalMax;
    }

}
