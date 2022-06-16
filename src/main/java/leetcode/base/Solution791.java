package leetcode.base;

/**
 * 791. 自定义字符串排序
 * https://leetcode.cn/problems/custom-sort-string/
 *
 * @author: caogl
 * @date: 2022/6/16, 23:57
 **/
public class Solution791 {

    public String customSortString(String order, String s) {
        int[] count = new int[26];
        int size = s.length();
        for (int i = 0; i < size; ++i) {
            int index = s.charAt(i) - 'a';
            count[index]++;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < order.length(); ++i) {
            int index = order.charAt(i) - 'a';
            while (count[index] > 0) {
                builder.append(order.charAt(i));
                count[index]--;
            }
        }
        for (char i = 0; i < 26; ++i) {
            while (count[i] > 0) {
                builder.append((char) (i + 'a'));
                count[i]--;
            }
        }
        return builder.toString();
    }

}
