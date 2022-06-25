package leetcode.base;

/**
 * 2029. 石子游戏 IX
 * https://leetcode.cn/problems/stone-game-ix/
 *
 * @author: caogl
 * @date: 2022/6/25, 22:49
 **/
public class Solution2029 {

    public boolean stoneGameIX(int[] stones) {
        int size = stones.length;
        int[] counts = new int[3];
        for (int i = 0; i < size; ++i) {
            counts[stones[i] % 3]++;
        }
        return dfs(counts, true, 0);
    }

    // @param: person --> {true: Alice取石子, false: Bob取石子}.
    // @return: Alice是否获胜.
    private boolean dfs(int[] counts, boolean person, int total) {
        if (person && total != 0 && total % 3 == 0) {
            // Alice胜出.
            return true;
        }
        if (sum(counts) == 0) {
            // Bob胜出.
            return false;
        }
        boolean flag = false;
        for (int i = 0; i < counts.length; ++i) {
            // 不会明显给对手送分.
            if ((total + i) % 3 == 0) {
                continue;
            }
            // 当前余数对应的词为0，没必要继续循环下去.
            if (counts[i] == 0) {
                continue;
            }
            // 存在余数为0的情况.
            if (total % 3 != 0 && counts[0] > 0 && i != 0) {
                continue;
            }
            // 可以顺利进入下个阶段的回溯.
            flag = true;
            counts[i]--;
            if (dfs(counts, !person, total + i)) {
                return true;
            }
            counts[i]++;
        }
        if (person) {
            // Bob胜出.
            return false;
        } else if (!flag) {
            // Alice胜出.
            return true;
        } else {
            // Bob胜出.
            return false;
        }
    }

    private int sum(int[] nums) {
        int value = 0;
        for (int i = 0; i < nums.length; ++i) {
            value += nums[i];
        }
        return value;
    }

}
