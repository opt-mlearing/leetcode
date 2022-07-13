package algs4;

/**
 * 区间和,线段树,数组形式.
 *
 * @author caogaoli
 * @date 2022/7/13 11:22
 */
public class SegmentTreeArr {

    private int[] nums;
    private Integer[] tree;
    private int size;

    public SegmentTreeArr(int[] nums) {
        this.nums = nums;
        this.size = nums.length;
        // 最大长度为4* size.
        this.tree = new Integer[4 * size];
        build(0, 0, size - 1);
    }

    private void build(int node, int L, int R) {
        if (L == R) {
            tree[node] = nums[L];
            return;
        }
        int leftNode = node * 2 + 1;
        int rightNode = node * 2 + 2;
        int mid = L + (R - L) / 2;
        build(leftNode, L, mid);
        build(rightNode, mid + 1, R);
        tree[node] = tree[leftNode] + tree[rightNode];
    }

    public int query(int L, int R) {
        return query(0, L, R);
    }

    private int query(int node, int L, int R) {
        if (node < L || node > R) {
            return 0;
        }
        if (L == R) {
            return tree[node];
        } else if (node >= L && node <= R) {
            return tree[node];
        } else {
            int leftNode = 2 * node + 1;
            int rightNode = 2 * node + 2;
            int mid = L + (R - L) / 2;
            return query(leftNode, L, mid) + query(rightNode, mid + 1, R);
        }
    }

    public void update(int index, int value) {
        update(0, index, value, 0, size - 1);
    }

    private void update(int node, int index, int value, int L, int R) {
        if (L == R) {
            tree[node] = value;
        }
        int leftNode = 2 * node + 1;
        int rightNode = 2 * node + 2;
        int mid = L + (R - L) / 2;
        if (index <= mid) {
            update(leftNode, index, value, L, mid);
        } else if (index > mid) {
            update(rightNode, index, value, mid + 1, R);
        }
        tree[node] = tree[leftNode] + tree[rightNode];
    }

}
