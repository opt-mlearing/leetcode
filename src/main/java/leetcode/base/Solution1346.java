package leetcode.base;

import java.util.Arrays;

/**
 * 1346. 检查整数及其两倍数是否存在
 * https://leetcode.cn/problems/check-if-n-and-its-double-exist/
 */
public class Solution1346 {

    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        int size = arr.length;
        int j = 0;
        // 此时, 认为arr[j]> 0.
        for (int i = 0; i < size; ++i) {
            while (j < size && arr[i] * 2 > arr[j]) {
                ++j;
            }
            if (j < size && i != j && arr[i] * 2 == arr[j]) {
                return true;
            }
        }
        // 此时，认为arr[j]< 0
        j = size - 1;
        for (int i = 0; i < size; ++i) {
            while (j >= 0 && arr[i] * 2 > arr[j]) {
                --j;
            }
            if (j >= 0 && i != j && arr[i] * 2 == arr[j]) {
                return true;
            }
        }
        return false;
    }

}
