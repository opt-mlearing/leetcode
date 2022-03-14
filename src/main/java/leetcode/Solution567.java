package leetcode;

import java.util.Arrays;

/**
 * 字符串的排列
 * https://leetcode-cn.com/problems/permutation-in-string/
 */
class Solution567 {

    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 > len2) {
            return false;
        }
        int[] letter1 = new int[26];
        int[] letter2 = new int[26];
        for (int i = 0; i < len1; ++i) {
            ++letter1[s1.charAt(i) - 'a'];
            ++letter2[s2.charAt(i) - 'a'];
        }
        if (Arrays.equals(letter1, letter2)) {
            return true;
        }
        for (int j = len1; j < len2; ++j) {
            ++letter2[s2.charAt(j) - 'a'];
            --letter2[s2.charAt(j - len1) - 'a'];
            if (Arrays.equals(letter1, letter2)) {
                return true;
            }
        }
        return false;
    }

}