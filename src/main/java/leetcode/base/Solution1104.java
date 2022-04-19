package leetcode.base;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 1104. 二叉树寻路
 * https://leetcode-cn.com/problems/path-in-zigzag-labelled-binary-tree/
 */
public class Solution1104 {

    public List<Integer> pathInZigZagTree(int label) {
        int val = 1;
        int line = 1;
        // 找出label所在的行.
        while (val * 2 <= label) {
            line++;
            val *= 2;
        }
        if (line % 2 == 0) {
            label = getEvenLineValue(label, line);
        }
        Deque<Integer> stack = new LinkedList<Integer>();
        while (line > 0) {
            if (line % 2 == 0) {
                // label反转下，结果输出. label
                stack.push(getEvenLineValue(label, line));
            } else {
                stack.push(label);
            }
            label >>= 1;
            line--;
        }
        return new ArrayList<Integer>(stack);
    }

    // 偶数行的话，需要取反，得到原始正常标记
    private int getEvenLineValue(int label, int line) {
        return (1 << (line - 1)) + ((1 << line) - 1) - label;
    }

}
