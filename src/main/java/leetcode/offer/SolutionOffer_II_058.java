package leetcode.offer;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer II 058. 日程表
 * https://leetcode.cn/problems/fi9suh/
 *
 * @author caogaoli
 * @date 2022/7/13 15:46
 */
class SolutionOffer_II_058 {

    private Set<Integer> tree;
    private Set<Integer> isBook;

    public SolutionOffer_II_058() {
        tree = new HashSet<Integer>();
        isBook = new HashSet<Integer>();
    }

    public boolean book(int start, int end) {
        if (check(start, end - 1, 0, 0, 1000000000)) {
            return false;
        }
        update(start, end - 1, 0, 0, 1000000000);
        return true;
    }

    private boolean check(int start, int end, int root, int left, int right) {
        if (isBook.contains(root)) {
            return true;
        }
        if (start > right || end < left) {
            return false;
        } else if (start <= left && right <= end) {
            return tree.contains(root);
        } else {
            int leftN = 2 * root + 1;
            int rightN = 2 * root + 2;
            int mid = left + (right - left) / 2;
            if (mid >= end) {
                return check(start, end, leftN, left, mid);
            } else if (mid < start) {
                return check(start, end, rightN, mid + 1, right);
            } else {
                return check(start, end, leftN, left, mid) || check(start, end, rightN, mid + 1, right);
            }
        }
    }

    private void update(int start, int end, int root, int left, int right) {
        if (start > right || end < left) {
            return;
        } else if (start <= left && right <= end) {
            tree.add(root);
            isBook.add(root);
        } else {
            int leftN = root * 2 + 1;
            int rightN = root * 2 + 2;
            int mid = left + (right - left) / 2;
            update(start, end, leftN, left, mid);
            update(start, end, rightN, mid + 1, right);
            tree.add(root);
        }
    }

}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
