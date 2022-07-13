package leetcode.base;

import java.util.HashSet;
import java.util.Set;

/**
 * 729. 我的日程安排表 I
 * https://leetcode.cn/problems/my-calendar-i/
 *
 * @author caogaoli
 * @date 2022/7/13 15:08
 */
public class Solution729 {

    private Set<Integer> tree;
    private Set<Integer> book;

    public Solution729() {
        this.tree = new HashSet<Integer>();
        this.book = new HashSet<Integer>();
    }

    public boolean book(int start, int end) {
        if (query(start, end - 1, 0, 0, 1000000000)) {
            return false;
        }
        update(start, end - 1, 0, 0, 1000000000);
        return true;
    }

    private boolean query(int start, int end, int root, int left, int right) {
        if (book.contains(root)) {
            return true;
        }
        if (end < left || start > right) {
            return false;
        } else if (start <= left && right <= end) {
            return tree.contains(root);
        } else {
            int leftNode = root * 2 + 1;
            int rightNode = root * 2 + 2;
            int mid = left + (right - left) / 2;
            if (mid >= end) {
                return query(start, end, leftNode, left, mid);
            } else if (mid < start) {
                return query(start, end, rightNode, mid + 1, right);
            } else {
                return query(start, end, leftNode, left, mid) || query(start, end, rightNode, mid + 1, right);
            }
        }
    }

    private void update(int start, int end, int root, int left, int right) {
        if (start > right || left > end) {
            return;
        }
        if (start <= left && right <= end) {
            tree.add(root);
            book.add(root);
        } else {
            int mid = left + (right - left) / 2;
            int leftNode = root * 2 + 1;
            int rightNode = root * 2 + 2;
            update(start, end, leftNode, left, mid);
            update(start, end, rightNode, mid + 1, right);
            tree.add(root);
        }
    }

}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
