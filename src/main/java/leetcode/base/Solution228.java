package leetcode.base;

import java.util.ArrayList;
import java.util.List;

/**
 * 228. 汇总区间
 * https://leetcode-cn.com/problems/summary-ranges/
 */
public class Solution228 {

    public List<String> summaryRanges(int[] nums) {
        int left = 0;
        int right = 0;
        List<String> res = new ArrayList<String>();
        while (right < nums.length) {
            while (right + 1 < nums.length && nums[right] + 1 == nums[right + 1]) {
                right++;
            }
            if (left < right) {
                res.add(String.valueOf(nums[left]) + "->" + String.valueOf(nums[right]));
            } else if (left == right) {
                res.add(String.valueOf(nums[left]));
            }
            left = ++right;
        }
        return res;
    }

}
