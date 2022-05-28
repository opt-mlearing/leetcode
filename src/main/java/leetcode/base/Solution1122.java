package leetcode.base;

import java.util.Arrays;

/**
 * 1122. 数组的相对排序
 * https://leetcode.cn/problems/relative-sort-array/
 */
public class Solution1122 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length];
        Arrays.fill(res, Integer.MIN_VALUE);
        int[] count = new int[arr2.length];
        for (int i = 0; i < arr1.length; ++i) {
            boolean flag = true;
            for (int j = 0; j < arr2.length; ++j) {
                if (arr1[i] == arr2[j]) {
                    flag = false;
                    count[j]++;
                    break;
                }
            }
            if (flag) {
                res[i] = arr1[i];
            }
        }
        Arrays.sort(res);
        int index = 0;
        for (int i = 0; i < count.length; ++i) {
            while (count[i] != 0) {
                res[index++] = arr2[i];
                count[i]--;
            }
        }
        return res;
    }

}
