package leetcode;

/**
 * 1569. 将子数组重新排序得到同一个二叉查找树的方案数
 * https://leetcode-cn.com/problems/number-of-ways-to-reorder-array-to-get-same-bst/
 */
public class Solution1569 {

    private static final int MOD = 1000000007;
    private long[][] dp;

    public int numOfWays(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        dp = combination(n);
        TreeNode root = new TreeNode(nums[0]);
        for (int i = 1; i < n; ++i) {
            int val = nums[i];
            insert(root, val);
        }
        dfs(root);
        // 防止越界.
        return (root.ans - 1 + MOD) % MOD;
    }

    // 利用动态规划计算组合数.
    private long[][] combination(int size) {
        long[][] dp = new long[size][size];
        // 从i中选取j个. i>= 0, j=0
        for (int i = 0; i < size; ++i) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < size; ++i) {
            for (int j = 1; j <= i; ++j) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % MOD;
            }
        }
        return dp;
    }

    // 通过模拟插入过程，统计以任意节点为根的树的节点数量.
    private void insert(TreeNode root, int value) {
        TreeNode cur = root;
        for (; ; ) {
            // 逐步便利到插入位置
            ++cur.size;
            if (value < cur.value) {
                if (cur.left == null) {
                    cur.left = new TreeNode(value);
                    return;
                }
                cur = cur.left;
            } else {
                if (cur.right == null) {
                    cur.right = new TreeNode(value);
                    return;
                }
                cur = cur.right;
            }
        }
    }

    // 通过遍历完成对组合数量的统计.
    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        dfs(node.right);
        int lsize = node.left != null ? node.left.size : 0;
        int rsize = node.right != null ? node.right.size : 0;
        int lans = node.left != null ? node.left.ans : 1;
        int rans = node.right != null ? node.right.ans : 1;
        node.ans = (int) (dp[lsize + rsize][lsize] % MOD * lans % MOD * rans % MOD);
    }

    private static class TreeNode {
        TreeNode left;
        TreeNode right;
        int value;
        // 以当前节点为根的树的节点数量
        int size;
        // 组合数量.
        int ans;

        TreeNode(int value) {
            this.left = null;
            this.right = null;
            this.value = value;
            this.size = 1;
            this.ans = 0;
        }
    }

}
