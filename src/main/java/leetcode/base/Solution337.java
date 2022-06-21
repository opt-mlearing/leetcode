package leetcode.base;

import java.util.HashMap;
import java.util.Map;

/**
 * 337. 打家劫舍 III
 * https://leetcode.cn/problems/house-robber-iii/
 *
 * @author: caogl
 * @date: 2022/6/22, 1:46
 **/
public class Solution337 {

    // 递归,不需要记忆化搜索.
    public int rob(TreeNode root) {
        int[] res = doRob(root);
        return Math.max(res[0], res[1]);
    }

    private int[] doRob(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] left = doRob(root.left);
        int[] right = doRob(root.right);
        int robVal = root.val + left[1] + right[1];
        int noRobVal = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{robVal, noRobVal};
    }

    private Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();

    public int rob_recursion_1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (map.containsKey(root)) {
            return map.get(root);
        }
        int robRoot = root.val;
        // 抢root
        if (root.left != null) {
            robRoot += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            robRoot += rob(root.right.left) + rob(root.right.right);
        }
        int noRobRoot = rob(root.left) + rob(root.right);
        int value = Math.max(robRoot, noRobRoot);
        map.put(root, value);
        return value;
    }


    private Map<TreeNode, Integer> select = new HashMap<>();
    private Map<TreeNode, Integer> abandon = new HashMap<>();

    public int rob_recursion_2(TreeNode root) {
        dfs(root);
        return Math.max(select.getOrDefault(root, 0), abandon.getOrDefault(root, 0));
    }

    // 深度优先搜索
    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        // 注意这里必须先进行递归搜索，在select && abandon 这两个集合中完成左子节点&&右子节点数值的填充.
        dfs(root.left);
        dfs(root.right);
        // 这里的动态转移方程是：
        // 1）当root节点被选中时，root.left && root.right必然不能继续选中；
        // 2）当root节点不被选中时，root.left、root.right 分别可以被选中或者可以不被选中.
        select.put(root, root.val + abandon.getOrDefault(root.left, 0) + abandon.getOrDefault(root.right, 0));
        abandon.put(root, Math.max(select.getOrDefault(root.left, 0), abandon.getOrDefault(root.left, 0))
                + Math.max(select.getOrDefault(root.right, 0), abandon.getOrDefault(root.right, 0)));
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
