package leetcode;

public class Solution278 {

    public int firstBadVersion(int n) {
        // 认为第一个出错的版本是left,那么left之前都是不出错的.
        int left = 1;
        int right = n;
        while (left < right) {
            int halfVal = left + (right - left) / 2;
            if (isBadVersion(halfVal)) {
                right = halfVal;
            } else {
                left = halfVal + 1;
            }
        }
        return left;
    }

    // 你可以通过调用bool isBadVersion(version)判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本；
    // 你应该尽量减少对调用 API 的次数；
    private boolean isBadVersion(int n) {
        return false;
    }

}
