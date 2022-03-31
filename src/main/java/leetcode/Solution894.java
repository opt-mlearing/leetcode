package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 所有可能的满二叉树
 * https://leetcode-cn.com/problems/all-possible-full-binary-trees/
 */
public class Solution894 {

    private List<TreeNode> res;

    public List<TreeNode> allPossibleFBT(int n) {
        res = new ArrayList<TreeNode>();
        if (n % 2 == 0) {
            return res;
        }
        dfs(n, res);
        return res;
    }

    private void dfs(int n, List<TreeNode> list) {
        if (n == 0) {
            return;
        }
        if (n == 1) {
            list.add(new TreeNode(0));
            return;
        }
        for (int i = 1; i < n - 1; i += 2) {
            List<TreeNode> leftTree = new ArrayList<TreeNode>();
            List<TreeNode> rightTree = new ArrayList<TreeNode>();
            dfs(i, leftTree);
            dfs(n - 1 - i, rightTree);
            for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    list.add(root);
                }
            }
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
