package leetcode.base;

/**
 * 421. 数组中两个数的最大异或值
 * https://leetcode.cn/problems/maximum-xor-of-two-numbers-in-an-array/
 *
 * @author: caogl
 * @date: 2022/6/19, 18:34
 **/
public class Solution421 {

    public int findMaximumXOR(int[] nums) {
        int size = nums.length;
        int res = 0;
        Trie trie = new Trie();
        for (int i = 0; i < size; ++i) {
            trie.insert(nums[i]);
            res = Math.max(trie.find(nums[i]), res);
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
            int res = 0;
            for (int i = 31; i >= 0; --i) {
                int index = (num >> i) & 1;
                index ^= 1;
                if (node.children[index] == null) {
                    index ^= 1;
                } else {
                    res |= (1 << i);
                }
                node = node.children[index];
            }
            return res;
        }
    }

    // 超出时间限制
    public int findMaximumXOR_time_out(int[] nums) {
        int size = nums.length;
        int res = 0;
        for (int i = 0; i < size - 1; ++i) {
            for (int j = i + 1; j < size; ++j) {
                res = Math.max(res, nums[i] ^ nums[j]);
            }
        }
        return res;
    }

}
