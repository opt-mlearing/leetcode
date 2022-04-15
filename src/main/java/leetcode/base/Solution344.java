package leetcode.base;

/**
 * 反转字符串.
 * https://leetcode-cn.com/problems/reverse-string/submissions/
 */
public class Solution344 {

    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left <= right) {
            char tmp = s[left];
            s[left++] = s[right];
            s[right--] = tmp;
        }
    }

}
