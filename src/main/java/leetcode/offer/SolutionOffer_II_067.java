package leetcode.offer;

/**
 * 剑指 Offer II 067. 最大的异或
 * https://leetcode.cn/problems/ms70jA/
 *
 * @author: caogl
 * @date: 2022/6/19, 18:45
 **/
public class SolutionOffer_II_067 {

    public int findMaximumXOR(int[] nums) {
        int res = 0;
        int size = nums.length;
        Trie trie = new Trie();
        for (int i = 0; i < size; ++i) {
            trie.insert(nums[i]);
            res = Math.max(res, trie.find(nums[i]));
        }
        return res;
    }

    private static class Trie {
        private Trie[] children;

        public Trie() {
            this.children = new Trie[2];
        }

        public void insert(int num) {
            Trie node = this;
            for (int i = 31; i >= 0; --i) {
                int index = (num >> i) & 1;
                if (node.children[index] == null) {
                    node.children[index] = new Trie();
                }
                node = node.children[index];
            }
        }

        public int find(int num) {
            Trie node = this;
            int value = 0;
            for (int i = 31; i >= 0; --i) {
                int index = (num >> i) & 1;
                index ^= 1;
                if (node.children[index] == null) {
                    index ^= 1;
                } else {
                    value |= (1 << i);
                }
                node = node.children[index];
            }
            return value;
        }
    }

}
