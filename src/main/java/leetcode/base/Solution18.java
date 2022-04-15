package leetcode.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和
 * https://leetcode-cn.com/problems/4sum/
 */
public class Solution18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null && nums.length < 4) {
            return list;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; ++i) {
            // 一个循环中，一个位置上，避免相同的元素.
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 跳过极端case.
            if (((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3]) > target) {
                break;
            }
            // 跳过极端case.
            if (((long) nums[i] + nums[length - 1] + nums[length - 2] + nums[length - 3]) < target) {
                continue;
            }
            for (int j = i + 1; j < length - 2; ++j) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if (((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2]) > target) {
                    break;
                }
                if (((long) nums[i] + nums[j] + nums[length - 1] + nums[length - 2]) < target) {
                    continue;
                }
                int left = j + 1;
                int right = length - 1;
                while (left < right) {
                    int tmp = nums[i] + nums[j] + nums[left] + nums[right];
                    if (tmp == target) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        // 继续搜索其他组合，且需要避免相同位置获取相同元素.
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        // 继续搜索其他组合，且需要避免相同位置获取相同元素.
                        // 其实第四个元素可以不进行重复判断的，前三个元素不重复，最后一个肯定不重复了，这里处理可以加快效率.
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if (tmp < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return list;
    }

}
