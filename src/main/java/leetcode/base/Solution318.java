package leetcode.base;

/**
 * 318. 最大单词长度乘积
 * https://leetcode.cn/problems/maximum-product-of-word-lengths/
 */
public class Solution318 {

    public int maxProduct(String[] words) {
        // int类型32位，字母一共26个，足够.
        int size = words.length;
        int[] items = new int[size];
        for (int i = 0; i < size; ++i) {
            char[] chars = words[i].toCharArray();
            int num = 0;
            for (char item : chars) {
                int len = item - 'a';
                // 注意这里是或运算，相同就写一次.
                num |= (1 << len);
            }
            items[i] = num;
        }
        int res = 0;
        for (int i = 0; i < size; ++i) {
            for (int j = i + 1; j < size; ++j) {
                if ((items[i] & items[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }

}
