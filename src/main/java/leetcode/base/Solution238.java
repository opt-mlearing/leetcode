package leetcode.base;

/**
 * 238. 除自身以外数组的乘积
 * https://leetcode.cn/problems/product-of-array-except-self/
 */
public class Solution238 {

    // 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内.
    // 题目已经明确，无需担心.
    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int[] res = new int[size];
        // 前缀之积
        res[0] = 1;
        for (int i = 1; i < size; ++i) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int post = 1;
        for (int i = size - 1; i >= 0; --i) {
            res[i] *= post;
            post *= nums[i];
        }
        return res;
    }

}
