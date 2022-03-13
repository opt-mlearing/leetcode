package leetcode;

import java.util.Arrays;

/**
 * 实现 strStr()
 * https://leetcode-cn.com/problems/implement-strstr/
 */
public class Solution28 {

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int[] fail = new int[needle.length()];
        Arrays.fill(fail, -1);
        for (int i = 1, j = -1; i < needle.length(); ++i) {
            while (j != -1 && (needle.charAt(i) != (needle.charAt(j + 1)))) {
                j = fail[j];
            }
            if (needle.charAt(i) == (needle.charAt(j + 1))) {
                j++;
            }
            fail[i] = j;
        }

        for (int i = 0, j = -1; i < haystack.length(); ++i) {
            while (j != -1 && (haystack.charAt(i) != (needle.charAt(j + 1)))) {
                j = fail[j];
            }
            if (haystack.charAt(i) == (needle.charAt(j + 1))) {
                j++;
            }
            if (j == needle.length() - 1) {
                return i - j;
            }
        }
        return -1;
    }

}
