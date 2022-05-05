package leetcode.offer;

/**
 * 剑指 Offer II 018. 有效的回文
 * https://leetcode-cn.com/problems/XltzEq/
 */
public class SolutionOffer_II_018 {

    public boolean isPalindrome(String s) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < s.length(); ++i) {
            if (Character.isLetter(s.charAt(i))) {
                // 统一小写字母.
                buffer.append(Character.toLowerCase(s.charAt(i)));
            } else if (Character.isDigit(s.charAt(i))) {
                // 数字.
                buffer.append(s.charAt(i));
            } else {
                // 其他跳过.
                continue;
            }
        }
        int left = 0;
        int right = buffer.length() - 1;
        // 不需要left<= right.
        while (left < right) {
            if (buffer.charAt(left) != buffer.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
