package leetcode.base;

import java.util.Arrays;

/**
 * 1455. 检查单词是否为句中其他单词的前缀
 * https://leetcode.cn/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/
 *
 * @author: caogl
 * @date: 2022/6/15, 10:31
 **/
public class Solution1455 {

    // kmp。
    public int isPrefixOfWord(String sentence, String searchWord) {
        int size = searchWord.length();
        int[] fail = new int[size];
        // 前缀表.
        Arrays.fill(fail, -1);
        for (int i = 1, j = -1; i < size; ++i) {
            while (j > -1 && (searchWord.charAt(i) != searchWord.charAt(j + 1))) {
                j = fail[j];
            }
            if (searchWord.charAt(i) == searchWord.charAt(j + 1)) {
                j++;
            }
            fail[i] = j;
        }
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; ++i) {
            if (isPrefix(words[i], searchWord, fail)) {
                return i + 1;
            }
        }
        return -1;
    }

    private boolean isPrefix(String word, String pattern, int[] preTable) {
        for (int i = 0, j = -1; i < word.length(); ++i) {
            if (j > -1 && word.charAt(i) != pattern.charAt(j + 1)) {
                j = preTable[j];
            }
            if (word.charAt(i) == pattern.charAt(j + 1)) {
                j++;
            }
            if (j == pattern.length() - 1) {
                return j == i;
            }
        }
        return false;
    }


    // 字典树,trie.
    public int isPrefixOfWord_trie(String sentence, String searchWord) {
        if (sentence == null) {
            return -1;
        }
        Trie trie = new Trie();
        String[] split = sentence.split(" ");
        int size = split.length;
        for (int i = 0; i < size; ++i) {
            trie.insert(split[i]);
            if (trie.isPrefix(searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }

    private static class Trie {
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

        public boolean isPrefix(String word) {
            if (word == null) {
                return false;
            }
            Trie node = this;
            for (int i = 0; i < word.length(); ++i) {
                int index = word.charAt(i) - 'a';
                if (node.children[index] == null) {
                    return false;
                }
                node = node.children[index];
            }
            return node != null ? true : false;
        }

    }

    // 利用String的API.
    public int isPrefixOfWord_API(String sentence, String searchWord) {
        if (sentence == null || sentence.length() == 0) {
            return -1;
        }
        String[] split = sentence.split(" ");
        int size = split.length;
        for (int i = 0; i < size; ++i) {
            if (split[i].startsWith(searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }

}
