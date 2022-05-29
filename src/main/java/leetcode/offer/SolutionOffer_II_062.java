package leetcode.offer;

/**
 * 剑指 Offer II 062. 实现前缀树
 * https://leetcode.cn/problems/QC3q1f/
 */
public class SolutionOffer_II_062 {

    private SolutionOffer_II_062[] children;
    private boolean isEnd;

    /**
     * Initialize your data structure here.
     */
    public SolutionOffer_II_062() {
        this.children = new SolutionOffer_II_062[26];
        this.isEnd = false;
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        SolutionOffer_II_062 node = this;
        for (int i = 0; i < word.length(); ++i) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                node.children[index] = new SolutionOffer_II_062();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        SolutionOffer_II_062 node = getPrefix(word);
        return node != null && node.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return getPrefix(prefix) != null;
    }

    private SolutionOffer_II_062 getPrefix(String word) {
        SolutionOffer_II_062 node = this;
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
