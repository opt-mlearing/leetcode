package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 合并区间
 * https://leetcode-cn.com/problems/merge-intervals/submissions/
 */
public class Solution56 {

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        // 先对区间左边界做升序排序
        Arrays.sort(intervals, (item1, item2) -> {
            return Integer.compare(item1[0], item2[0]);
        });
        List<int[]> mergeList = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; ++i) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            int lastIndex = mergeList.size() - 1;
            // merge集合为空 || 不重合的，直接添加
            if (mergeList.size() == 0 || mergeList.get(lastIndex)[1] < start) {
                mergeList.add(new int[]{start, end});
            } else {
                // 重合的，进行重组
                int[] pre = mergeList.get(lastIndex);
                mergeList.set(lastIndex, new int[]{pre[0], Math.max(pre[1], intervals[i][1])});
            }
        }
        return mergeList.toArray(new int[mergeList.size()][2]);
    }

}
