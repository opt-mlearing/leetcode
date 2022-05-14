package leetcode.base;

/**
 * 744. 寻找比目标字母大的最小字母
 * https://leetcode.cn/problems/find-smallest-letter-greater-than-target/
 */
public class Solution744 {

    public char nextGreatestLetter(char[] letters, char target) {
        int size = letters.length;
        if (target >= letters[size - 1]) {
            return letters[0];
        }
        int left = 0;
        int right = size - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return letters[left];
    }

}