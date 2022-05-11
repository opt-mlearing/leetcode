package leetcode.base;

import java.util.HashMap;
import java.util.Map;

/**
 * 525. 连续数组
 * https://leetcode.cn/problems/contiguous-array/
 */
public class Solution525 {

    public int findMaxLength(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        // 不错过第一个element.
        map.put(0, -1);
        int preSum = 0;
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            preSum += nums[i];
            // 两个prefix sum ==0，那么中间夹的部分一定和为0.
            if (map.containsKey(preSum)) {
                int len = i - map.get(preSum);
                res = Math.max(res, len);
            } else {
                map.put(preSum, i);
            }
        }
        return res;
    }

}
