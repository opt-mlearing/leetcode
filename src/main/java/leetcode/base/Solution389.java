package leetcode.base;

/**
 * 389. 找不同
 * https://leetcode.cn/problems/find-the-difference/
 *
 * @author: caogl
 * @date: 2022/6/24, 1:55
 **/
public class Solution389 {

    public char findTheDifference(String s, String t) {
        int[] nums = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            int index = s.charAt(i) - 'a';
            nums[index]++;
        }
        for (int i = 0; i < t.length(); ++i) {
            int index = t.charAt(i) - 'a';
            nums[index]--;
            if (nums[index] < 0) {
                return t.charAt(i);
            }
        }
        return ' ';
    }

}
