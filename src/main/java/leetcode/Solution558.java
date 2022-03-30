package leetcode;

/**
 * 四叉树交集
 * https://leetcode-cn.com/problems/logical-or-of-two-binary-grids-represented-as-quad-trees/
 */
public class Solution558 {

    // 1.当遇到叶子节点的时候 叶子节点为True 合并结果为叶子节点
    // 否则 合并结果为对方节点(不管对方是不是叶子节点,可能是一个子树,可能是一个真叶子节点,也可能是一个假叶子节点)
    // 2.当遇到的不是叶子节点 要进行递归
    // 3.最终进行判断 判断一个叶子节点的父节点所包含的四个节点是否都为 True 或者 False
    // 是的话合并为该父节点(val 决定于 四个节点的值)
    public Node intersect(Node quadTree1, Node quadTree2) {
        if (quadTree1.isLeaf) {
            if (quadTree1.val) {
                return quadTree1;
            }
            return quadTree2;
        } else if (quadTree2.isLeaf) {
            if (quadTree2.val) {
                return quadTree2;
            }
            return quadTree1;
        }
        Node topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
        Node topRight = intersect(quadTree1.topRight, quadTree2.topRight);
        Node bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
        Node bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);
        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf
                && topLeft.val == topRight.val && topRight.val == bottomLeft.val && bottomLeft.val == bottomRight.val) {
            return new Node(topLeft.val, true, null, null, null, null);
        }
        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }

    private static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
        }

        public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    }

}
