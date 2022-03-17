package leetcode;

/**
 * 实现 Trie (前缀树)
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 */
public class Trie208 {

    private Trie208[] children;
    private boolean isEnd;

    public Trie208() {
        // 大写字母
        children = new Trie208[52];
        isEnd = false;
    }

    public void insert(String word) {
        Trie208 node = this;
        for (int i = 0; i < word.length(); ++i) {
            int index = word.charAt(i) - 'a';
            // 若不存在子节点，则新建
            if (node.children[index] == null) {
                node.children[index] = new Trie208();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie208 node = getPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie208 node = getPrefix(prefix);
        return node != null;
    }

    public Trie208 getPrefix(String prefix) {
        Trie208 node = this;
        for (int i = 0; i < prefix.length(); ++i) {
            int index = prefix.charAt(i) - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }

}
