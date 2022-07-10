package leetcode.typical;

/**
 * 面试题 05.01. 插入
 * https://leetcode.cn/problems/insert-into-bits-lcci/
 *
 * @author: caogl
 * @date: 2022/7/10, 11:43
 **/
public class Solution05_01 {

    public int insertBits(int N, int M, int i, int j) {
        // 先把N中i~j的位置全部置0.
        for (int index = i; index <= j; ++index) {
            N &= ~(1 << index);
        }
        // 再把M左移动i位后加上N.
        return N + (M << i);
    }

}
