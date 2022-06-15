package leetcode.typical;

/**
 * 面试题 16.02. 单词频率
 * https://leetcode.cn/problems/words-frequency-lcci/
 *
 * @author: caogl
 * @date: 2022/6/15, 22:17
 **/
public class Solution16_02 {

    private Trie trie;

    public Solution16_02(String[] book) {
        this.trie = new Trie();
        for (String word : book) {
            this.trie.insert(word);
        }
    }

    public int get(String word) {
        Trie sub = this.trie.nodes(word);
        return sub == null ? 0 : sub.count;
    }

    private static class Trie {
        private Trie[] children;
        private boolean isEnd;
        private int count;

        public Trie() {
            this.children = new Trie[26];
            this.isEnd = false;
            this.count = 0;
        }

        public void insert(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); ++i) {
                int index = word.charAt(i) - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new Trie();
                }
                node = node.children[index];
            }
            node.isEnd = true;
            node.count++;
        }

        public Trie nodes(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); ++i) {
                int index = word.charAt(i) - 'a';
                if (node.children[index] == null) {
                    return null;
                }
                node = node.children[index];
            }
            return node;
        }
    }

}
