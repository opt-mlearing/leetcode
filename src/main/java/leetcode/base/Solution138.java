package leetcode.base;

import java.util.HashMap;
import java.util.Map;

/**
 * 138. 复制带随机指针的链表
 * https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 */
public class Solution138 {

    private Map<Node, Node> mapping = new HashMap<Node, Node>();

    // 肯定需要hash表的结构缓存拷贝对象. 不要想多了，什么spring循环引用，想多了.
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        Node node = mapping.get(head);
        if (node == null) {
            node = new Node(head.val);
            mapping.put(head, node);
            node.next = copyRandomList(head.next);
            node.random = copyRandomList(head.random);
        }
        return node;
    }

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}
