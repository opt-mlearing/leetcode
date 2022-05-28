package leetcode.offer;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer II 016. 不含重复字符的最长子字符串
 * https://leetcode.cn/problems/wtcaE1/submissions/
 */
public class SolutionOffer_II_016 {

    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int res = 0;
        Set<Character> set = new HashSet<Character>();
        while (right < s.length()) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left++));
            }
            set.add(s.charAt(right++));
            res = Math.max(res, set.size());
        }
        return res;
    }

}
