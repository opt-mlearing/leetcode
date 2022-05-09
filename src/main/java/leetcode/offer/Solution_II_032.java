package leetcode.offer;

/**
 * 剑指 Offer II 032. 有效的变位词
 * https://leetcode.cn/problems/dKk3P7/
 */
public class Solution_II_032 {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length() || s.equals(t)) {
            return false;
        }
        int[] tables = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            tables[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); ++i) {
            if (--tables[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

}
