package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 区间列表的交集
 * https://leetcode-cn.com/problems/interval-list-intersections/
 */
public class Solution986 {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0;
        int j = 0;
        List<int[]> res = new ArrayList<int[]>();
        while (i < firstList.length && j < secondList.length) {
            int left = Math.max(firstList[i][0], secondList[j][0]);
            int right = Math.min(firstList[i][1], secondList[j][1]);
            if (left <= right) {
                res.add(new int[]{left, right});
            }
            if (firstList[i][1] < secondList[j][1]) {
                ++i;
            } else {
                ++j;
            }
        }
        return res.toArray(new int[res.size()][2]);
    }

}
