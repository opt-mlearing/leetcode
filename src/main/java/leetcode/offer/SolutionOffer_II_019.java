package leetcode.offer;

/**
 * 剑指 Offer II 019. 最多删除一个字符得到回文
 * https://leetcode.cn/problems/RQku0D/
 */
public class SolutionOffer_II_019 {

    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return doValid(s, left + 1, right) || doValid(s, left, right - 1);
            }
        }
        return true;
    }

    private boolean doValid(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
