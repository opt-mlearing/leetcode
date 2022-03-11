package leetcode;

/**
 * 有序数组的平方
 * 已知nums已经按照升序排序，显然，如果数组 nums 中的所有数都是非负数，那么将每个数平方后，数组仍然保持升序；
 * 如果数组 nums 中的所有数都是负数，那么将的每个数平方后，数组会保持降序.
 * <p>
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 */
public class Solution977 {

    // 注意：题目中已经明确是整数，不需要考虑-1/0/1的大小问题
    public int[] sortedSquares(int[] nums) {
        int negative = -1;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] < 0) {
                negative = i;
            } else {
                break;
            }
        }

        int[] tmp = new int[nums.length];
        int left = negative;
        int right = negative + 1;
        int index = 0;
        while (left >= 0 || right < nums.length) {
            if (left == -1) {
                tmp[index++] = nums[right] * nums[right];
                right++;
            } else if (right == nums.length) {
                tmp[index++] = nums[left] * nums[left];
                left--;
            } else if (nums[left] * nums[left] <= nums[right] * nums[right]) {
                tmp[index++] = nums[left] * nums[left];
                left--;
            } else {
                tmp[index++] = nums[right] * nums[right];
                right++;
            }
        }
        return tmp;
    }

}
