package algorithm4.sort2;

/**
 * 并查集
 */
public class UnionFind {

    // 连通分量个数.
    private int count;
    // 若干树.
    private int[] parent;
    // 树的重量
    private int[] size;

    public UnionFind(int count) {
        this.count = count;
        this.parent = new int[count];
        this.size = new int[count];
        for (int i = 0; i < count; ++i) {
            this.parent[i] = i;
            this.size[i] = 1;
        }
    }

    private int count() {
        return this.count;
    }

    private int find(int x) {
        while (parent[x] != x) {
            // 进行路径压缩.
            // 如果存在可压缩空间，至少有两层.
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    private boolean connect(int p, int q) {
        int parentP = parent[p];
        int parentQ = parent[q];
        return parentP == parentQ;
    }

    private void union(int p, int q) {
        int parentP = find(p);
        int parentQ = find(q);
        if (parentP == parentQ) {
            return;
        }
        if (size[parentP] > size[parentQ]) {
            parent[parentQ] = parentP;
            size[parentP] += size[parentQ];
        } else {
            parent[parentQ] = parentQ;
            size[parentQ] += size[parentP];
        }
    }

}
