package leetcode.base;

import java.util.HashMap;
import java.util.Map;

/**
 * 947. 移除最多的同行或同列石头
 * https://leetcode-cn.com/problems/most-stones-removed-with-same-row-or-column/
 */
public class Solution947 {

    public int removeStones(int[][] stones) {
        int size = stones.length;
        UnionFind unionFind = new UnionFind();
        for (int[] stone : stones) {
            // 0 <= xi, yi <= 10000
            // unionFind.union(stone[0]+ 10001, stone[1]);
            // unionFind.union(stone[0], stone[1]+ 10001);
            unionFind.union(~stone[0], stone[1]);
        }
        return size - unionFind.count;
    }

    private static class UnionFind {
        private Map<Integer, Integer> parent;
        private int count;

        public UnionFind() {
            parent = new HashMap<Integer, Integer>();
            count = 0;
        }

        public int find(int x) {
            if (!parent.containsKey(x)) {
                parent.put(x, x);
                count++;
            }
            if (x != parent.get(x)) {
                parent.put(x, find(parent.get(x)));
            }
            return parent.get(x);
        }

        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px == py) {
                return;
            }
            parent.put(px, py);
            count--;
        }
    }

}
