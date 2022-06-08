package leetcode.base;

/**
 * 2108. 找出数组中的第一个回文字符串
 * https://leetcode.cn/problems/find-first-palindromic-string-in-the-array/
 */
public class Solution2108 {

    public String firstPalindrome(String[] words) {
        for (String word : words) {
            if (isPalindrome(word)) {
                return word;
            }
        }
        return "";
    }

    private boolean isPalindrome(String word) {
        int left = 0;
        int right = word.length() - 1;
        while (left < right) {
            if (word.charAt(left) == word.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

}
