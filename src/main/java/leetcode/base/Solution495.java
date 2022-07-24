package leetcode.base;

/**
 * 495. 提莫攻击
 * https://leetcode.cn/problems/teemo-attacking/
 *
 * @author: caogl
 * @date: 2022/7/24, 15:51
 **/
public class Solution495 {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int size = timeSeries.length;
        if (size == 0) {
            return 0;
        }
        int preEnd = timeSeries[0];
        int remain = 0;
        for (int i = 1; i < size; ++i) {
            int tmp = timeSeries[i] - preEnd - duration;
            if (tmp > 0) {
                remain += tmp;
            }
            preEnd = timeSeries[i];
        }
        return timeSeries[size - 1] - timeSeries[0] - remain + duration;
    }

}
