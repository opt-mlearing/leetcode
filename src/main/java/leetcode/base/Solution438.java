package leetcode.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 * https://leetcode.cn/problems/find-all-anagrams-in-a-string/
 */
public class Solution438 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<Integer>();
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        int size1 = s.length();
        int size2 = p.length();
        if (size1 < size2) {
            return res;
        }
        for (int i = 0; i < p.length(); ++i) {
            int index1 = s.charAt(i) - 'a';
            int index2 = p.charAt(i) - 'a';
            arr1[index1]++;
            arr2[index2]++;
        }
        if (Arrays.equals(arr1, arr2)) {
            res.add(0);
        }
        for (int i = size2; i < size1; ++i) {
            int index1 = s.charAt(i) - 'a';
            int index2 = s.charAt(i - size2) - 'a';
            arr1[index1]++;
            arr1[index2]--;
            if (Arrays.equals(arr1, arr2)) {
                res.add(i - size2 + 1);
            }
        }
        return res;
    }

}
