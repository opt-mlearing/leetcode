package leetcode.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 剑指 Offer II 074. 合并区间
 * https://leetcode.cn/problems/SsGoHC/
 */
public class SolutionOffer_II_074 {

    public int[][] merge(int[][] intervals) {
        int size = intervals.length;
        Arrays.sort(intervals, (item1, item2) -> {
            if (item1[0] != item2[0]) {
                return item1[0] - item2[0];
            } else {
                return item1[1] - item2[1];
            }
        });
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < size; ++i) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            int len = list.size();
            if (len == 0 || list.get(len - 1)[1] < left) {
                list.add(new int[]{left, right});
            } else {
                // merge operation.
                int[] pre = list.get(len - 1);
                list.set(len - 1, new int[]{Math.min(pre[0], left), Math.max(pre[1], right)});
            }
        }
        return list.toArray(new int[list.size()][2]);
    }

}
