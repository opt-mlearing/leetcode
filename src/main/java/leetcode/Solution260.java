package leetcode;

/**
 * 只出现一次的数字 III
 * https://leetcode-cn.com/problems/single-number-iii/
 */
public class Solution260 {

    public int[] singleNumber(int[] nums) {
        int tmp = 0;
        // 假设只出现一次的数为 x1和x2，tmp 表示x1和x2的异或和.
        for (int num : nums) {
            tmp ^= num;
        }
        // lbs 表示 x1和 x2 异或之后，二进制表示中最低位那个 1.
        int lbs = (tmp == Integer.MAX_VALUE ? tmp : tmp & -tmp);
        int num1 = 0;
        int num2 = 0;
        for (int num : nums) {
            if ((num & lbs) == 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }
        return new int[]{num1, num2};
    }

}
