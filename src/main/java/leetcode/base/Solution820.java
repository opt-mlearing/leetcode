package leetcode.base;

import java.util.Arrays;

/**
 * 820. 单词的压缩编码
 * https://leetcode.cn/problems/short-encoding-of-words/submissions/
 */
public class Solution820 {

    // 先对words按照长度倒序排列.
    // 11ms/45.8mb
    public int minimumLengthEncoding(String[] words) {
        Trie trie = new Trie();
        int res = 0;
        Arrays.sort(words, (word1, word2) -> Integer.compare(word2.length(), word1.length()));
        for (String word : words) {
            boolean isPrefix = trie.isPrefix(word);
            if (!isPrefix) {
                res += word.length() + 1;
            }
            trie.insert(word);
        }
        return res;
    }

    private static class Trie {
        private Trie[] child;
        private boolean isEnd;

        public Trie() {
            this.child = new Trie[26];
            this.isEnd = false;
        }

        public void insert(String word) {
            Trie node = this;
            for (int i = word.length() - 1; i >= 0; --i) {
                int index = word.charAt(i) - 'a';
                if (node.child[index] == null) {
                    node.child[index] = new Trie();
                }
                node = node.child[index];
            }
            node.isEnd = true;
        }

        public boolean isPrefix(String word) {
            Trie node = this;
            for (int i = word.length() - 1; i >= 0; --i) {
                int index = word.charAt(i) - 'a';
                if (node.child[index] == null) {
                    return false;
                }
                node = node.child[index];
            }
            return node != null;
        }
    }

    private int res;

    // 17ms/46mb.
    // 这里求的是后缀，insert(word)的时候需要倒序.
    public int minimumLengthEncoding_1(String[] words) {
        TrieNode trieNode = new TrieNode();
        for (String word : words) {
            trieNode.insert(word);
        }
        res = 0;
        dfs(trieNode, 0);
        return res;
    }

    private void dfs(TrieNode root, int depth) {
        if (root == null) {
            return;
        }
        if (root.isEnd && isEmpty(root.child)) {
            res += depth + 1;
            return;
        }
        int res = 0;
        for (int i = 0; i < 26; ++i) {
            dfs(root.child[i], depth + 1);
        }
    }

    private boolean isEmpty(TrieNode[] child) {
        if (child == null) {
            return true;
        }
        for (TrieNode node : child) {
            if (node != null) {
                return false;
            }
        }
        return true;
    }

    private static class TrieNode {
        private TrieNode[] child;
        private boolean isEnd;

        public TrieNode() {
            this.child = new TrieNode[26];
            this.isEnd = false;
        }

        public void insert(String word) {
            TrieNode node = this;
            int size = word.length();
            for (int i = size - 1; i >= 0; --i) {
                int index = word.charAt(i) - 'a';
                if (node.child[index] == null) {
                    node.child[index] = new TrieNode();
                }
                node = node.child[index];
            }
            node.isEnd = true;
        }
    }

}
