package leetcode.base;

import java.util.ArrayList;
import java.util.List;

/**
 * 448. 找到所有数组中消失的数字
 * https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array/
 *
 * @author: caogl
 * @date: 2022/7/13, 23:52
 **/
public class Solution448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int size = nums.length;
        for (int num : nums) {
            int x = (num - 1) % size;
            // 原地修改，把符合存在的数字变成大于size数值.
            nums[x] += size;
        }
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < size; i++) {
            if (nums[i] <= size) {
                ret.add(i + 1);
            }
        }
        return ret;
    }

}
