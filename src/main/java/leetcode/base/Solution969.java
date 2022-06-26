package leetcode.base;

import java.util.ArrayList;
import java.util.List;

/**
 * 969. 煎饼排序
 * https://leetcode.cn/problems/pancake-sorting/
 *
 * @author: caogl
 * @date: 2022/6/27, 0:48
 **/
public class Solution969 {

    public List<Integer> pancakeSort(int[] arr) {
        int size = arr.length;
        List<Integer> res = new ArrayList<Integer>();
        for (int i = size; i > 1; --i) {
            int index = find(arr, i);
            if (index == i - 1) {
                continue;
            }
            reverse(arr, index);
            reverse(arr, i - 1);
            res.add(index + 1);
            res.add(i);
        }
        return res;
    }

    private int find(int[] arr, int right) {
        int index = 0;
        for (int i = 1; i < right; ++i) {
            if (arr[i] > arr[index]) {
                index = i;
            }
        }
        return index;
    }


    private void reverse(int[] arr, int right) {
        int start = 0;
        int end = right;
        while (start < end) {
            int tmp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = tmp;
        }
    }

}
