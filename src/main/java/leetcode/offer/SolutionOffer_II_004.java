package leetcode.offer;

/**
 * 剑指 Offer II 004. 只出现一次的数字
 * https://leetcode.cn/problems/WGki4K/
 */
public class SolutionOffer_II_004 {

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; ++i) {
            int total = 0;
            for (int num : nums) {
                total += ((num >> i) & 1);
            }
            if (total % 3 == 1) {
                res |= (1 << i);
            }
        }
        return res;
    }

}
