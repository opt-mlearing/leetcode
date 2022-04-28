package leetcode.base;

/**
 * 374. 猜数字大小
 * https://leetcode-cn.com/problems/guess-number-higher-or-lower/
 */
public class Solution374 {

    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        int res = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int relation = guess(mid);
            if (relation <= 0) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    /**
     * Forward declaration of guess API.
     *
     * @param num your guess
     * @return -1 if num is lower than the guess number
     * 1 if num is higher than the guess number
     * otherwise return 0
     * int guess(int num);
     */
    private int guess(int num) {
        return 0;
    }

}
