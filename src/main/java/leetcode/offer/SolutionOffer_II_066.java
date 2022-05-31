package leetcode.offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer II 066. 单词之和
 * https://leetcode.cn/problems/z1R5dt/
 */
public class SolutionOffer_II_066 {

    private SolutionOffer_II_066[] child;
    private boolean isEnd;
    private int val;

    /**
     * Initialize your data structure here.
     */
    public SolutionOffer_II_066() {
        this.child = new SolutionOffer_II_066[26];
        this.isEnd = false;
        this.val = val;
    }

    public void insert(String key, int val) {
        SolutionOffer_II_066 node = this;
        for (int i = 0; i < key.length(); ++i) {
            int index = key.charAt(i) - 'a';
            if (node.child[index] == null) {
                node.child[index] = new SolutionOffer_II_066();
            }
            node = node.child[index];
        }
        node.isEnd = true;
        node.val = val;
    }

    // dfs.
    public int sum(String prefix) {
        SolutionOffer_II_066 node = this;
        for (int i = 0; i < prefix.length(); ++i) {
            int index = prefix.charAt(i) - 'a';
            if (node.child[index] == null) {
                return 0;
            }
            node = node.child[index];
        }
        return dfs(node);
    }

    // dfs.
    private int dfs(SolutionOffer_II_066 root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (root.isEnd) {
            sum += root.val;
        }
        for (int i = 0; i < 26; ++i) {
            // 这个减下枝.
            if (root.child[i] != null) {
                sum += dfs(root.child[i]);
            }
        }
        return sum;
    }

    // bfs.
    public int sum_bfs(String prefix) {
        SolutionOffer_II_066 node = this;
        for (int i = 0; i < prefix.length(); ++i) {
            int index = prefix.charAt(i) - 'a';
            if (node.child[index] == null) {
                return 0;
            }
            node = node.child[index];
        }
        Deque<SolutionOffer_II_066> stack = new LinkedList<SolutionOffer_II_066>();
        stack.offer(node);
        int res = 0;
        while (!stack.isEmpty()) {
            SolutionOffer_II_066 subNode = stack.poll();
            if (subNode.isEnd) {
                res += subNode.val;
            }
            for (int i = 0; i < 26; ++i) {
                if (subNode.child[i] != null) {
                    stack.offer(subNode.child[i]);
                }
            }
        }
        return res;
    }

}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */