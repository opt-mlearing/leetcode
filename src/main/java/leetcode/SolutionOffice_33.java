package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
 */
public class SolutionOffice_33 {

    public boolean verifyPostorder(int[] postorder) {
        int size = postorder.length;
        int root = Integer.MAX_VALUE;
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = size - 1; i >= 0; --i) {
            if (root < postorder[i]) {
                return false;
            }
            while (!stack.isEmpty() && stack.peek() > postorder[i]) {
                root = stack.pop();
            }
            stack.push(postorder[i]);
        }
        return true;
    }

}
