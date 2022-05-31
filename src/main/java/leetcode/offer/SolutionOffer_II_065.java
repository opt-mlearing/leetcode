package leetcode.offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer II 065. 最短的单词编码
 * https://leetcode.cn/problems/iSwD2y/
 */
public class SolutionOffer_II_065 {

    public int minimumLengthEncoding(String[] words) {
        TrieNode trieNode = new TrieNode();
        for (String word : words) {
            trieNode.insert(word);
        }
        Deque<TrieNode> stack = new LinkedList<TrieNode>();
        stack.offer(trieNode);
        int res = 0;
        while (!stack.isEmpty()) {
            TrieNode node = stack.poll();
            if (node.isEnd && !hasChild(node.child)) {
                res += node.word.length() + 1;
            }
            for (int i = 0; i < 26; ++i) {
                TrieNode child = node.child[i];
                if (child != null) {
                    stack.offer(child);
                }
            }
        }
        return res;
    }

    private boolean hasChild(TrieNode[] children) {
        for (TrieNode node : children) {
            if (node != null) {
                return true;
            }
        }
        return false;
    }

    private static class TrieNode {
        private TrieNode[] child;
        private boolean isEnd;
        private String word;

        public TrieNode() {
            this.child = new TrieNode[26];
            this.isEnd = false;
            this.word = null;
        }

        // 题目中求的是后缀，与原始的trie前缀有区别.
        public void insert(String word) {
            TrieNode node = this;
            for (int i = word.length() - 1; i >= 0; --i) {
                int index = word.charAt(i) - 'a';
                if (node.child[index] == null) {
                    node.child[index] = new TrieNode();
                }
                node = node.child[index];
            }
            node.isEnd = true;
            node.word = word;
        }
    }

}
