package leetcode.base;

/**
 * 415. 字符串相加
 * https://leetcode-cn.com/problems/add-strings/submissions/
 */
public class Solution415 {

    public String addStrings(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int carry = 0;
        int i = m - 1;
        int j = n - 1;
        StringBuilder builer = new StringBuilder();
        while (i >= 0 || j >= 0 || carry != 0) {
            int n1 = (i >= 0 ? num1.charAt(i--) - '0' : 0);
            int n2 = (j >= 0 ? num2.charAt(j--) - '0' : 0);
            int tmp = n1 + n2 + carry;
            builer.append(tmp % 10);
            carry = tmp / 10;
        }
        return builer.reverse().toString();
    }

}
