package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 删除并获得点数
 * https://leetcode-cn.com/problems/delete-and-earn/
 */
public class Solution740 {

    // 现将连续数字，变成相邻，然后套用打家劫舍的例子.
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        List<Integer> subList = new ArrayList<Integer>();
        subList.add(nums[0]);
        int res = 0;
        // 首先，确定nums是一个递增序列.
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i - 1] == nums[i]) {
                // 相等
                int last = subList.size() - 1;
                subList.set(last, subList.get(last) + nums[i]);
            } else if (nums[i - 1] + 1 == nums[i]) {
                // 相邻
                subList.add(nums[i]);
            } else {
                // 间隔开了
                res += doRob(subList);
                subList.clear();
                subList.add(nums[i]);
            }
        }
        // subList长度至少为1.
        res += doRob(subList);
        return res;
    }

    private int doRob(List<Integer> nums) {
        if (nums.size() == 1) {
            return nums.get(0);
        }
        int first = nums.get(0);
        int second = Math.max(nums.get(0), nums.get(1));
        for (int i = 2; i < nums.size(); ++i) {
            int tmp = second;
            second = Math.max(first + nums.get(i), second);
            first = tmp;
        }
        return second;
    }

}
