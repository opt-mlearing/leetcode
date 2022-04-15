package leetcode.base;

/**
 * 盛水最多的容器.
 *
 * @link https://leetcode-cn.com/problems/container-with-most-water/
 */
public class Solution11 {

    public int maxArea(int[] height) {

        int len = height.length;
        int left = 0;
        int right = len - 1;
        int maxVal = 0;
        while (left < right) {
            int tmp = Math.min(height[left], height[right]) * (right - left);
            maxVal = Math.max(tmp, maxVal);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }

        }
        return maxVal;
    }

}
