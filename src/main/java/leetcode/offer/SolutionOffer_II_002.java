package leetcode.offer;

/**
 * 剑指 Offer II 002. 二进制加法
 * https://leetcode-cn.com/problems/JFETK5/
 */
public class SolutionOffer_II_002 {

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
