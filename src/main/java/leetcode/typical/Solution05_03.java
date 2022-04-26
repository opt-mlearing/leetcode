package leetcode.typical;

/**
 * 面试题 05.03. 翻转数位
 * https://leetcode-cn.com/problems/reverse-bits-lcci/
 */
public class Solution05_03 {

    public int reverseBits(int num) {
        int curr = 0;
        int insert = 0;
        int res = 0;
        // 一共就32位
        for (int i = 0; i < 32; ++i) {
            if ((num & (1 << i)) != 0) {
                curr++;
                insert++;
            } else {
                // 注意，这里是curr+ 1，表示之前连续1的最大长度.
                insert = curr + 1;
                curr = 0;
            }
            res = Math.max(res, insert);
        }
        return res;
    }

}
