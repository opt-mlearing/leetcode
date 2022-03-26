package leetcode;

/**
 * 面试题 01.06. 字符串压缩
 * https://leetcode-cn.com/problems/compress-string-lcci/submissions/
 */
public class Solution01_06 {

    public String compressString(String S) {
        if (S == null || S.length() == 0) {
            return S;
        }
        char[] chars = S.toCharArray();
        StringBuilder builder = new StringBuilder();
        int left = 0;
        builder.append(chars[0]);
        int i = 0;
        for (i = 1; i < chars.length; ++i) {
            if (chars[i] != chars[left]) {
                builder.append(i - left);
                left = i;
                builder.append(chars[i]);
            }
        }
        builder.append(i - left);
        return builder.length() >= S.length() ? S : builder.toString();
    }

}
