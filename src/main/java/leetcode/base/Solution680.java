package leetcode.base;

/**
 * 680. 验证回文字符串 Ⅱ
 * https://leetcode.cn/problems/valid-palindrome-ii/
 */
public class Solution680 {

    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return isValid(s, left + 1, right) || isValid(s, left, right - 1);
            }
        }
        return true;
    }

    private boolean isValid(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

}
