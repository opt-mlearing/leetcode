package leetcode.typical;

/**
 * 面试题 01.09. 字符串轮转
 * https://leetcode-cn.com/problems/string-rotation-lcci/submissions/
 */
public class Solution01_09 {

    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        return (s2 + s2).contains(s1);
    }

}
