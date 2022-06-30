package leetcode.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 740. 删除并获得点数
 * https://leetcode.cn/problems/delete-and-earn/
 *
 * @author: caogl
 * @date: 2022/6/30, 22:02
 **/
public class Solution740 {

    // 1ms/ 40.8mb
    public int deleteAndEarn(int[] nums) {
        int maxVal = nums[0];
        int size = nums.length;
        for (int i = 1; i < size; ++i) {
            maxVal = Math.max(maxVal, nums[i]);
        }
        int[] arr = new int[maxVal + 1];
        for (int i = 0; i < size; ++i) {
            arr[nums[i]] += nums[i];
        }
        int first = arr[0];
        int second = Math.max(arr[0], arr[1]);
        for (int i = 2; i <= maxVal; ++i) {
            int tmp = second;
            first = Math.max(second, first + arr[i]);
            second = first;
            first = tmp;
        }
        return second;
    }

    // 2ms/ 41.2mb
    public int deleteAndEarn_2(int[] nums) {
        int maxVal = nums[0];
        int size = nums.length;
        for (int i = 1; i < size; ++i) {
            maxVal = Math.max(maxVal, nums[i]);
        }
        int[] arr = new int[maxVal + 1];
        for (int i = 0; i < size; ++i) {
            arr[nums[i]] += nums[i];
        }
        int[] dp = new int[maxVal + 1];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i <= maxVal; ++i) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i]);
        }
        return dp[maxVal];
    }

    // 8ms/ 41.5mb
    // 现将连续数字，变成相邻，然后套用打家劫舍的例子.
    public int deleteAndEarn_1(int[] nums) {
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
