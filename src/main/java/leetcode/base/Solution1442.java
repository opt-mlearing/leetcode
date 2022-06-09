package leetcode.base;

/**
 * 1442. 形成两个异或相等数组的三元组数目
 * https://leetcode.cn/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/
 */
public class Solution1442 {

    public int countTriplets_3(int[] arr) {
        int size = arr.length;
        int[] pre = new int[size + 1];
        for (int i = 0; i < size; ++i) {
            pre[i + 1] = pre[i] ^ arr[i];
        }
        int res = 0;
        for (int i = 0; i < size; ++i) {
            for (int j = i + 1; j < size; ++j) {
                for (int k = j; k < size; ++k) {
                    if (pre[i] == pre[k + 1]) {
                        res++;
                    }
                }
            }
        }
        return res;
    }

    public int countTriplets(int[] arr) {
        int size = arr.length;
        int[] pre = new int[size + 1];
        for (int i = 0; i < size; ++i) {
            pre[i + 1] = pre[i] ^ arr[i];
        }
        int res = 0;
        for (int i = 0; i < size; ++i) {
            for (int k = i + 1; k < size; ++k) {
                if (pre[i] == pre[k + 1]) {
                    res += k - i;
                }
            }
        }
        return res;
    }

}
