package leetcode;

/**
 * 面试题 01.01. 判定字符是否唯一
 * https://leetcode-cn.com/problems/is-unique-lcci/
 */
public class Solution01_01 {

    public boolean isUnique(String astr) {
        int[] nums = new int[26];
        char[] tmp = astr.toCharArray();
        for (char ele : tmp) {
            int index = ele - 'a';
            if (nums[index] != 0) {
                return false;
            } else {
                nums[index] += 1;
            }
        }
        return true;
    }

}
