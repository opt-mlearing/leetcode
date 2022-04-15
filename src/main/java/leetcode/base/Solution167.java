package leetcode.base;

/**
 * 两数之和 II - 输入有序数组
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class Solution167 {

    // 二分法. 需要先固定一个数，然后寻找下一个数.
    public int[] twoSum_binary_search(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; ++i) {
            int left = i + 1;
            int right = numbers.length - 1;
            int tmp = target - numbers[i];
            while (left <= right) {
                int mid = (left + right) >> 1;
                if (numbers[mid] < tmp) {
                    left = mid + 1;
                } else if (numbers[mid] == tmp) {
                    return new int[]{i + 1, mid + 1};
                } else {
                    right = mid - 1;
                }
            }
        }
        return new int[]{-1, -1};
    }

    // 双指针.
    public int[] twoSum_two_point(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int tmp = numbers[left] + numbers[right];
            if (tmp < target) {
                left++;
            } else if (tmp == target) {
                return new int[]{left + 1, right + 1};
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }

    // 暴力贪婪.
    public int[] twoSum_greed(int[] numbers, int target) {
        if (numbers.length < 2) {
            return new int[0];
        }
        int left = 0;
        while (left < numbers.length - 1) {
            for (int right = left + 1; right < numbers.length; ++right) {
                int tmp = numbers[left] + numbers[right];
                if (tmp > target) {
                    break;
                } else if (tmp == target) {
                    return new int[]{left + 1, right + 1};
                }
            }
            left++;
        }
        return new int[]{-1, -1};
    }

}
