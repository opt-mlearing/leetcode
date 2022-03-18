package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 删除子文件夹.
 * https://leetcode-cn.com/problems/remove-sub-folders-from-the-filesystem/
 */
public class Solution1233 {

    public List<String> removeSubfolders(String[] folder) {
        Trie trie = new Trie();
        for (int i = 0; i < folder.length; ++i) {
            trie.insert(folder[i]);
        }
        List<String> res = new ArrayList<String>();
        for (int i = 0; i < folder.length; ++i) {
            String word = folder[i];
            if (trie.isSucceed(word)) {
                res.add(word);
            }
        }
        return res;
    }

    public static class Trie {

        private Map<String, Trie> children;
        private boolean isEnd;

        public Trie() {
            this.children = new HashMap<String, Trie>();
            this.isEnd = false;
        }

        public void insert(String str) {
            Trie node = this;
            String[] splitStr = str.split("/");
            for (int i = 0; i < splitStr.length; ++i) {
                if (node.children.get(splitStr[i]) == null) {
                    node.children.put(splitStr[i], new Trie());
                }
                node = node.children.get(splitStr[i]);
            }
            node.isEnd = true;
        }

        // 表示是否是其包含他路径的子路径.
        public boolean isSucceed(String str) {
            Trie node = this;
            String[] splitStr = str.split("/");
            for (int i = 0; i < splitStr.length; ++i) {
                String key = splitStr[i];
                // 注意，一定要手动剔除最后一个字符，因为肯定在的.
                if ((i != splitStr.length - 1) && (node.children.get(key).isEnd)) {
                    return false;
                }
                node = node.children.get(key);
            }
            return true;
        }
    }

}
