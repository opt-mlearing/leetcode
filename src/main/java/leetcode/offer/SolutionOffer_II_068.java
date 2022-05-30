package leetcode.offer;

/**
 * 剑指 Offer II 068. 查找插入位置
 * https://leetcode.cn/problems/N6YdxV/
 */
public class SolutionOffer_II_068 {

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int res = nums.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target <= nums[mid]) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

}
