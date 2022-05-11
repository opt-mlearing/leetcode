package leetcode.base;

/**
 * 1732. 找到最高海拔
 * https://leetcode.cn/problems/find-the-highest-altitude/
 */
public class Solution1732 {

    public int largestAltitude(int[] gain) {
        int sum = 0;
        // 题目中已经明确 --> 自行车手从海拔为 0 的点 0 开始骑行
        int res = 0;
        for (int i = 0; i < gain.length; ++i) {
            sum += gain[i];
            res = Math.max(res, sum);
        }
        return res;
    }

}
