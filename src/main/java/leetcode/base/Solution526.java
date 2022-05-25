package leetcode.base;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 526. 优美的排列
 * https://leetcode.cn/problems/beautiful-arrangement/
 */
public class Solution526 {

    public int countArrangement(int n) {
        int size = (1 << n);
        int[] dp = new int[size];
        dp[0] = 1;
        for (int i = 1; i < size; ++i) {
            int num = Integer.bitCount(i);
            for (int j = 0; j < n; ++j) {
                // 先找到相同位置，再拆分开.
                if (((i & (1 << j)) != 0) && (num % (j + 1) == 0 || (j + 1) % num == 0)) {
                    dp[i] += dp[i ^ (1 << j)];
                }
            }
        }
        return dp[size - 1];
    }

    public int countArrangement_4(int n) {
        Integer[] memo = new Integer[1 << n + 1];
        return dfs_4(n, memo, n, 0);
    }

    private int dfs_4(int n, Integer[] memo, int pos, int state) {
        if (pos == 1) {
            return 1;
        }
        if (memo[state] != null) {
            return memo[state];
        }
        int count = 0;
        for (int i = 1; i <= n; ++i) {
            if (((state & (1 << i)) == 0) && (i % pos == 0 || pos % i == 0)) {
                count += dfs_4(n, memo, pos - 1, (state | (1 << i)));
            }
        }
        memo[state] = count;
        return count;
    }

    public int countArrangement_3(int n) {
        Map<String, Integer> memo = new HashMap<String, Integer>();
        boolean[] isVisit = new boolean[n + 1];
        return dfs_3(isVisit, n, n, memo);
    }

    private int dfs_3(boolean[] isVisit, int n, int index, Map<String, Integer> memo) {
        if (index == 1) {
            return 1;
        }
        String state = Arrays.toString(isVisit);
        if (memo.containsKey(state)) {
            return memo.get(state);
        }
        int count = 0;
        for (int i = 1; i <= n; ++i) {
            if (!isVisit[i] && (index % i == 0 || i % index == 0)) {
                isVisit[i] = true;
                count += dfs_3(isVisit, n, index - 1, memo);
                isVisit[i] = false;
            }
        }
        memo.put(state, count);
        return count;
    }

    private int res;

    public int countArrangement_2(int n) {
        res = 0;
        int state = 0;
        dfs_2(state, 1, n);
        return res;
    }

    private void dfs_2(int state, int index, int n) {
        if (index > n) {
            res++;
            return;
        }
        for (int i = 1; i <= n; ++i) {
            if (((state & (1 << i)) == 0) && (i % index == 0 || index % i == 0)) {
                dfs_2(state | (1 << i), index + 1, n);
            }
        }
    }

    public int countArrangement_1(int n) {
        boolean[] isVisit = new boolean[n + 1];
        res = 0;
        dfs_1(isVisit, 1, n);
        return res;
    }

    private void dfs_1(boolean[] isVisit, int index, int n) {
        if (index > n) {
            res++;
            return;
        }
        for (int i = 1; i <= n; ++i) {
            if (!isVisit[i] && ((i % index == 0) || (index % i == 0))) {
                isVisit[i] = true;
                dfs_1(isVisit, index + 1, n);
                isVisit[i] = false;
            }
        }
    }

}
