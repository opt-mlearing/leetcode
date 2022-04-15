package leetcode.base;

/**
 * 168. Excel表列名称
 * https://leetcode-cn.com/problems/excel-sheet-column-title/
 */
public class Solution168 {

    public String convertToTitle(int columnNumber) {
        StringBuilder builder = new StringBuilder();
        while (columnNumber != 0) {
            // 一定要先减一个1， 因为无论十进制还是二进制，都是从0 开始的.
            columnNumber--;
            builder.append((char) (columnNumber % 26 + 'A'));
            columnNumber = (columnNumber) / 26;
        }
        return builder.reverse().toString();
    }

}
