package leetcode.base;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 383. 赎金信
 * https://leetcode.cn/problems/ransom-note/submissions/
 *
 * @author: caogl
 * @date: 2022/6/19, 15:32
 **/
public class Solution383 {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];
        for (int i = 0; i < magazine.length(); ++i) {
            int index = magazine.charAt(i) - 'a';
            count[index]++;
        }
        for (int i = 0; i < ransomNote.length(); ++i) {
            int index = ransomNote.charAt(i) - 'a';
            count[index]--;
            if (count[index] < 0) {
                return false;
            }
        }
        return true;
    }

    // 会超出内存限制.
    public boolean canConstruct_2(String ransomNote, String magazine) {
        Set<String> sets = subSequence(magazine);
        return sets.contains(ransomNote);
    }

    private Set<String> set;

    private Set<String> subSequence(String magazine) {
        set = new HashSet<String>();
        char[] chars = magazine.toCharArray();
        Arrays.sort(chars);
        boolean[] isVisit = new boolean[chars.length];
        backTracking(chars, 0, isVisit, new StringBuffer());
        return set;
    }

    private void backTracking(char[] chars, int index, boolean[] isVisit, StringBuffer path) {
        set.add(new String(path));
        if (index == chars.length) {
            return;
        }
        for (int i = index; i < chars.length; ++i) {
            if (i > index && chars[i] == chars[i - 1] && !isVisit[i]) {
                continue;
            }
            isVisit[i] = true;
            path.append(chars[i]);
            backTracking(chars, i + 1, isVisit, path);
            path.deleteCharAt(path.length() - 1);
            isVisit[i] = false;
        }
    }

}
