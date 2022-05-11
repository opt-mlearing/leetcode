package leetcode.base;

/**
 *
 * https://leetcode.cn/problems/car-pooling/
 */
public class Solution1094 {

    // 提示:
    //1 <= trips.length <= 1000
    // trips[i].length == 3
    // 1 <= numPassengersi <= 100
    // 0 <= fromi < toi <= 1000
    // 1 <= capacity <= 105
    public boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1001];
        for (int[] trip : trips) {
            diff[trip[1]] -= trip[0];
            diff[trip[2]] += trip[0];
        }
        int sum = capacity;
        for (int i = 0; i < 1001; ++i) {
            sum += diff[i];
            if (sum < 0) {
                return false;
            }
        }
        return true;
    }

}
