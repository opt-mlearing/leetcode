package leetcode.base;

/**
 * 211. 添加与搜索单词 - 数据结构设计
 * https://leetcode-cn.com/problems/design-add-and-search-words-data-structure/
 */
public class WordDictionary211 {

    private WordDictionary211[] children;
    private boolean isEnd;

    public WordDictionary211() {
        this.children = new WordDictionary211[26];
        this.isEnd = false;
    }

    public void addWord(String word) {
        WordDictionary211 node = this;
        for (int i = 0; i < word.length(); ++i) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                node.children[index] = new WordDictionary211();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        return doSearch(word, 0, this);
    }

    private boolean doSearch(String word, int index, WordDictionary211 node) {
        if (index == word.length()) {
            return node.isEnd;
        }
        char tmp = word.charAt(index);
        if (Character.isLetter(tmp)) {
            if (node.children[word.charAt(index) - 'a'] == null) {
                return false;
            }
            return doSearch(word, index + 1, node.children[word.charAt(index) - 'a']);
        } else {
            for (int i = 0; i < node.children.length; ++i) {
                if (node.children[i] != null && doSearch(word, index + 1, node.children[i])) {
                    return true;
                }
            }
            return false;
        }
    }

}
