package leetcode.base;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 2196. 根据描述创建二叉树
 * https://leetcode.cn/problems/create-binary-tree-from-descriptions/
 */
public class Solution2196 {

    // 二叉树中各节点的值 互不相同.
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<Integer, TreeNode>();
        Set<Integer> childKey = new HashSet<Integer>();
        int size = descriptions.length;
        for (int i = 0; i < size; ++i) {
            TreeNode parent = null;
            if (!map.containsKey(descriptions[i][0])) {
                parent = new TreeNode(descriptions[i][0]);
                map.put(descriptions[i][0], parent);
            } else {
                parent = map.get(descriptions[i][0]);
            }
            TreeNode child = null;
            if (!map.containsKey(descriptions[i][1])) {
                child = new TreeNode(descriptions[i][1]);
                map.put(descriptions[i][1], child);
            } else {
                child = map.get(descriptions[i][1]);
            }
            childKey.add(descriptions[i][1]);
            if (descriptions[i][2] == 1) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        }
        for (int key : map.keySet()) {
            if (!childKey.contains(key)) {
                return map.get(key);
            }
        }
        return null;
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
