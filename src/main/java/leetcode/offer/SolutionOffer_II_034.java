package leetcode.offer;

/**
 * 剑指 Offer II 034. 外星语言是否排序
 * https://leetcode.cn/problems/lwyVBB/
 */
public class SolutionOffer_II_034 {

    public boolean isAlienSorted(String[] words, String order) {
        int[] orders = new int[26];
        char[] chars = order.toCharArray();
        for (int i = 0; i < order.length(); ++i) {
            orders[chars[i] - 'a'] = i;
        }
        for (int i = 0; i < words.length - 1; ++i) {
            String word1 = words[i];
            String word2 = words[i + 1];
            if (!compare(word1, word2, orders)) {
                return false;
            }
        }
        return true;
    }

    private boolean compare(String str1, String str2, int[] orders) {
        for (int i = 0; i < Math.min(str1.length(), str2.length()); ++i) {
            int index1 = orders[str1.charAt(i) - 'a'];
            int index2 = orders[str2.charAt(i) - 'a'];
            if (index1 < index2) {
                return true;
            } else if (index1 > index2) {
                return false;
            }
        }
        return str1.length() <= str2.length() ? true : false;
    }

}
