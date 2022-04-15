package leetcode.base;

import java.util.ArrayList;
import java.util.List;

/**
 * 插入区间
 * https://leetcode-cn.com/problems/insert-interval/
 */
public class Solution57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        // 异常判断.
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
            return new int[][]{{newInterval[0], newInterval[1]}};
        }
        List<int[]> res = new ArrayList<int[]>();
        int left = newInterval[0];
        int right = newInterval[1];
        boolean noInsert = true;
        for (int i = 0; i < intervals.length; ++i) {
            if (intervals[i][0] > right) {
                // newInterval 在最右边
                if (noInsert) {
                    // 1）这里是一个newInterval 的插入时机
                    res.add(new int[]{left, right});
                    noInsert = false;
                }
                res.add(intervals[i]);
            } else if (intervals[i][1] < left) {
                // newInterval 与intervals[i] 不相交，但不保证不与与intervals[k], k> i 不相交.
                res.add(intervals[i]);
            } else {
                // 存在相交，这里不着急存入res 结果，因为当前左右边界与下一个intervals[i+ 1] 可能还存在相互交集.
                left = Math.min(intervals[i][0], left);
                right = Math.max(intervals[i][1], right);
            }
        }
        // 2）这里是 newInterval的第二个插入世时机.
        if (noInsert) {
            res.add(new int[]{left, right});
        }
        return res.toArray(new int[res.size()][2]);
    }

}
