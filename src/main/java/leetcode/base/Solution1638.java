package leetcode.base;

/**
 * 1638. 统计只差一个字符的子串数目
 * https://leetcode.cn/problems/count-substrings-that-differ-by-one-character/
 *
 * @author: caogl
 * @date: 2022/6/15, 11:12
 **/
public class Solution1638 {

    public int countSubstrings(String s, String t) {
        int m = s.length();
        int n = t.length();
        int res = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int k = 0;
                int diff = 0;
                while (i + k < m && j + k < n && diff <= 1) {
                    if (s.charAt(i + k) != t.charAt(j + k)) {
                        diff++;
                    }
                    if (diff == 1) {
                        res++;
                    }
                    k++;
                }
            }
        }
        return res;
    }

}
