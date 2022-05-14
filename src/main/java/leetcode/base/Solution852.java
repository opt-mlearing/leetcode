package leetcode.base;

/**
 * 852. 山脉数组的峰顶索引
 * https://leetcode.cn/problems/peak-index-in-a-mountain-array/
 */
public class Solution852 {

    public int peakIndexInMountainArray(int[] arr) {
        int size = arr.length;
        int left = 0;
        int right = size - 1;
        while (left + 1 != right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (arr[mid] > arr[mid - 1]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return arr[left] > arr[right] ? left : right;
    }

}
