package leetcode.offer;

/**
 * 剑指 Offer II 006. 排序数组中两个数字之和
 * https://leetcode.cn/problems/kLl5u1/
 */
public class SolutionOffer_II_006 {

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int tmp = numbers[left] + numbers[right];
            if (tmp < target) {
                left++;
            } else if (tmp > target) {
                right--;
            } else {
                return new int[]{left, right};
            }
        }
        return new int[]{-1, -1};
    }

}
