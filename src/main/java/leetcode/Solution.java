package leetcode;

/**
 * 拼接最大数
 * https://leetcode-cn.com/problems/create-maximum-number/submissions/
 */
public class Solution {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        int[] maxSubsequence = new int[k];
        int start = Math.max(0, k - n), end = Math.min(k, m);
        for (int i = start; i <= end; i++) {
            int[] subsequence1 = maxSubsequence(nums1, i);
            int[] subsequence2 = maxSubsequence(nums2, k - i);
            int[] curMaxSubsequence = merge(subsequence1, subsequence2);
            if (compare(curMaxSubsequence, 0, maxSubsequence, 0) > 0) {
                System.arraycopy(curMaxSubsequence, 0, maxSubsequence, 0, k);
            }
        }
        return maxSubsequence;
    }

    private int[] maxSubsequence(int[] nums, int k) {
        int length = nums.length;
        int[] stack = new int[k];
        int top = -1;
        // 需要移除的数字个数.
        int remain = length - k;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            while (top >= 0 && stack[top] < num && remain > 0) {
                top--;
                remain--;
            }
            if (top < k - 1) {
                stack[++top] = num;
            } else {
                remain--;
            }
        }
        return stack;
    }

    // 合并
    private int[] merge(int[] subsequence1, int[] subsequence2) {
        if (subsequence1.length == 0) {
            return subsequence2;
        }
        if (subsequence2.length == 0) {
            return subsequence1;
        }
        int[] res = new int[subsequence1.length + subsequence2.length];
        int l1 = 0;
        int l2 = 0;
        int index = 0;
        while (l1 < subsequence1.length || l2 < subsequence2.length) {
            if (compare(subsequence1, l1, subsequence2, l2) > 0) {
                res[index++] = subsequence1[l1++];
            } else {
                res[index++] = subsequence2[l2++];
            }
        }
        return res;
    }

    private int compare(int[] subsequence1, int index1, int[] subsequence2, int index2) {
        int x = subsequence1.length, y = subsequence2.length;
        while (index1 < x && index2 < y) {
            int diff = subsequence1[index1] - subsequence2[index2];
            if (diff != 0) {
                return diff;
            }
            index1++;
            index2++;
        }
        // 这里符号需要和diff保持一致.
        return (x - index1) - (y - index2);
    }

}
