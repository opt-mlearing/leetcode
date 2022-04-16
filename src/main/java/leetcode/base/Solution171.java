package leetcode.base;

/**
 * 171. Excel 表列序号
 * https://leetcode-cn.com/problems/excel-sheet-column-number/
 */
public class Solution171 {

    public int titleToNumber(String columnTitle) {
        if (columnTitle == null || columnTitle.length() == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < columnTitle.length(); ++i) {
            res = res * 26 + (columnTitle.charAt(i) - 'A' + 1);
        }
        return res;
    }

}
