package leetcode.base;

import java.util.HashMap;
import java.util.Map;

/**
 * 464. 我能赢吗
 * https://leetcode.cn/problems/can-i-win/
 */
public class Solution464 {

    private Map<Integer, Boolean> meno;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0) {
            return true;
        }
        if ((maxChoosableInteger + 1) * maxChoosableInteger / 2 < desiredTotal) {
            return false;
        }
        meno = new HashMap<Integer, Boolean>();
        return dfs(0, maxChoosableInteger, desiredTotal);
    }

    private boolean dfs(int state, int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0) {
            return false;
        }
        if (meno.containsKey(state)) {
            return meno.get(state);
        }
        boolean isWin = false;
        for (int i = 1; i <= maxChoosableInteger; ++i) {
            if ((state & (1 << i)) == 0) {
                isWin = isWin || !dfs(state ^ (1 << i), maxChoosableInteger, desiredTotal - i);
            }
        }
        meno.put(state, isWin);
        return isWin;
    }

    public boolean canIWin_1(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0) {
            return true;
        }
        if ((maxChoosableInteger + 1) * maxChoosableInteger / 2 < desiredTotal) {
            return false;
        }
        meno = new HashMap<Integer, Boolean>();
        boolean[] isUsed = new boolean[maxChoosableInteger + 1];
        return dfs_1(maxChoosableInteger, desiredTotal, isUsed);
    }

    private boolean dfs_1(int maxChoosableInteger, int desiredTotal, boolean[] isUsed) {
        if (desiredTotal <= 0) {
            return false;
        }
        int state = help(isUsed);
        if (meno.containsKey(state)) {
            return meno.get(state);
        }
        boolean isWin = false;
        for (int i = 1; i <= maxChoosableInteger; ++i) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                isWin = isWin || !dfs_1(maxChoosableInteger, desiredTotal - i, isUsed);
                isUsed[i] = false;
            }
        }
        meno.put(state, isWin);
        return isWin;
    }

    // 获取状态.
    private int help(boolean[] isUsed) {
        int state = 0;
        for (int i = 0; i < isUsed.length; ++i) {
            if (isUsed[i]) {
                state |= (1 << i);
            }
        }
        return state;
    }

}
