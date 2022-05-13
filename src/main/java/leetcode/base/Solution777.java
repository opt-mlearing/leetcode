package leetcode.base;

/**
 * 777. 在LR字符串中交换相邻字符
 * https://leetcode.cn/problems/swap-adjacent-in-lr-string/
 */
public class Solution777 {

    public boolean canTransform(String start, String end) {
        int l1 = 0;
        int l2 = 0;
        while (l1 < start.length() || l2 < end.length()) {
            while (l1 < start.length() && start.charAt(l1) == 'X') {
                l1++;
            }
            while (l2 < end.length() && end.charAt(l2) == 'X') {
                l2++;
            }
            if ((l1 < start.length()) ^ (l2 < end.length())) {
                return false;
            }
            // 每次移动操作一定是将'L'向左移动或者将'R'向右移动，
            // 因此在任意次数的移动操作之后，每个'L'的位置一定是不变或左移，
            // 每个 'R' 的位置一定是不变或右移，
            // 不可能出现'L'的位置右移或者'R'的位置左移的情况.
            if (l1 < start.length() && l2 < end.length()) {
                if (start.charAt(l1) != end.charAt(l2)
                        || (start.charAt(l1) == 'L' && l1 < l2)
                        || (start.charAt(l1) == 'R' && l1 > l2)) {
                    return false;
                }
            }
            l1++;
            l2++;
        }
        return true;
    }

}
