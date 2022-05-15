package leetcode.offer;

/**
 * 剑指 Offer II 069. 山峰数组的顶部
 * https://leetcode.cn/problems/B1IidL/
 */
public class SolutionOffer_II_069 {

    public int peakIndexInMountainArray(int[] arr) {
        int size = arr.length;
        int left = 0;
        int right = size - 1;
        while (left + 1 != right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (arr[mid - 1] < arr[mid]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return arr[left] > arr[right] ? left : right;
    }

}
