package leetcode.offer;

/**
 * 剑指 Offer II 005. 单词长度的最大乘积
 * https://leetcode.cn/problems/aseY1I/
 */
public class SolutionOffer_II_005 {

    public int maxProduct(String[] words) {
        int size = words.length;
        int[] nums = new int[size];
        for (int i = 0; i < size; ++i) {
            for (char item : words[i].toCharArray()) {
                int index = item - 'a';
                nums[i] |= (1 << index);
            }
        }
        int res = 0;
        for (int i = 0; i < size - 1; ++i) {
            for (int j = i + 1; j < size; ++j) {
                if ((nums[i] & nums[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }

}
