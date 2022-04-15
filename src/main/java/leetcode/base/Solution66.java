package leetcode.base;

/**
 * 加一
 * https://leetcode-cn.com/problems/plus-one/
 */
public class Solution66 {

    // 关注digits的末尾出现了多少个9即可。我们可以考虑如下的三种情况:
    // 1)如果digits的末尾没有9,直接将末尾的数加一.
    // 2)如果digits的末尾有若干9,那么我们只需要找出从末尾开始的第一个不为9的元素，然后将该元素加一.
    // 3)如果digits的所有元素都是9,只需要构造一个长度比digits多1位的新数组，其余元素置为0即可.
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; --i) {
            if (digits[i] != 9) {
                ++digits[i];
                for (int j = i + 1; j < digits.length; ++j) {
                    digits[j] = 0;
                }
                return digits;
            }
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }

}
