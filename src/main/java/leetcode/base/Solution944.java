package leetcode.base;

/**
 * 944. 删列造序
 * https://leetcode.cn/problems/delete-columns-to-make-sorted/
 */
public class Solution944 {

    // 有啥好办法?
    public int minDeletionSize(String[] strs) {
        int m = strs.length;
        int n = strs[0].length();
        int res = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 1; j < m; ++j) {
                if (strs[j - 1].charAt(i) > strs[j].charAt(i)) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }

}
