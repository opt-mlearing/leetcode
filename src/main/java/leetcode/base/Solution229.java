package leetcode.base;

import java.util.ArrayList;
import java.util.List;

/**
 * 229. 求众数 II
 * https://leetcode-cn.com/problems/majority-element-ii/
 */
public class Solution229 {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int num1 = 0;
        int num2 = 0;
        int count1 = 0;
        int count2 = 0;
        // 先找到两个众数
        for (int i = 0; i < nums.length; ++i) {
            if (count1 > 0 && nums[i] == num1) {
                count1++;
            } else if (count2 > 0 && nums[i] == num2) {
                count2++;
            } else if (count1 == 0) {
                num1 = nums[i];
                count1++;
            } else if (count2 == 0) {
                num2 = nums[i];
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        int repeatCount1 = 0;
        int repeatCount2 = 0;
        // 若存在两个众数，则统计实际出现频次
        for (int i = 0; i < nums.length; ++i) {
            if (count1 > 0 && nums[i] == num1) {
                repeatCount1++;
            }
            if (count2 > 0 && nums[i] == num2) {
                repeatCount2++;
            }
        }
        if (repeatCount1 > nums.length / 3) {
            res.add(num1);
        }
        if (repeatCount2 > nums.length / 3) {
            res.add(num2);
        }
        return res;
    }

}
