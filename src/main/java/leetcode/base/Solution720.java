package leetcode.base;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 词典中最长的单词
 * https://leetcode-cn.com/problems/longest-word-in-dictionary/
 */
class Solution720 {

    // 通过字典树解决.
    public String longestWord_by_tris(String[] words) {
        Trie trie = new Trie();
        for (int i = 0; i < words.length; ++i) {
            trie.insert(words[i]);
        }
        String res = "";
        for (int i = 0; i < words.length; ++i) {
            String word = words[i];
            if (trie.search(word)) {
                // 注意比较下，同长字符串的字母序.
                if (word.length() > res.length() || (word.length() == res.length() && word.compareTo(res) < 0)) {
                    res = word;
                }
            }
        }
        return res;
    }

    // 使用字典树实现.
    public static class Trie {
        private Trie[] children;
        private boolean isEnd;

        public Trie() {
            this.children = new Trie[26];
            this.isEnd = false;
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
        }

        public boolean search(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); ++i) {
                int index = word.charAt(i) - 'a';
                // || 之后是精华所在，扣题，单词"world"可由"w", "wo", "wor", 和 "worl"逐步添加一个字母组成
                // 所以，遍历过程中的每一个节点都同时是尾节点.
                if (node.children[index] == null || !node.children[index].isEnd) {
                    return false;
                }
                node = node.children[index];
            }
            return node != null && node.isEnd;
        }
    }

    // 利用String内置函数.
    public String longestWord_by_string_function(String[] words) {
        Arrays.sort(words, (a, b) -> {
            if (a.length() != b.length()) {
                // 字符串长度升序
                return a.length() - b.length();
            } else {
                // 字母降序
                return -a.compareTo(b);
            }
        });
        Set<String> sets = new HashSet<String>();
        String res = "";
        sets.add(res);
        for (int i = 0; i < words.length; ++i) {
            String word = words[i];
            if (sets.contains(word.substring(0, word.length() - 1))) {
                sets.add(word);
                res = word;
            }
        }
        return res;
    }

}