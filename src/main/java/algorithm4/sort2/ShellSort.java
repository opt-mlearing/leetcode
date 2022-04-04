package algorithm4.sort2;

/**
 * 选择排序.
 */
public class ShellSort implements SortInterface {

    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();
        int[] arr = new int[]{3, 5, 2, 6, 1, 0, 4, 8, 7, 7, 7, 4, 5, 6, 8, 2, 0};
        shellSort.sort(arr);
        System.out.println(arr);
    }

    @Override
    public void sort(int[] nums) {
        int size = nums.length;
        int h = 1;
        while (h < size / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < size; ++i) {
                for (int j = i; j >= h && nums[j] < nums[j - h]; j -= h) {
                    int tmp = nums[j - h];
                    nums[j - h] = nums[j];
                    nums[j] = tmp;
                }
            }
            h = h / 3;
        }
    }

}
