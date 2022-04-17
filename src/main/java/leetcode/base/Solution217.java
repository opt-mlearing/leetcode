package leetcode.base;

import java.util.HashSet;
import java.util.Set;

/**
 * 217. 存在重复元素
 * https://leetcode-cn.com/problems/contains-duplicate/
 */
public class Solution217 {

    // hashSet
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

}
