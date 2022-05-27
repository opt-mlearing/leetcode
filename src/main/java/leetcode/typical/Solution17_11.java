package leetcode.typical;

/**
 * 面试题 17.11. 单词距离
 * https://leetcode.cn/problems/find-closest-lcci/
 */
public class Solution17_11 {

    // 一次遍历.
    public int findClosest(String[] words, String word1, String word2) {
        int index1 = -1;
        int index2 = -1;
        int res = words.length;
        for (int i = 0; i < words.length; ++i) {
            String word = words[i];
            if (word.equals(word1)) {
                index1 = i;
            } else if (word.equals(word2)) {
                index2 = i;
            }
            if (index1 != -1 && index2 != -1) {
                res = Math.min(res, Math.abs(index1 - index2));
            }
        }
        return res;
    }

}
