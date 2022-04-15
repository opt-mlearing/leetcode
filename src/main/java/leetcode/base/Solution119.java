package leetcode.base;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角II
 *
 * @link https://leetcode-cn.com/problems/pascals-triangle-ii/
 */
public class Solution119 {

    // 注意题目中已经明确rowIndex为非负
    // 先生成杨辉三角，再返回最后一行.
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < rowIndex + 1; ++i) {
            List<Integer> tmp = new ArrayList<Integer>();
            for (int j = 0; j <= i; ++j) {
                // 产生第一行时，一定不会进入到else分支.
                if (j == 0 || j == i) {
                    tmp.add(1);
                } else {
                    List<Integer> preRow = result.get(i - 1);
                    tmp.add(preRow.get(j - 1) + preRow.get(j));
                }
            }
            result.add(tmp);
        }
        return result.get(rowIndex);
    }

}
