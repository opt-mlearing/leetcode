package leetcode.base;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * 653. 两数之和 IV - 输入 BST
 * https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/
 */
public class Solution653 {

    // bfs.
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        Set<Integer> set = new HashSet<Integer>();
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.offer(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.poll();
            if (set.contains(k - node.val)) {
                return true;
            }
            set.add(node.val);
            if (node.left != null) {
                stack.offer(node.left);
            }
            if (node.right != null) {
                stack.offer(node.right);
            }
        }
        return false;
    }

    // dfs.
    public boolean findTarget_3(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        return dfs(root, k, new HashSet<Integer>());
    }

    private boolean dfs(TreeNode root, int k, Set<Integer> set) {
        if (root == null) {
            return false;
        }
        int key = k - root.val;
        if (set.contains(key)) {
            return true;
        }
        set.add(root.val);
        boolean left = dfs(root.left, k, set);
        boolean right = dfs(root.right, k, set);
        return left || right;
    }

    public boolean findTarget_2(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        dfsSearch(root, map, k);
        for (int key : map.keySet()) {
            int value = map.get(key);
            if (map.containsKey(value) && key != value) {
                return true;
            }
        }
        return false;
    }

    private void dfsSearch(TreeNode root, Map<Integer, Integer> map, int k) {
        if (root == null) {
            return;
        }
        map.put(root.val, k - root.val);
        dfsSearch(root.left, map, k);
        dfsSearch(root.right, map, k);
    }

    // 注意，题目给的是二叉搜索树.
    public boolean findTarget_1(TreeNode root, int k) {
        List<Integer> values = new ArrayList<Integer>();
        // 因为是二叉搜索树，中序遍历的结果是递增数列，双指针的时候可以利用到递增数列.
        preOrder(root, values);
        int left = 0;
        int right = values.size() - 1;
        while (left < right) {
            int tmp = values.get(left) + values.get(right);
            if (tmp < k) {
                left++;
            } else if (tmp > k) {
                right--;
            } else {
                return true;
            }
        }
        return false;
    }

    // 中序遍历.
    private void preOrder(TreeNode root, List<Integer> values) {
        if (root == null) {
            return;
        }
        preOrder(root.left, values);
        values.add(root.val);
        preOrder(root.right, values);
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
