package leetcode.base;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 677. 键值映射
 * https://leetcode.cn/problems/map-sum-pairs/
 */
public class Solution677 {

    private Solution677[] children;
    private boolean isEnd;
    private int val;

    public Solution677() {
        this.children = new Solution677[26];
        this.isEnd = false;
        this.val = 0;
    }

    public void insert(String key, int val) {
        Solution677 node = this;
        for (int i = 0; i < key.length(); ++i) {
            int index = key.charAt(i) - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Solution677();
            }
            node = node.children[index];
        }
        node.isEnd = true;
        node.val = val;
    }

    public int sum(String prefix) {
        Solution677 node = this;
        int res = 0;
        for (int i = 0; i < prefix.length(); ++i) {
            int index = prefix.charAt(i) - 'a';
            if (node.children[index] == null) {
                return res;
            }
            node = node.children[index];
        }
        Deque<Solution677> stack = new LinkedList<Solution677>();
        stack.offer(node);
        while (!stack.isEmpty()) {
            Solution677 mapSum = stack.poll();
            if (mapSum.isEnd) {
                res += mapSum.val;
            }
            for (int i = 0; i < 26; ++i) {
                if (mapSum.children[i] != null) {
                    stack.offer(mapSum.children[i]);
                }
            }
        }
        return res;
    }

}
