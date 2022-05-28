package leetcode.offer;

import java.util.Arrays;

/**
 * 剑指 Offer II 014. 字符串中的变位词
 * https://leetcode.cn/problems/MPnaiL/
 */
public class SolutionOffer_II_014 {

    public boolean checkInclusion(String s1, String s2) {
        int size1 = s1.length();
        int size2 = s2.length();
        if (size1 > size2) {
            return false;
        }
        // 26个字母，int类型32位，正好可存储.
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for (int i = 0; i < size1; ++i) {
            int index1 = s1.charAt(i) - 'a';
            int index2 = s2.charAt(i) - 'a';
            arr1[index1]++;
            arr2[index2]++;
        }
        if (Arrays.equals(arr1, arr2)) {
            return true;
        }
        for (int i = size1; i < size2; ++i) {
            int index1 = s2.charAt(i) - 'a';
            int index2 = s2.charAt(i - size1) - 'a';
            arr2[index1]++;
            arr2[index2]--;
            if (Arrays.equals(arr1, arr2)) {
                return true;
            }
        }
        return false;
    }

}
