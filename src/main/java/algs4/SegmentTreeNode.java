package algs4;

/**
 * 区间最大,线段树,动态扩点.
 *
 * @author caogaoli
 * @date 2022/7/13 13:41
 */
public class SegmentTreeNode {

    private TreeNode root;

    public SegmentTreeNode(int[] nums) {
        this.root = build(nums);
    }

    // 构造线段树.
    public TreeNode build(int[] nums) {
        return doBuild(0, nums.length - 1, nums);
    }

    // 区间最大值查询
    public int query(int left, int right) {
        return doQuery(root, left, right);
    }

    // 更新区间最大
    public void update(int index, int value) {
        dpUpdate(root, index, value);
    }

    private void dpUpdate(TreeNode root, int index, int value) {
        if (root.start == root.end && root.start == index) {
            root.max = value;
            return;
        }
        int mid = root.start + (root.end - root.start) / 2;
        if (index <= mid) {
            dpUpdate(root.left, index, value);
        } else {
            dpUpdate(root.right, index, value);
        }
        root.max = Math.max(root.left.max, root.right.max);
    }

    private int doQuery(TreeNode root, int left, int right) {
        int tmp = Integer.MIN_VALUE;
        int mid = root.start + (root.end - root.start) / 2;
        if (mid >= left) {
            tmp = Math.max(tmp, doQuery(root.left, left, mid));
        } else {
            tmp = Math.max(tmp, doQuery(root.right, mid + 1, right));
        }
        return tmp;
    }

    private TreeNode doBuild(int start, int end, int[] nums) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(start, end, nums[start]);
        if (start == end) {
            return root;
        }
        int mid = start + (end - start) / 2;
        root.left = doBuild(start, mid, nums);
        root.right = doBuild(mid + 1, end, nums);
        root.max = Math.max(root.left.max, root.right.max);
        return root;
    }

    private static class TreeNode {
        private int max;
        private int start;
        private int end;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int max, int start, int end) {
            this.max = max;
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
        }
    }

}
