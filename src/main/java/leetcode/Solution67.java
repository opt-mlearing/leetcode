package leetcode;

/**
 * 67. 二进制求和
 * https://leetcode-cn.com/problems/add-binary/
 */
public class Solution67 {

    public String addBinary(String a, String b) {
        int m = a.length();
        int n = b.length();
        int carry = 0;
        int i = m - 1;
        int j = n - 1;
        StringBuilder builder = new StringBuilder();
        while (i >= 0 || j >= 0 || carry != 0) {
            int n1 = (i >= 0 ? a.charAt(i--) - '0' : 0);
            int n2 = (j >= 0 ? b.charAt(j--) - '0' : 0);
            int tmp = n1 + n2 + carry;
            carry = tmp / 2;
            builder.append(tmp % 2);
        }
        return builder.reverse().toString();
    }

}
