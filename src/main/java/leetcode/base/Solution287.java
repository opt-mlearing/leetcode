package leetcode.base;

/**
 * 寻找重复数
 * https://leetcode-cn.com/problems/find-the-duplicate-number/
 */
public class Solution287 {

    public int findDuplicate(int[] nums) {
        int left = 1;
        int right = nums.length - 1;
        int res = -1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            int count = 0;
            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] <= mid) {
                    count++;
                }
            }
            if (count <= mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
                res = mid;
            }
        }
        return res;
    }

}
