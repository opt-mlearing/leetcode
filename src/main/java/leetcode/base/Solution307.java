package leetcode.base;

/**
 * 307. 区域和检索 - 数组可修改
 * https://leetcode.cn/problems/range-sum-query-mutable/
 *
 * @author: caogl
 * @date: 2022/7/3, 22:34
 **/
public class Solution307 {

    private int[] segmentTree;
    private int size;

    public Solution307(int[] nums) {
        size = nums.length;
        segmentTree = new int[nums.length * 4];
        build(0, 0, size - 1, nums);
    }

    public void update(int index, int val) {
        change(index, val, 0, 0, size - 1);
    }

    public int sumRange(int left, int right) {
        return range(left, right, 0, 0, size - 1);
    }

    private void build(int node, int start, int end, int[] nums) {
        if (start == end) {
            segmentTree[node] = nums[start];
            return;
        }
        int mid = start + (end - start) / 2;
        build(node * 2 + 1, start, mid, nums);
        build(node * 2 + 2, mid + 1, end, nums);
        segmentTree[node] = segmentTree[node * 2 + 1] + segmentTree[node * 2 + 2];
    }

    private void change(int index, int val, int node, int start, int end) {
        if (start == end) {
            segmentTree[node] = val;
            return;
        }
        int mid = start + (end - start) / 2;
        if (index <= mid) {
            change(index, val, node * 2 + 1, start, mid);
        } else {
            change(index, val, node * 2 + 2, mid + 1, end);
        }
        segmentTree[node] = segmentTree[node * 2 + 1] + segmentTree[node * 2 + 2];
    }

    private int range(int left, int right, int node, int start, int end) {
        if (left == start && right == end) {
            return segmentTree[node];
        }
        int mid = start + (end - start) / 2;
        if (right <= mid) {
            return range(left, right, node * 2 + 1, start, mid);
        } else if (left > mid) {
            return range(left, right, node * 2 + 2, mid + 1, end);
        } else {
            return range(left, mid, node * 2 + 1, start, mid) +
                    range(mid + 1, right, node * 2 + 2, mid + 1, end);
        }
    }

}
