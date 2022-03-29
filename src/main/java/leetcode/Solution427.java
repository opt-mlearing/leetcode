package leetcode;

/**
 * 建立四叉树
 * https://leetcode-cn.com/problems/construct-quad-tree/
 */
public class Solution427 {

    public Node construct(int[][] grid) {
        return dfs(grid, 0, grid.length - 1, 0, grid[0].length - 1);
    }

    private Node dfs(int[][] grid, int left, int right, int up, int down) {
        if (isGridLeaf(grid, left, right, up, down)) {
            return new Node(grid[up][left] == 1, true);
        }
        Node root = new Node(grid[up][left] == 0, false);
        int midX = (left + right) >> 1;
        int midY = (up + down) >> 1;
        root.topLeft = dfs(grid, left, midX, up, midY);
        root.topRight = dfs(grid, midX + 1, right, up, midY);
        root.bottomLeft = dfs(grid, left, midX, midY + 1, down);
        root.bottomRight = dfs(grid, midX + 1, right, midY + 1, down);
        return root;
    }

    private boolean isGridLeaf(int[][] grid, int xStart, int xEnd, int yStart, int yEnd) {
        int pre = -1;
        for (int i = yStart; i <= yEnd; ++i) {
            for (int j = xStart; j <= xEnd; ++j) {
                if (pre == -1) {
                    pre = grid[i][j];
                } else {
                    if (pre != grid[i][j]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

}
