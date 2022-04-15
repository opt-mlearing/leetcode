package leetcode.base;

// 删除二叉搜索树中的节点.
public class Solution450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        // 二叉搜索特性：中序遍历是一个递增数组.
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            // 待删除的目标节点存在于左子树
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            // 待删除的目标节点存在于右子树
            root.right = deleteNode(root.right, key);
        } else {
            // 直接命中目标节点
            // 根据目标节点在树中的位置分类处理
            // 目标是叶子结点，直接断开
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.right != null) {
                // 若存在右子树，那么寻找后继节点
                TreeNode post = postTreeNode(root);
                root.val = post.val;
                // 从右子树中删除后继节点
                root.right = deleteNode(root.right, root.val);
            } else {
                // 只存在左子树，那么寻找前继节点
                TreeNode pre = preTreeNode(root);
                root.val = pre.val;
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }

    private TreeNode postTreeNode(TreeNode node) {
        node = node.right;
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private TreeNode preTreeNode(TreeNode node) {
        node = node.left;
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    private static class TreeNode {
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
