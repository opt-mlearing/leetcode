package leetcode.base;

/**
 * 676. 实现一个魔法字典
 * https://leetcode.cn/problems/implement-magic-dictionary/
 */
public class Solution676 {

    private Solution676[] child;
    private boolean isEnd;

    public Solution676() {
        this.child = new Solution676[26];
        this.isEnd = false;
    }

    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            Solution676 node = this;
            for (int i = 0; i < word.length(); ++i) {
                int index = word.charAt(i) - 'a';
                if (node.child[index] == null) {
                    node.child[index] = new Solution676();
                }
                node = node.child[index];
            }
            node.isEnd = true;
        }
    }

    public boolean search(String searchWord) {
        return dfs(this, searchWord, searchWord.length(), 0, 0);
    }

    private boolean dfs(Solution676 root, String word, int size, int index, int count) {
        if (root == null) {
            return false;
        }
        if (root.isEnd && index == size && count == 1) {
            return true;
        }
        if (index < size && count <= 1) {
            boolean state = false;
            for (int i = 0; i < 26 && !state; ++i) {
                int j = word.charAt(index) - 'a';
                int nextCount = (i == j ? count : count + 1);
                state = dfs(root.child[i], word, size, index + 1, nextCount);
            }
            return state;
        }
        return false;
    }

}
