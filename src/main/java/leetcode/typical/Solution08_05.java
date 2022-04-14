package leetcode.typical;

/**
 * 面试题 08.05. 递归乘法
 * https://leetcode-cn.com/problems/recursive-mulitply-lcci/
 */
public class Solution08_05 {

    public int multiply(int A, int B) {
        if (B == 0) {
            return 1;
        }
        if (B == 1) {
            return A;
        }
        if (B % 2 == 0) {
            return multiply(A << 1, B / 2);
        } else {
            return multiply(A << 1, B / 2) + A;
        }
    }

}
