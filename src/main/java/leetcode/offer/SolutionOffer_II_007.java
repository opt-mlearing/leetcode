package leetcode.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 剑指 Offer II 007. 数组中和为 0 的三个数
 * https://leetcode.cn/problems/1fGaJU/
 */
public class SolutionOffer_II_007 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int size = nums.length;
        for (int i = 0; i < size - 2; ++i) {
            // 这里一定要注意.
            if ((i > 0 && nums[i] == nums[i - 1]) || nums[i] > 0) {
                continue;
            }
            int first = i;
            int target = -nums[first];
            for (int j = first + 1; j < size - 1; ++j) {
                if (((j > first + 1) && (nums[j] == nums[j - 1]))) {
                    continue;
                }
                int second = j;
                int third = size - 1;
                while ((second < third) && nums[second] + nums[third] > target) {
                    third--;
                }
                if (second == third) {
                    continue;
                }
                if (nums[second] + nums[third] == target) {
                    res.add(Arrays.asList(nums[first], nums[second], nums[third]));
                }
            }
        }
        return res;
    }

}
