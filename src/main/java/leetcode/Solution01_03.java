package leetcode;

/**
 * 面试题 01.03. URL化
 * https://leetcode-cn.com/problems/string-to-url-lcci/
 */
public class Solution01_03 {

    public String replaceSpaces(String S, int length) {
        char[] chars = S.toCharArray();
        int index = chars.length - 1;
        for (int i = length - 1; i >= 0; --i) {
            if (chars[i] == ' ') {
                chars[index--] = '0';
                chars[index--] = '2';
                chars[index--] = '%';
            } else {
                chars[index--] = chars[i];
            }
        }
        return new String(chars, index + 1, chars.length - index - 1);
    }

}
