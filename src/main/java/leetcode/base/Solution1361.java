package leetcode.base;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1361. 验证二叉树
 * https://leetcode-cn.com/problems/validate-binary-tree-nodes/
 */
public class Solution1361 {

    // 二叉树为有向无环图
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] inDegree = new int[n];
        for (int i = 0; i < n; ++i) {
            if (leftChild[i] != -1) {
                inDegree[leftChild[i]]++;
            }
            if (rightChild[i] != -1) {
                inDegree[rightChild[i]]++;
            }
        }
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < n; ++i) {
            if (inDegree[i] > 1) {
                // 每个节点最大入度1，最大出度2.
                return false;
            }
            if (inDegree[i] == 0) {
                stack.offer(i);
            }
        }
        // 只有一个root节点.
        if (stack.size() != 1) {
            return false;
        }
        int res = 0;
        while (!stack.isEmpty()) {
            int size = stack.size();
            res += size;
            for (int i = 0; i < size; ++i) {
                int index = stack.poll();
                int left = leftChild[index];
                if (left != -1) {
                    inDegree[left]--;
                    if (inDegree[left] == 0) {
                        stack.offer(left);
                    }
                }
                int right = rightChild[index];
                if (right != -1) {
                    inDegree[right]--;
                    if (inDegree[right] == 0) {
                        stack.offer(right);
                    }
                }
            }
        }
        return res == n;
    }

}
