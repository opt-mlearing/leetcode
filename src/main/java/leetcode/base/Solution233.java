package leetcode.base;

/**
 * 233. 数字 1 的个数
 * https://leetcode.cn/problems/number-of-digit-one/submissions/
 */
public class Solution233 {

    public int countDigitOne(int n) {
        if (n <= 0) {
            return 0;
        }
        char[] chars = new StringBuffer(String.valueOf(n)).reverse().toString().toCharArray();
        int size = chars.length;
        int res = 0;
        for (int i = 0; i < size; ++i) {
            int pre = n / (int) Math.pow(10, i + 1);
            res += pre * (int) Math.pow(10, i);
            int digit = chars[i] - '0';
            if (digit > 1) {
                res += (int) Math.pow(10, i);
            } else if (digit == 1) {
                res += n % (int) Math.pow(10, i) + 1;
            }
        }
        return res;
    }

}
