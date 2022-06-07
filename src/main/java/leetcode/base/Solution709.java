package leetcode.base;

/**
 * 709. 转换成小写字母
 * https://leetcode.cn/problems/to-lower-case/submissions/
 */
public class Solution709 {

    public String toLowerCase(String s) {
        int size = s.length();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < size; ++i) {
            char tmp = s.charAt(i);
            if (tmp >= 65 && tmp <= 90) {
                tmp |= 32;
            }
            builder.append(tmp);
        }
        return builder.toString();
    }

}
