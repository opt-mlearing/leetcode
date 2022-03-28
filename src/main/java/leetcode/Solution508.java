package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 出现次数最多的子树元素和.
 * https://leetcode-cn.com/problems/most-frequent-subtree-sum/
 * <p></p>
 * 这道题目先明确使用哪种二叉树的遍历方式，为什么最终选择了后续遍历？
 */
public class Solution508 {

    private Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    private int maxCount = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        postSearch(root);
        List<Integer> subList = new ArrayList<Integer>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxCount) {
                subList.add(entry.getKey());
            }
        }
        int[] result = new int[subList.size()];
        for (int i = 0; i < subList.size(); ++i) {
            result[i] = subList.get(i);
        }
        return result;
    }

    // 后序遍历，要计算以root为根节点开始树的全部节点的val的和，那么你就必须先获取到当前root的root.left && root.right 的和.
    // 所以，在前序 ｜｜ 中序 ｜｜ 后序三种遍历方式中，只有后序满足需要.
    private int postSearch(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int tmpSum = 0;
        tmpSum += postSearch(root.left);
        tmpSum += postSearch(root.right);
        tmpSum += root.val;
        map.put(tmpSum, (map.getOrDefault(tmpSum, 0) + 1));
        maxCount = Math.max(maxCount, map.getOrDefault(tmpSum, 0));
        return tmpSum;
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
