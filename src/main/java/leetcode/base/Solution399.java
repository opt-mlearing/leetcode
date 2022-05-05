package leetcode.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 399. 除法求值
 * https://leetcode-cn.com/problems/evaluate-division/
 */
public class Solution399 {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int size = equations.size();
        Map<String, Integer> map = new HashMap<String, Integer>(size * 2);
        int index = 0;
        UnionFind unionFind = new UnionFind(size * 2);
        for (int i = 0; i < equations.size(); ++i) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            if (!map.containsKey(a)) {
                map.put(a, index++);
            }
            if (!map.containsKey(b)) {
                map.put(b, index++);
            }
            unionFind.union(map.get(a), map.get(b), values[i]);
        }
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); ++i) {
            String strA = queries.get(i).get(0);
            String strB = queries.get(i).get(1);
            int a = map.getOrDefault(strA, -1);
            int b = map.getOrDefault(strB, -1);
            if (a == -1 || b == -1) {
                res[i] = -1.0d;
            } else {
                res[i] = unionFind.isConnect(a, b);
            }
        }
        return res;
    }

    private static class UnionFind {
        private int[] parent;
        private double[] weight;

        public UnionFind(int size) {
            parent = new int[size];
            weight = new double[size];
            for (int i = 0; i < size; ++i) {
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }

        public void union(int x, int y, double value) {
            int parentX = find(x);
            int parentY = find(y);
            if (parentX == parentY) {
                return;
            }
            parent[parentX] = parentY;
            weight[parentX] = weight[y] * value / weight[x];
        }

        public int find(int x) {
            if (x != parent[x]) {
                int origin = parent[x];
                parent[x] = find(parent[x]);
                weight[x] *= weight[origin];
            }
            return parent[x];
        }

        public double isConnect(int x, int y) {
            int pX = find(x);
            int pY = find(y);
            if (pX == pY) {
                return weight[x] / weight[y];
            } else {
                return -1.0d;
            }
        }
    }

}
