package leetcode.offer;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * https://leetcode.cn/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 */
public class SolutionOffer_53_I {

    public int search(int[] nums, int target) {
        int size = nums.length;
        if (size == 0) {
            return 0;
        }
        int fistIndex = first(nums, target, size);
        if (fistIndex == -1) {
            return 0;
        }
        int lastIndex = last(nums, target, size);
        return lastIndex - fistIndex + 1;
    }

    private int first(int[] nums, int target, int size) {
        int left = 0;
        int right = size - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left] == target ? left : -1;
    }

    private int last(int[] nums, int target, int size) {
        int left = 0;
        int right = size - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return nums[left] == target ? left : -1;
    }

}
