package leetcode.offer;

import java.util.Arrays;

/**
 * 剑指 Offer II 075. 数组相对排序
 * https://leetcode.cn/problems/0H97ZC/
 */
public class SolutionOffer_II_075 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[arr2.length];
        for (int i = 0; i < arr1.length; ++i) {
            for (int j = 0; j < arr2.length; ++j) {
                if (arr1[i] == arr2[j]) {
                    arr1[i] = Integer.MIN_VALUE;
                    count[j]++;
                    break;
                }
            }
        }
        Arrays.sort(arr1);
        int index = 0;
        for (int i = 0; i < count.length; ++i) {
            while (count[i] != 0) {
                arr1[index++] = arr2[i];
                count[i]--;
            }
        }
        return arr1;
    }

}
