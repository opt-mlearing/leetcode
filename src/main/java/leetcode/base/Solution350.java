package leetcode.base;

import java.util.Arrays;

/**
 * 350. 两个数组的交集 II
 * https://leetcode.cn/problems/intersection-of-two-arrays-ii/
 */
public class Solution350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] res = new int[nums1.length + nums2.length];
        int l1 = 0;
        int l2 = 0;
        int index = 0;
        while (l1 < nums1.length && l2 < nums2.length) {
            if (nums1[l1] == nums2[l2]) {
                res[index++] = nums1[l1];
                l1++;
                l2++;
            } else if (nums1[l1] < nums2[l2]) {
                l1++;
            } else {
                l2++;
            }
        }
        return Arrays.copyOfRange(res, 0, index);
    }

}