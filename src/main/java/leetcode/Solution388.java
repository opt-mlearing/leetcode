package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 文件的最长绝对路径
 * https://leetcode-cn.com/problems/longest-absolute-file-path/submissions/
 */
public class Solution388 {

    public int lengthLongestPath(String input) {
        String[] items = input.split("\n");
        int size = items.length;
        int res = 0;
        Deque<Node> stack = new LinkedList<Node>();
        int i = 0;
        while (i < size) {
            String item = items[i];
            int level = getLevel(item);
            boolean isFile = isFile(item);
            if (stack.isEmpty()) {
                Node next = new Node(level, item.length() - level, isFile(item));
                if (next.isFile) {
                    res = Math.max(res, item.length() - level);
                } else {
                    stack.push(next);
                }
            } else {
                Node tmp = stack.peek();
                if (tmp.level + 1 == level) {
                    // + 1是路径分隔符，"/"
                    Node next = new Node(level, item.length() - level + tmp.length + 1, isFile(item));
                    if (next.isFile) {
                        // 文件节点不压栈
                        res = Math.max(res, next.length);
                    } else {
                        stack.push(next);
                    }
                } else {
                    stack.pop();
                    continue;
                }
            }
            i++;
        }
        return res;
    }

    private boolean isFile(String str) {
        return str.indexOf(".") != -1;
    }

    private int getLevel(String str) {
        StringBuilder builder = new StringBuilder();
        int count = 0;
        for (int i = 0; i < str.length(); ++i) {
            builder.append("\t");
            if (!str.startsWith(builder.toString())) {
                return count;
            }
            count++;
        }
        return -1;
    }

    private static class Node {
        private int level;
        private int length;
        private boolean isFile;

        public Node(int level, int length) {
            this.level = level;
            this.length = length;
            this.isFile = false;
        }

        public Node(int level, int length, boolean isFile) {
            this.level = level;
            this.length = length;
            this.isFile = isFile;
        }
    }

}
