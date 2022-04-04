package algorithm4.sort2;

/**
 * 归并排序.
 */
public class MergeSort implements SortInterface {

    @Override
    public void sort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        doSort(nums, 0, nums.length - 1);
    }

    private void doSort(int[] nums, int start, int end) {
        int mid = (start + end) >> 1;
        doSort(nums, start, mid);
        doSort(nums, mid + 1, end);
        doMerge(nums, start, mid, end);
    }

    private void doMerge(int[] nums, int start, int mid, int end) {
        int[] res = new int[nums.length];
        System.arraycopy(nums, start, res, start, end - start - 1);
        int i = start;
        int j = mid + 1;
        for (int k = start; k <= end; ++k) {
            if (i > mid) {
                nums[k] = res[j++];
            } else if (j > end) {
                nums[k] = res[i++];
            } else if (nums[i] < nums[j]) {
                nums[k] = res[i++];
            } else {
                nums[k] = res[j++];
            }
        }
    }

}
