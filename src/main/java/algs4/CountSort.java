package algs4;

/**
 * count sort。
 *
 * @author: caogl
 * @date: 2022/6/26, 22:33
 **/
public class CountSort {

    public int[] countSort(int[] nums) {
        int size = nums.length;
        int[] count = new int[256];
        for (int i = 0; i < size; ++i) {
            count[nums[i]]++;
        }
        for (int i = 1; i <= 256; ++i) {
            count[i] += count[i - 1];
        }
        int[] res = new int[size];
        for (int i = size - 1; i >= 0; ++i) {
            res[count[nums[i]] - 1] = nums[i];
            count[nums[i]]--;
        }
        return res;
    }

}
