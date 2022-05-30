package leetcode.offer;

/**
 * 剑指 Offer II 064. 神奇的字典
 * https://leetcode.cn/problems/US1pGT/
 */
public class SolutionOffer_II_064 {

    private Trie trie;

    /**
     * Initialize your data structure here.
     */
    public SolutionOffer_II_064() {
        this.trie = new Trie();
    }

    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            this.trie.insert(word);
        }
    }

    public boolean search(String searchWord) {
        return dfs(searchWord, 0, searchWord.length(), 0, this.trie);
    }

    private boolean dfs(String word, int index, int size, int count, Trie node) {
        if (node == null) {
            return false;
        }
        if (node.isEnd && index == size && count == 1) {
            return true;
        }
        if (count <= 1 && index < size) {
            boolean state = false;
            for (int i = 0; i < 26 && !state; ++i) {
                int pos = word.charAt(index) - 'a';
                int nextCount = (pos == i ? count : count + 1);
                state = dfs(word, index + 1, size, nextCount, node.child[i]);
            }
            return state;
        }
        return false;
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
            for (int i = 0; i < word.length(); ++i) {
                int index = word.charAt(i) - 'a';
                if (node.child[index] == null) {
                    node.child[index] = new Trie();
                }
                node = node.child[index];
            }
            node.isEnd = true;
        }
    }

}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */
