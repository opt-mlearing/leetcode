package leetcode.base;

/**
 * 409. 最长回文串
 * https://leetcode.cn/problems/longest-palindrome/
 *
 * @author: caogl
 * @date: 2022/6/18, 17:05
 **/
public class Solution409 {

    public int longestPalindrome(String s) {
        int[] count = new int[58];
        for (int i = 0; i < s.length(); ++i) {
            int index = s.charAt(i) - 'A';
            count[index]++;
        }
        int res = 0;
        for (int i = 0; i < 58; ++i) {
            res += count[i] / 2 * 2;
            if (res % 2 == 0 && count[i] % 2 == 1) {
                res++;
            }
        }
        return res;
    }

}
