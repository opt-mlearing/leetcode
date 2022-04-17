package leetcode.base;

import java.util.HashSet;
import java.util.Set;

/**
 * 219. 存在重复元素 II
 * https://leetcode-cn.com/problems/contains-duplicate-ii/submissions/
 */
public class Solution219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; ++i) {
            // 当i大于k的时候，窗口需要左移
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            // 判断窗口最右边新元素是否可以成功添加HashSet
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

}
