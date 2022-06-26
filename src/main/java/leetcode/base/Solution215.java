package leetcode.base;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 215. 数组中的第K个最大元素
 * https://leetcode.cn/problems/kth-largest-element-in-an-array/
 *
 * @author: caogl
 * @date: 2022/6/26, 17:59
 **/
public class Solution215 {

    // 利用快速排序的性质.
    // 10ms/ 41.2mb
    public int findKthLargest(int[] nums, int k) {
        help(nums, 0, nums.length - 1, k, 1);
        return nums[nums.length - k];
    }

    private void help(int[] nums, int left, int right, int k, int type) {
        if (left >= right) {
            return;
        }
        int piovt = -1;
        if (type == 1) {
            piovt = partition1(nums, left, right);
        } else if (type == 2) {
            piovt = partition2(nums, left, right);
        }
        if (piovt == nums.length - k) {
            return;
        }
        if (piovt > nums.length - k) {
            help(nums, left, piovt - 1, k, type);
        } else {
            help(nums, piovt + 1, right, k, type);
        }
    }

    // 升序排列.
    private int partition2(int[] nums, int left, int right) {
        int piovt = nums[right];
        int wall = left;
        for (int i = left; i < right; ++i) {
            if (nums[i] < piovt) {
                swap(nums, i, wall);
                wall++;
            }
        }
        swap(nums, wall, right);
        return wall;
    }

    // 升序排列.
    private int partition1(int[] nums, int left, int right) {
        int piovt = nums[right];
        int start = left;
        int end = right - 1;
        while (start <= end) {
            if (nums[start] < piovt) {
                start++;
            } else if (nums[end] > piovt) {
                end--;
            } else {
                swap(nums, start++, end--);
            }
        }
        swap(nums, start, right);
        return start;
    }

    // 交换.
    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    public int findKthLargest_stack(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return Integer.MIN_VALUE;
        }
        Deque<Integer> deque = new LinkedList<Integer>();
        Deque<Integer> tmpDeque = new LinkedList<Integer>();
        for (int i = 0; i < nums.length; ++i) {
            int tmp = nums[i];
            while (!deque.isEmpty() && deque.peek() > nums[i]) {
                tmpDeque.push(deque.pop());
            }
            deque.push(nums[i]);
            while (!tmpDeque.isEmpty()) {
                deque.push(tmpDeque.pop());
            }
        }
        while (k > 1) {
            deque.pop();
            k--;
        }
        return deque.pop();
    }

}
