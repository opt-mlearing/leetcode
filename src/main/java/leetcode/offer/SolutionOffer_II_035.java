package leetcode.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 剑指 Offer II 035. 最小时间差
 * https://leetcode.cn/problems/569nqc/
 */
public class SolutionOffer_II_035 {

    public int findMinDifference(List<String> timePoints) {
        List<Integer> times = new ArrayList<Integer>();
        for (String timePoint : timePoints) {
            String[] time = timePoint.split(":");
            times.add(Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]));
        }
        Collections.sort(times, (time1, time2) -> time1 - time2);
        int size = times.size();
        int res = 24 * 60;
        for (int i = 1; i < size; ++i) {
            res = Math.min(res, times.get(i) - times.get(i - 1));
        }
        res = Math.min(res, times.get(0) + 24 * 60 - times.get(size - 1));
        return res;
    }

}
