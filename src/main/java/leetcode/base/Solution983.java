package leetcode.base;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 983. 最低票价
 * https://leetcode-cn.com/problems/minimum-cost-for-tickets/
 */
public class Solution983 {

    public int mincostTickets(int[] days, int[] costs) {
        Set<Integer> daySet = new HashSet<Integer>();
        for (int day : days) {
            daySet.add(day);
        }
        Arrays.sort(days);
        int maxDay = days[days.length - 1];
        int[] dp = new int[maxDay + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= maxDay; ++i) {
            if (daySet.contains(i)) {
                dp[i] = Math.min(dp[i], dp[i - 1] + costs[0]);
                // 注意，这里7天和30天，数组溢出并不代表不能用.
                dp[i] = Math.min(dp[i], dp[i >= 7 ? i - 7 : 0] + costs[1]);
                dp[i] = Math.min(dp[i], dp[i >= 30 ? i - 30 : 0] + costs[2]);
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[maxDay];
    }

}
