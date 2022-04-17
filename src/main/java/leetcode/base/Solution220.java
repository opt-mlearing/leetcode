package leetcode.base;

import java.util.HashMap;
import java.util.Map;

/**
 * 220. 存在重复元素 III
 * https://leetcode-cn.com/problems/contains-duplicate-iii/
 */
public class Solution220 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k == 0 || t < 0 || nums.length == 0) {
            return false;
        }
        Map<Long, Long> map = new HashMap<Long, Long>();
        // 一定要转换成 long，若否部分case将失败.
        long w = (long) t + 1;
        for (int i = 0; i < nums.length; ++i) {
            long key = bucketId(nums[i], w);
            // 是否存在相同的桶中.
            if (map.containsKey(key)) {
                return true;
            }
            // 搜索相邻的桶.
            if (map.containsKey(key - 1) && Math.abs(map.get(key - 1) - nums[i]) <= t) {
                return true;
            }
            if (map.containsKey(key + 1) && Math.abs(map.get(key + 1) - nums[i]) <= t) {
                return true;
            }
            if (i >= k) {
                map.remove(bucketId(nums[i - k], w));
            }
            // 若存在相同key且窗口小于k的时候，最新的数值将替代旧的数值.
            map.put(key, (long) nums[i]);
        }
        return false;
    }

    // 获取桶编号.
    private long bucketId(long num, long w) {
        if (num >= 0) {
            return num / w;
        } else {
            return (num + 1) / w - 1;
        }
    }

}
