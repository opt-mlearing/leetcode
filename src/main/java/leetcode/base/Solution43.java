package leetcode.base;

/**
 * 43. 字符串相乘
 * https://leetcode-cn.com/problems/multiply-strings/
 */
public class Solution43 {

    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] res = new int[m + n];
        // 反过来的，高位数在前，地位数在后.
        for (int i = m - 1; i >= 0; --i) {
            int n1 = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; --j) {
                int n2 = num2.charAt(j) - '0';
                // res[i + j + 1] 是低位
                // res[i + j] 是高位
                int sum = (res[i + j + 1] + n1 * n2);
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            // 第一个数为0的话，直接跳过.
            if (i == 0 && res[i] == 0) {
                continue;
            }
            result.append(res[i]);
        }
        return result.toString();
    }

}
