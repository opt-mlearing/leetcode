package leetcode.base;

/**
 * 367. 有效的完全平方数
 * https://leetcode.cn/problems/valid-perfect-square/
 */
public class Solution367 {

    public boolean isPerfectSquare_1(int num) {
        int left = 1;
        int right = num;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid <= num) {
                left = mid;
            } else {
                right = mid;
            }
        }
        System.out.println("left: " + left + " right: " + right);
        return left * left == num || right * right == num;
    }

    public boolean isPerfectSquare(int num) {
        int left = 1;
        int right = num;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if ((long) mid * mid <= num) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        System.out.println("left: " + left + " right: " + right);
        return right * right == num;
    }

    public boolean isPerfectSquare_3(int num) {
        int left = 1;
        int right = num;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid <= num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println("left: " + left + " right: " + right);
        return right * right == num;
    }

}