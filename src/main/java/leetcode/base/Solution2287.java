package leetcode.base;

/**
 * 2287. 重排字符形成目标字符串
 * https://leetcode.cn/problems/rearrange-characters-to-make-target-string/
 */
public class Solution2287 {

    public int rearrangeCharacters(String s, String target) {
        int size1 = s.length();
        int size2 = target.length();
        int[] list1 = new int[26];
        int[] list2 = new int[26];
        for (int i = 0; i < size1; ++i) {
            list1[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < size2; ++i) {
            list2[target.charAt(i) - 'a']++;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 26; ++i) {
            if (list2[i] != 0) {
                res = Math.min(res, list1[i] / list2[i]);
            }
        }
        return res;
    }

}
