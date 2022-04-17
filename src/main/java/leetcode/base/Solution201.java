package leetcode.base;

/**
 * 201. 数字范围按位与
 * https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/
 */
public class Solution201 {

    // 寻找left、right二进制串的公共前缀
    public int rangeBitwiseAnd(int left, int right) {
        assert left <= right;
        int count = 0;
        while (left < right) {
            left = left >> 1;
            right = right >> 1;
            count++;
        }
        return left << count;
    }

}
