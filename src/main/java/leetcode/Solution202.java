package leetcode;

/**
 * 快乐数
 * https://leetcode-cn.com/problems/happy-number/
 */
public class Solution202 {

    // 两个链表是否存在相交，快慢指针.
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);
        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }

    private int getNext(int n) {
        int res = 0;
        while (n != 0) {
            int tmp = n % 10;
            res += tmp * tmp;
            n = n / 10;
        }
        return res;
    }

}
