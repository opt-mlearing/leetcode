package leetcode.offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer 32 - I. 从上到下打印二叉树
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/submissions/
 */
public class SolutionOffer_32_I {

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        deque.offer(root);
        List<Integer> list = new ArrayList<Integer>();
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; ++i) {
                TreeNode tmpNode = deque.pop();
                list.add(tmpNode.val);
                if (tmpNode.left != null) {
                    deque.offer(tmpNode.left);
                }
                if (tmpNode.right != null) {
                    deque.offer(tmpNode.right);
                }
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            res[i] = list.get(i);
        }
        return res;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
