package leetcode.offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer II 041. 滑动窗口的平均值
 * https://leetcode.cn/problems/qIsx9U/
 */
public class SolutionOffer_II_041 {

    // 注意sum需要设置成double类型，要不就整除.
    private double sum;
    private Deque<Integer> stack;
    private int size;

    /**
     * Initialize your data structure here.
     */
    public SolutionOffer_II_041(int size) {
        this.sum = 0.;
        this.stack = new LinkedList<Integer>();
        this.size = size;
    }

    public double next(int val) {
        this.sum += val;
        this.stack.offer(val);
        while (this.stack.size() > this.size) {
            int tmp = this.stack.pop();
            this.sum = this.sum - tmp;
        }
        return this.sum / stack.size();
    }

}
