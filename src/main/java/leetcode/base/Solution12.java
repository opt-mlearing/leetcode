package leetcode.base;

/**
 * 12. 整数转罗马数字
 * https://leetcode-cn.com/problems/integer-to-roman/
 */
public class Solution12 {

    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] str = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < values.length; ++i) {
            while (num >= values[i]) {
                num -= values[i];
                buffer.append(str[i]);
            }
            if (num == 0) {
                return buffer.toString();
            }
        }
        return buffer.toString();
    }

}
