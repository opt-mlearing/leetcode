package leetcode;

import com.sun.deploy.util.StringUtils;

import java.util.*;

/**
 * 二叉搜索树迭代器
 * https://leetcode-cn.com/problems/binary-search-tree-iterator/
 */
public class Solution173 {

    private List<Integer> list;
    private int point;

    // 二叉搜索树. 中序遍历，递增.
    public Solution173(TreeNode root) {
        list = new ArrayList<Integer>();
        innerTravel(root);
        point = list.size() > 0 ? list.get(0) - 1 : 0;

    }

    private void innerTravel(TreeNode root) {
        if (root == null) {
            return;
        }
        innerTravel(root.left);
        list.add(root.val);
        innerTravel(root.right);
    }

    public int next() {
        return list.remove(0);
    }

    public boolean hasNext() {
        return list.size() > 0;
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
