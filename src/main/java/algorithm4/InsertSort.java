package algorithm4;

/**
 * 插入排序.
 * 插入排序与选择排序一样，当前索引左边的所有元素都是有序，但它们的最终暂不确定，
 * 为了给更小的元素腾出空间，它们可能会被移动。当索引到达数组的右端时，数组排序就完成了.
 * 可选择排序不同的是，插入排序所需的时间取决于输入中元素的初始顺序。例如，对一个很大且
 * 其中的元素已经有序（或接近有序）的数组进行排序将会比对随机顺序的数组的或是逆序数组进行
 * 排序要快的多.
 * 我们考虑到更一般的情况是部分有序的数组，倒置指的是数组中的两个顺序颠倒的元素。
 * 如果数组中倒置的数量小于数大小的某个倍数，那么我们认为这个数组是部分有序的.
 * 对于这种情况，可以使用插入排序.
 */
public class InsertSort implements SortInterface {

    @Override
    public void sort(int[] nums) {
        for (int i = 1; i < nums.length; ++i) {
            for (int j = i; j > 0 && nums[j] < nums[j - 1]; --j) {
                int tmp = nums[j - 1];
                nums[j - 1] = nums[j];
                nums[j] = tmp;
            }
        }
    }
}
