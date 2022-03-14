package leetcode;

import java.util.Arrays;

/**
 * 最接近的三数之和
 * https://leetcode-cn.com/problems/3sum-closest/
 */
public class Solution16 {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = 1000000000;
        for (int i = 0; i < nums.length - 2; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int first = i;
            int second = first + 1;
            int third = nums.length - 1;
            while (second < third) {
                int tmp = nums[first] + nums[second] + nums[third];
                if (Math.abs(tmp - target) < Math.abs(result - target)) {
                    result = tmp;
                }
                if (tmp == target) {
                    return tmp;
                } else if (tmp > target) {
                    third--;
                    // 注意移动的时候再判断
                    while (third < nums.length - 1 && nums[third] == nums[third + 1] && third > 1) {
                        third--;
                    }
                } else {
                    second++;
                    // 注意移动的时候再判断
                    while (second > first + 1 && nums[second] == nums[second - 1] && second < nums.length - 1) {
                        second++;
                    }
                }
            }
        }
        return result;
    }

}
