package leetcode.base;

/**
 * 轮转数组
 * https://leetcode-cn.com/problems/rotate-array/
 */
public class Solution189 {

    public void rotate_internal_exchange(int[] nums, int k) {
        k = k % nums.length;
        int size = gcd(nums.length, k);
        for (int i = 0; i < size; ++i) {
            int j = i;
            int pre = nums[i];
            do {
                int next = (j + k) % nums.length;
                int tmp = nums[next];
                nums[next] = pre;
                pre = tmp;
                j = next;
            } while (i != j);
        }
    }

    private int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }

    public void rotate_by_invert_array(int[] nums, int k) {
        k = k % nums.length;
        invert(nums, 0, nums.length - 1);
        invert(nums, 0, k - 1);
        invert(nums, k, nums.length - 1);
    }

    private void invert(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = tmp;
        }
    }

    public void rotate_extend_store_array(int[] nums, int k) {

        k = k % nums.length;
        int[] datas = new int[nums.length];
        int i = 0;
        while (i < nums.length) {
            datas[(i + k) % nums.length] = nums[i];
            i++;
        }
        System.arraycopy(datas, 0, nums, 0, nums.length);
    }

}
