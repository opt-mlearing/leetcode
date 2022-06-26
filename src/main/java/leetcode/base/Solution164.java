package leetcode.base;

/**
 * 164. 最大间距
 * https://leetcode.cn/problems/maximum-gap/submissions/
 *
 * @author: caogl
 * @date: 2022/6/26, 23:37
 **/
public class Solution164 {

    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int size = nums.length;
        int max = maxNum(nums);
        int exp = 1;
        int[] tmp = new int[size];
        while (max / exp > 0) {
            int[] count = new int[10];
            for (int i = 0; i < size; ++i) {
                count[(nums[i] / exp) % 10]++;
            }
            for (int i = 1; i < 10; ++i) {
                count[i] += count[i - 1];
            }
            // 注意一定从大到小的顺序.
            for (int i = size - 1; i >= 0; --i) {
                tmp[count[(nums[i] / exp) % 10] - 1] = nums[i];
                count[(nums[i] / exp) % 10]--;
            }
            for (int i = 0; i < size; ++i) {
                nums[i] = tmp[i];
            }
            exp *= 10;
        }
        int res = 0;
        for (int i = 1; i < size; ++i) {
            res = Math.max(res, nums[i] - nums[i - 1]);
        }
        return res;
    }

    private int maxNum(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

}
