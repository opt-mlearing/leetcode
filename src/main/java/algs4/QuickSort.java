package algs4;

/**
 * quick sort.
 *
 * @author: caogl
 * @date: 2022/6/26, 16:25
 **/
public class QuickSort {

    public int[] quickSort(int[] nums) {
        helper(nums, 0, nums.length - 1);
        return nums;
    }

    private void helper(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = partition1(nums, left, right);
        helper(nums, left, pivot - 1);
        helper(nums, pivot + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int start = left;
        int end = right - 1;
        while (start <= end) {
            if (nums[start] <= pivot) {
                start++;
            } else if (nums[end] > pivot) {
                end--;
            } else {
                swap(nums, start++, end--);
            }
        }
        swap(nums, start, right);
        return start;
    }

    private int partition1(int[] nums, int left, int right) {
        int pivot = nums[right];
        int start = left;
        int wall = left;
        for (int i = left; i < right; ++i) {
            if (nums[i] < pivot) {
                swap(nums, i, wall);
                wall++;
            }
        }
        swap(nums, wall, right);
        return wall;
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

}
