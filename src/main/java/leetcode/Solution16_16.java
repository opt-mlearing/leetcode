package leetcode;

import java.util.Arrays;

/**
 * 面试题 16.16. 部分排序
 * https://leetcode-cn.com/problems/sub-sort-lcci/
 */
public class Solution16_16 {

    public int[] subSort(int[] array) {
        int size = array.length;
        int left = -1;
        int right = -1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < size; ++i) {
            if (max > array[i]) {
                right = i;
            } else {
                max = Math.max(max, array[i]);
            }
            if (min < array[size - i - 1]) {
                left = size - i - 1;
            } else {
                min = Math.min(min, array[size - i - 1]);
            }
        }
        if (left >= right) {
            return new int[]{-1, -1};
        }
        return new int[]{left, right};
    }

    public int[] subSort_1(int[] array) {
        int size = array.length;
        int[] tmp = new int[size];
        System.arraycopy(array, 0, tmp, 0, size);
        Arrays.sort(tmp);
        int left = -1;
        int right = -1;
        for (int i = 0; i < size; ++i) {
            if (tmp[i] != array[i]) {
                left = i;
                break;
            }
        }
        for (int i = size - 1; i >= 0; --i) {
            if (tmp[i] != array[i]) {
                right = i;
                break;
            }
        }
        return new int[]{left, right};
    }

}
