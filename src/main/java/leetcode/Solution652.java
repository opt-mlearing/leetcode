package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 寻找重复的子树
 * https://leetcode-cn.com/problems/find-duplicate-subtrees/
 */
public class Solution652 {

    private List<TreeNode> result = new ArrayList<TreeNode>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        dfs(root, map, "");
        return result;
    }

    private String dfs(TreeNode root, Map<String, Integer> map, String str) {
        if (root == null) {
            return "#";
        }
        str = String.valueOf(root.val) + "," + dfs(root.left, map, str) + "," + dfs(root.right, map, str);
        int count = map.getOrDefault(str, 0) + 1;
        map.put(str, count);
        if (map.getOrDefault(str, 0) == 2) {
            result.add(root);
        }
        return str;
    }

    public static class TreeNode {
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
