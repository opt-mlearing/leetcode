package leetcode.offer;

/**
 * 剑指 Offer 03. 数组中重复的数字
 * https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 */
public class SolutionOffer_03 {

    public int findRepeatNumber(int[] nums) {
        int size = nums.length;
        for (int i = 0; i < size; ++i) {
            while (i != nums[i]) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                int tmp = nums[i];
                nums[i] = nums[nums[i]];
                nums[tmp] = tmp;
            }
        }
        return -1;
    }

}
