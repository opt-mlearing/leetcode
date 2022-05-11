package leetcode.base;

/**
 * 1893. 检查是否区域内所有整数都被覆盖
 * https://leetcode.cn/problems/check-if-all-the-integers-in-a-range-are-covered/
 */
public class Solution1893 {

    // 提示:
    // 1 <= ranges.length <= 50
    // 1 <= starti <= endi <= 50
    // 1 <= left <= right <= 50
    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] diff = new int[52];
        for (int[] range : ranges) {
            diff[range[0]]++;
            diff[range[1] + 1]--;
        }
        int preSum = 0;
        for (int i = 1; i <= 50; ++i) {
            preSum += diff[i];
            if (i >= left && i <= right && preSum <= 0) {
                return false;
            }
        }
        return true;
    }

}
