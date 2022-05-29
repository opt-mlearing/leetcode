package leetcode.base;

/**
 * 953. 验证外星语词典
 * https://leetcode.cn/problems/verifying-an-alien-dictionary/
 */
public class Solution953 {

    // 题目已经明确小写字母，那么只有26个.
    public boolean isAlienSorted(String[] words, String order) {
        int[] sort = new int[26];
        for (int i = 0; i < order.length(); ++i) {
            sort[order.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < words.length - 1; ++i) {
            if (!compare(words[i], words[i + 1], sort)) {
                return false;
            }
        }
        return true;
    }

    private boolean compare(String word1, String word2, int[] sort) {
        for (int i = 0; i < Math.min(word1.length(), word2.length()); ++i) {
            int sort1 = sort[word1.charAt(i) - 'a'];
            int sort2 = sort[word2.charAt(i) - 'a'];
            if (sort1 < sort2) {
                return true;
            } else if (sort1 > sort2) {
                return false;
            }
        }
        return word1.length() <= word2.length() ? true : false;
    }

}
