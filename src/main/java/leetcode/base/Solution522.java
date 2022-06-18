package leetcode.base;

/**
 * 522. 最长特殊序列 II
 * https://leetcode.cn/problems/longest-uncommon-subsequence-ii/
 *
 * @author: caogl
 * @date: 2022/6/18, 22:53
 **/
public class Solution522 {

    public int findLUSlength(String[] strs) {
        int res = -1;
        int size = strs.length;
        for (int i = 0; i < size; ++i) {
            boolean flag = true;
            for (int j = 0; j < size; ++j) {
                if (i == j) {
                    continue;
                }
                if (isSubsequence(strs[j], strs[i])) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res = Math.max(res, strs[i].length());
            }
        }
        return res;
    }

    private boolean isSubsequence(String str, String sub) {
        int j = 0;
        for (int i = 0; i < str.length() && j < sub.length(); ++i) {
            if (str.charAt(i) == sub.charAt(j)) {
                j++;
            }
        }
        return j == sub.length();
    }

}
