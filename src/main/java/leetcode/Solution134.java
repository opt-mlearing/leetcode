package leetcode;

/**
 * 加油站
 * https://leetcode-cn.com/problems/gas-station/
 */
public class Solution134 {

    // 看这个图的解法，不错，有点意思
    // https://leetcode-cn.com/problems/gas-station/solution/shi-yong-tu-de-si-xiang-fen-xi-gai-wen-ti-by-cyayc/
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int size = gas.length;
        // 最小剩余油量
        int minRest = Integer.MAX_VALUE;
        // 当前剩余油量
        int currRest = 0;
        // 最小油量对应的位置
        int index = 0;
        for (int i = 0; i < size; ++i) {
            currRest += gas[i] - cost[i];
            if (currRest < minRest) {
                minRest = currRest;
                index = i;
            }
        }
        // size+ 1 可能越界,需要进行取模处理.
        return currRest < 0 ? -1 : (index + 1) % size;
    }

}
