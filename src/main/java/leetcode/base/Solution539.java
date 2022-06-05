package leetcode.base;

import java.util.ArrayList;
import java.util.List;

/**
 * 539. 最小时间差
 * https://leetcode.cn/problems/minimum-time-difference/
 */
public class Solution539 {

    public int findMinDifference(List<String> timePoints) {
        List<Integer> timeList = new ArrayList<Integer>();
        for (String time : timePoints) {
            String[] times = time.split(":");
            timeList.add(Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]));
        }
        timeList.sort((time1, time2) -> Integer.compare(time1, time2));
        int res = 24 * 60;
        int size = timeList.size();
        for (int i = 1; i < size; ++i) {
            res = Math.min(res, timeList.get(i) - timeList.get(i - 1));
        }
        // 最大的一个跨天和最小的一个比较.
        res = Math.min(res, timeList.get(0) + 24 * 60 - timeList.get(size - 1));
        return res;
    }

}
