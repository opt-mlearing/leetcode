package leetcode.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 剑指 Offer II 015. 字符串中的所有变位词
 * https://leetcode.cn/problems/VabMRr/
 */
public class SolutionOffer_II_015 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<Integer>();
        if (s.length() < p.length()) {
            return res;
        }
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for (int i = 0; i < p.length(); ++i) {
            arr1[s.charAt(i) - 'a']++;
            arr2[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(arr1, arr2)) {
            res.add(0);
        }
        for (int i = p.length(); i < s.length(); ++i) {
            arr1[s.charAt(i) - 'a']++;
            arr1[s.charAt(i - p.length()) - 'a']--;
            if (Arrays.equals(arr1, arr2)) {
                res.add(i - p.length() + 1);
            }
        }
        return res;
    }

}
