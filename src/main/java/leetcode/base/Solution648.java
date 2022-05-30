package leetcode.base;

import java.util.List;

/**
 * 648. 单词替换
 * https://leetcode.cn/problems/replace-words/
 */
public class Solution648 {

    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (int i = 0; i < dictionary.size(); ++i) {
            trie.insert(dictionary.get(i));
        }
        StringBuilder builder = new StringBuilder();
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; ++i) {
            builder.append(trie.perFixRoot(words[i])).append(" ");
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    private static class Trie {
        private Trie[] children;
        private boolean isEnd;
        private String root;

        public Trie() {
            this.children = new Trie[26];
            this.isEnd = false;
            this.root = null;
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
            node.root = word;
        }

        public String perFixRoot(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); ++i) {
                int index = word.charAt(i) - 'a';
                if (node.children[index] == null) {
                    return word;
                }
                node = node.children[index];
                if (node.isEnd) {
                    return node.root;
                }
            }
            return word;
        }
    }

}
