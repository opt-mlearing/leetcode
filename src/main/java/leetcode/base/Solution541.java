package leetcode.base;

/**
 * 541. 反转字符串 II
 * https://leetcode-cn.com/problems/reverse-string-ii/
 */
public class Solution541 {

    public String reverseStr(String s, int k) {
        int len = s.length();
        char[] chars = s.toCharArray();
        int i = 0;
        for (i = 0; i < len; i += 2 * k) {
            // 1. 间隔2k，反转前k个, i+k
            // 2. 剩余小于2k大于k, i+k
            // 3. 剩余小于k, len
            reverse(chars, i, Math.min(len, i + k) - 1);
        }
        return new String(chars);
    }

    private void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            right--;
            left++;
        }
    }

}
