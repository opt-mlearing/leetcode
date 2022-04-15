package leetcode.base;

import java.util.Arrays;

/**
 * 重复的子字符串
 * https://leetcode-cn.com/problems/repeated-substring-pattern/
 */
public class Solution459 {

    // 通过kmp查找子串.
    public boolean repeatedSubstringPattern(String s) {
        return kmp((s + s).substring(1, 2 * s.length() - 1), s);
    }

    private boolean kmp(String txt, String pat) {
        int[] ifFail = new int[pat.length()];
        Arrays.fill(ifFail, -1);
        for (int i = 1, j = -1; i < pat.length(); ++i) {
            while (j != -1 && pat.charAt(i) != pat.charAt(j + 1)) {
                j = ifFail[j];
            }
            if (pat.charAt(i) == pat.charAt(j + 1)) {
                ++j;
            }
            ifFail[i] = j;
        }
        for (int i = 0, j = -1; i < txt.length(); ++i) {
            while (j != -1 && txt.charAt(i) != pat.charAt(j + 1)) {
                j = ifFail[j];
            }
            if (txt.charAt(i) == pat.charAt(j + 1)) {
                ++j;
            }
            if (j == pat.length() - 1) {
                return true;
            }
        }
        return false;
    }

    public boolean repeatedSubstringPattern_by_mathematics(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }

}
