package leetcode;

/**
 * 最长公共前缀
 * https://leetcode-cn.com/problems/longest-common-prefix/
 */
public class Solution14 {

    // 纵向对比.
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); ++i) {
            char tmp = strs[0].charAt(i);
            for (int j = 1; j < strs.length; ++j) {
                if (i == strs[j].length() || tmp != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

}
