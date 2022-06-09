package leetcode.base;

import java.util.ArrayList;
import java.util.List;

/**
 * 763. 划分字母区间
 * https://leetcode.cn/problems/partition-labels/
 */
public class Solution763 {

    public List<Integer> partitionLabels(String s) {
        int size = s.length();
        int[] array = new int[26];
        for (int i = 0; i < size; ++i) {
            int index = s.charAt(i) - 'a';
            array[index] = i;
        }
        int left = 0;
        int right = 0;
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < size; ++i) {
            int index = s.charAt(i) - 'a';
            right = Math.max(right, array[index]);
            if (right == i) {
                res.add(i - left + 1);
                left = i + 1;
            }
        }
        return res;
    }

}
