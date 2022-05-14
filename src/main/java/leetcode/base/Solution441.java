package leetcode.base;

/**
 * 441. 排列硬币
 * https://leetcode.cn/problems/arranging-coins/
 */
public class Solution441 {

    public int arrangeCoins_1(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            System.out.println("left: " + left + " right: " + right);
            int mid = left + (right - left + 1) / 2;
            if ((long) mid * (mid + 1) <= (long) 2 * n) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        System.out.println("left: " + left + " right: " + right);
        return left;
    }

    public int arrangeCoins_2(int n) {
        if (n == 1) {
            return 1;
        }
        int left = 1;
        int right = n;
        while (left < right) {
            System.out.println("left: " + left + " right: " + right);
            int mid = left + (right - left) / 2;
            if ((long) mid * (mid + 1) <= (long) 2 * n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        System.out.println("left: " + left + " right: " + right);
        return left - 1;
    }

    public int arrangeCoins_3(int n) {
        int left = 1;
        int right = n;
        while (left + 1 < right) {
            System.out.println("left: " + left + " right: " + right);
            int mid = left + (right - left) / 2;
            if ((long) mid * (mid + 1) <= (long) 2 * n) {
                left = mid;
            } else {
                right = mid;
            }
        }
        System.out.println("left: " + left + " right: " + right);
        return left;
    }


    public int arrangeCoins(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            System.out.println("left: " + left + " right: " + right);
            int mid = left + (right - left) / 2;
            if ((long) mid * (mid + 1) <= (long) 2 * n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println("left: " + left + " right: " + right);
        return right;
    }

}
