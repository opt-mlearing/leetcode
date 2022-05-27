package leetcode.base;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;

/**
 * 637. 二叉树的层平均值
 * https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/
 */
public class Solution637 {

    // dfs
    public List<Double> averageOfLevels_dfs(TreeNode root) {
        List<Double> res = new ArrayList<Double>();
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        if (root == null) {
            return res;
        }
        dfs(root, 0, map);
        for (Integer key : map.keySet()) {
            List<Integer> list = map.get(key);
            double sum = 0;
            for (int num : list) {
                sum += num;
            }
            res.add(key, sum / list.size());
        }
        return res;
    }

    private void dfs(TreeNode root, int depth, Map<Integer, List<Integer>> map) {
        if (root == null) {
            return;
        }
        List<Integer> list = map.getOrDefault(depth, new ArrayList<Integer>());
        list.add(root.val);
        map.put(depth, list);
        dfs(root.left, depth + 1, map);
        dfs(root.right, depth + 1, map);
    }

    // bfs.
    public List<Double> averageOfLevels_bfs(TreeNode root) {
        List<Double> res = new ArrayList<Double>();
        if (root != null) {
            Deque<TreeNode> deque = new LinkedList<TreeNode>();
            deque.offer(root);
            while (!deque.isEmpty()) {
                int size = deque.size();
                double sum = 0;
                for (int i = 0; i < size; ++i) {
                    TreeNode node = deque.poll();
                    sum += node.val;
                    if (node.left != null) {
                        deque.offer(node.left);
                    }
                    if (node.right != null) {
                        deque.offer(node.right);
                    }
                }
                res.add(sum / size);
            }
        }
        return res;
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
