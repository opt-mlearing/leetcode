package leetcode.base;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * https://leetcode.cn/problems/two-sum/
 *
 * @author: caogl
 * @date: 2022/7/19, 23:56
 **/
public class Solution1 {

    // 2ms/ 41.4.mb
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int size = nums.length;
        for (int i = 0; i < size; ++i) {
            int j = map.getOrDefault(target - nums[i], -1);
            if (j != -1) {
                return new int[]{i, j};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};
    }

    // 59ms/41.3mb
    public int[] twoSum_1(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        for (int i = 0; i < nums.length - 1; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

}
