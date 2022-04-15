package leetcode.base;

/**
 * 验证回文串
 * https://leetcode-cn.com/problems/valid-palindrome/
 */
public class Solution125 {

    public boolean isPalindrome(String s) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < s.length(); ++i) {
            if (Character.isLetter(s.charAt(i))) {
                buffer.append(Character.toLowerCase(s.charAt(i)));
            } else if (Character.isDigit(s.charAt(i))) {
                buffer.append(s.charAt(i));
            } else {
                continue;
            }
        }
        int left = 0;
        int right = buffer.length() - 1;
        while (left <= right) {
            if (buffer.charAt(left) != buffer.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
