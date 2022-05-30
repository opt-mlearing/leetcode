package leetcode.offer;

import java.util.List;

/**
 * 剑指 Offer II 063. 替换单词
 * https://leetcode.cn/problems/UhWRSj/submissions/
 */
public class SolutionOffer_II_063 {

    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String word : dictionary) {
            trie.insert(word);
        }
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; ++i) {
            words[i] = trie.preRoot(words[i]);
        }
        return String.join(" ", words);
    }

    private static class Trie {
        private Trie[] child;
        private String word;

        public Trie() {
            this.child = new Trie[26];
            this.word = null;
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
            node.word = word;
        }

        public String preRoot(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); ++i) {
                int index = word.charAt(i) - 'a';
                if (node.child[index] == null) {
                    return word;
                }
                node = node.child[index];
                if (node.word != null) {
                    return node.word;
                }
            }
            return word;
        }
    }

}
