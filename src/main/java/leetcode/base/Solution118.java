package leetcode.base;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 *
 * @link https://leetcode-cn.com/problems/pascals-triangle/
 */
public class Solution118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; ++i) {
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
        return result;
    }

}
