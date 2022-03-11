package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution437 {

    // 前缀和方法&dfs
    // 什么是前缀和方式--》当前节点为 node，从root到node的全部和表示前缀和.
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> preSumMap = new HashMap<Long, Integer>();
        // 特殊处理前缀和为0情况
        preSumMap.put(0l, 1);
        return preSumDfs(root, preSumMap, 0l, targetSum);
    }

    private int preSumDfs(TreeNode node, Map<Long, Integer> preSumMap, Long curr, int targetSum) {
        int count = 0;
        if (node == null) {
            return 0;
        }
        curr += node.val;
        // 从前缀集合中寻找--》前缀的数值恰好等于 curr- targetSum 的次数
        count += preSumMap.getOrDefault(curr - targetSum, 0);
        preSumMap.put(curr, preSumMap.getOrDefault(curr, 0) + 1);
        count += preSumDfs(node.left, preSumMap, curr, targetSum);
        count += preSumDfs(node.right, preSumMap, curr, targetSum);
        // 当退出当前节点时，需要因为当千节点增加的次数，需要减1.
        preSumMap.put(curr, preSumMap.getOrDefault(curr, 0) - 1);
        return count;
    }

    public int pathSum_dfs(TreeNode root, int targetSum) {
        int totalCount = 0;
        if (root == null) {
            return totalCount;
        }
        // 从当前root出发, 深度优先搜索.
        totalCount += dfs(root, targetSum);
        // 从当前root.left出发
        totalCount += pathSum_dfs(root.left, targetSum);
        // 从当前root.right出发
        totalCount += pathSum_dfs(root.right, targetSum);
        return totalCount;
    }

    private int dfs(TreeNode root, int targetSum) {
        int count = 0;
        if (root == null) {
            return 0;
        }
        if (root.val == targetSum) {
            count++;
        }
        count += dfs(root.left, targetSum - root.val);
        count += dfs(root.right, targetSum - root.val);
        return count;
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
